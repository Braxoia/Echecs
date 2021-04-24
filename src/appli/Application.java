package appli;

import echiquier.Echiquier;
import pieces.*;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		/* TODO : On demande à l'utilisateur si c'est mode IA, mode Joueur VS IA ou mode 2 joueurs, Création du plateau
		 *    Si 2 joueurs : scanner pour les 2 comme le projet BPO Le Duel
		 *       Si joueur ne peut pas jouer sans créer une situation d'echec = echec et pat
		 *       Sinon l'obligé à jouer
		 *    Si 1 joueur : scanner uniquement pour le joueur, boucle simplifié car on a juste à étudier un joueur
		 *    Si 2 IA :  pas de scanner, tout est géré directement dans notre algo et on gère l'affichage
		 **/

		Echiquier echiquier = new Echiquier();
		IPiece tour = new Tour(Couleur.BLANC, echiquier);
		echiquier.getEchiquier()[1][1].setPiece(tour);
		//IPiece fou2 = new Fou (Couleur.BLANC, new Coordonnées(5,4), echiquier); Il écrase lorsque les deux sont sur la même coordonnées
		IPiece roi = new Roi(Couleur.BLANC, echiquier);
		echiquier.getEchiquier()[5][4].setPiece(roi);

		String saisie;
		int[] coord = new int[4];
		System.out.println(echiquier);
		Scanner sc= new Scanner(System.in);
		saisie = sc.nextLine();


		/*while (Echiquier.saisieCorrecte(saisie)) {
			coord = echiquier.decompose(saisie);

			//ligne à gérer car exception possible
			//verifier qu'il y a bien une piece sur la case
			IPiece piece = echiquier.getEchiquier()[coord[0]][coord[1]].getPiece();
			if(!piece.deplacementPossible(echiquier, coord))
				continue;

			piece.deplacer(
					echiquier.getEchiquier()[coord[0]][coord[1]],
					echiquier.getEchiquier()[coord[2]][coord[3]]
			);

			System.out.println(echiquier);
			saisie = sc.nextLine();

		}*/

		System.out.println(echiquier);

		/*if(!tour.deplacementPossible(echiquier, new int[]{1, 1, 1, 7}))
			System.out.println("Eh mon gars va te faire");*/
		if(!roi.deplacementPossible(echiquier, new int[]{5, 4, 2, 3}))
			System.out.println("Eh mon gars va te faire");
	}

}