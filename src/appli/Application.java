package appli;

import echiquier.Echiquier;
import pieces.*;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
		/*  TODO : On demande à l'utilisateur si c'est mode IA, mode Joueur VS IA ou mode 2 joueurs, Création du plateau
		 *    Si 2 joueurs : scanner pour les 2 comme le projet BPO Le Duel
		 *       Si joueur ne peut pas jouer sans créer une situation d'echec = echec et pat
		 *       Sinon l'obligé à jouer
		 *    Si 1 joueur : scanner uniquement pour le joueur, boucle simplifié car on a juste à étudier un joueur
		 *    Si 2 IA :  pas de scanner, tout est géré directement dans notre algo et on gère l'affichage
		 */


		Echiquier echiquier = new Echiquier();
		IPiece tour = new Tour(Couleur.BLANC, new Coordonnées(2, 4), echiquier);
		//IPiece fou2 = new Fou (Couleur.BLANC, new Coordonnées(5,4), echiquier); Il écrase lorsque les deux sont sur la même coordonnées
		IPiece roi = new Roi(Couleur.BLANC, new Coordonnées(1, 1), echiquier);

		//roi.deplacer(new Coordonnées(6, 4), echiquier);
		//il faut faire en sorte que tab[2] et tab[3] soient les nouvelles coordonnées

		String saisie;
		int[] nvCoord = new int[2];
		System.out.println(echiquier);
		Scanner sc= new Scanner(System.in);
		saisie = sc.nextLine();
		while (Echiquier.coupsPossibles(saisie)) {
			nvCoord = echiquier.decompose(saisie);
			//à l'appel de la méthode déplacer, les nouvelles coordonnées donc tab[2] et tab[3]
			roi.deplacer(new Coordonnées(nvCoord[1], nvCoord[0]), echiquier);
			System.out.println(echiquier);
			saisie = sc.nextLine();

		}

		System.out.println(echiquier);
	}

}
