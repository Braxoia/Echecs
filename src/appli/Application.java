package appli;

import echiquier.*;
import jeu.*;
import pieces.*;
import java.util.Scanner;

/**
 * @author A.Ibrahime, B.Marco, P.Julie
 * @date 25/05/21
 * @brief Classe principale
 */
public class Application {

	/**
	 * @brief Methode statique main du projet
	 * @param args argument recu lors de l'execution
	 * @throws Exception si le mode n'existe pas ou n'est pas implémenté
	 */
	public static void main(String[] args) throws Exception {

		IPiece piece;
		Jeu jeu;

		String saisieMode;
		String saisieSituation;

		int[] coord;
		int[] coordArrivee = new int[2];

		@SuppressWarnings("ressource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Choisissez la situation que vous désirer parmi les 3 choix (ouverture, milieu, finale)");
		saisieSituation = sc.nextLine();
		while(!(saisieSituation.trim().equalsIgnoreCase("ouverture") || saisieSituation.trim().equalsIgnoreCase("milieu") ||
				saisieSituation.trim().equalsIgnoreCase("finale"))) {
			saisieSituation = sc.nextLine();
		}

		Mode modeDeJeu;
		switch(saisieSituation.trim().toLowerCase()) {
			case "finale" : { modeDeJeu = Mode.FINALE; break; }
			case "ouverture" : { modeDeJeu = Mode.OUVERTURE; break; }
			default : { modeDeJeu = Mode.MILLIEU; }
		}

		System.out.println("Choisissez le premier et deuxieme joueur (HH pour humain/humain, IH pour IA/Humain, etc...)");
		saisieMode = sc.nextLine();
		while(!(saisieMode.trim().equalsIgnoreCase("HI") || saisieMode.trim().equalsIgnoreCase("IH") ||
				saisieMode.trim().equalsIgnoreCase("HH") || saisieMode.trim().equalsIgnoreCase("II"))) {
			saisieMode = sc.nextLine();
		}

		switch(saisieMode.trim().toUpperCase()) {
			case "HH" : { jeu = new Jeu(new Humain(Couleur.BLANC, modeDeJeu), new Humain(Couleur.NOIR, modeDeJeu)); break; }
			case "II" : { jeu = new Jeu(new IA(Couleur.BLANC, modeDeJeu), new IA(Couleur.NOIR, modeDeJeu)); break; }
			default : { jeu = new Jeu(new Humain(Couleur.BLANC, modeDeJeu), new IA(Couleur.NOIR, modeDeJeu)); }
		}

		System.out.println(jeu.getEchiquier());

		while (true)
		{
			if(jeu.getJoueurActif().estUnHumain())
			{
				System.out.println("C'est au tour du joueur " + jeu.getJoueurActif().getCouleur());
				coord = jeu.getJoueurActif().jouer(jeu);

				switch(coord[0]) {
					case -1: { System.out.println("Partie nulle !"); break; }
					case -2: { continue; }
					case -3: { System.out.println("Le joueur " + jeu.getJoueurActif().getCouleur() +
							" a perdu la partie !"); break; }
				}

				coordArrivee[0] = coord[2];
				coordArrivee[1] = coord[3];
				
				if(jeu.getEchiquier().getCases()[coord[0]][coord[1]] == null) {
					System.err.println("La piece n'existe pas a ses coordonnees !");
					continue;
				}

				piece = jeu.getEchiquier().getCases()[coord[0]][coord[1]];
				if (!piece.deplacementPossible(jeu.getEchiquier(), coord) ||
						piece.getCouleur() != jeu.getJoueurActif().getCouleur() ||
						jeu.getEchiquier().recuperationRoiAdverse(jeu, jeu.getJoueurActif().getCouleur()) != null 
						&& !jeu.getEchiquier().piecesAdversesCases(jeu, coord)) {
					System.err.println("La piece ne peut pas etre deplacee ici !");
					continue;
				}
				jeu.getEchiquier().jouerPartie(jeu, coord);
				if (etatPartie(piece, jeu, coordArrivee)) break;

			}
			else if (jeu.getJoueurActif().estUneIA()){
				coord = jeu.getJoueurActif().jouer(jeu);
				jeu.getEchiquier().jouerPartie(jeu,coord);
				coordArrivee[0] = coord[2];
				coordArrivee[1] = coord[3];
				IPiece pieceTrouver = jeu.getEchiquier().getCases()[coordArrivee[0]][coordArrivee[1]];

				if (etatPartie(pieceTrouver, jeu, coordArrivee)) break;
				Thread.sleep(2000);
			}
		}
	}
	
	/**
	 * @brief Methode renvoyant l'etat des joueurs
	 * @param piece la piece qu'on vient de deplacer
	 * @param jeu le jeu en cours
	 * @param coordArrivee les coordonnes d'arrivees de la piece deplacee
	 * @return si le joueur actif a perdu ou s'il y a match nul
	 */
	private static boolean etatPartie(IPiece piece, Jeu jeu, int[] coordArrivee) {

		switch(jeu.miseAJourPartie(piece, coordArrivee)) {
			case 1: {
				System.out.println("Le joueur " + jeu.getJoueurActif().getCouleur() + " a perdu !");
				return true;
			}
			case 2: {
				System.out.println("Le joueur " + jeu.getJoueurActif().getCouleur() + " est en echec !");
				break;
			}
			case 3: {
				System.out.println("C'est un match nul !");
				return true;
			}
			case 4: {
				System.out.println("C'est un echec et pat !");
				return true;
			}
		}
		return false;
	}
}
