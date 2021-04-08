package appli;

import echiquier.Echiquier;
import pieces.*;

public class Application {

    public static void main(String[] args) {
	    /*  TODO : On demande à l'utilisateur si c'est mode IA, mode Joueur VS IA ou mode 2 joueurs, Création du plateau
	    *    Si 2 joueurs : scanner pour les 2 comme le projet BPO Le Duel
	    *       Si joueur ne peut pas jouer sans créer une situation d'echec = echec et pat
	    *       Sinon l'obligé à jouer
	    *    Si 1 joueur : scanner uniquement pour le joueur, boucle simplifié car on a juste à étudier un joueur
	    *    Si 2 IA :  pas de scanner, tout est géré directement dans notre algo et on gère l'affichag
	    */


		Echiquier echiquier = new Echiquier();
		IPiece roi = new Roi("R", Couleur.BLANC, new Coordonnées(5,4), echiquier);
		IPiece tour = new Tour("t", Couleur.NOIR, new Coordonnées(0, 0), echiquier);
		roi.manger(tour);


		System.out.println(echiquier);

    }
}
