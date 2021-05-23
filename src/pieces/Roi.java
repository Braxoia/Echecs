package pieces;

import echiquier.Echiquier;
import echiquier.IPiece;

/**
 * @author A.Ibrahime, B.Marco, P.Julie
 * @date 25/05/21
 * @brief Classe Roi
 */
public class Roi extends Piece {

	/**
     * @brief Constructeur d'un roi 
     * @param couleur la couleur de la piece
     */
    public Roi(Couleur couleur) {
        super(couleur);
    }

    /**
     * @brief Recuperation du symbole de la piece
     * @return le symbole de la piece
     */
    @Override
    public String toString() {
        if(this.getCouleur() == Couleur.BLANC)
            return "R";
        else
            return "r";
    }

    /**
     * @brief Methode qui permet de definir si un deplacement est possible
     * @return si le deplacement est autorise
     */
    @Override
    public boolean deplacementPossible(Echiquier echiquier, int[] coord) {
        int coordDepart = Integer.parseInt(String.valueOf(coord[0]) + String.valueOf(coord[1]));
        int coordArrive = Integer.parseInt(String.valueOf(coord[2]) + String.valueOf(coord[3]));
        IPiece[][] cases = echiquier.getCases();

        if(cases[coord[2]][coord[3]] != null &&
                this.getCouleur() == cases[coord[2]][coord[3]].getCouleur())
            return false;

        if(coord[0] == coord[2] && coord[1] == coord[3])
        	return false; 
        
        //retourne un résultat unique, quelque soit la position du roi à partir des coordonnées de départ concaténées
        //et des coordonnées d'arrivée concaténées
        //le deplacement est possible si le resultat retourne une valeur comprise parmi les valeurs suivantes 
        return coordDepart - coordArrive == 1 || coordArrive - coordDepart == 9 || coordDepart - coordArrive == 11
                || coordArrive - coordDepart == 10 || coordArrive - coordDepart == 1 || coordArrive - coordDepart == 11
                || coordDepart - coordArrive == 10 || coordDepart - coordArrive == 9;
        
//      return Math.abs(coordDepart - coordArrive) == 1 || Math.abs(coordDepart - coordArrive) == 9
//       		|| Math.abs(coordDepart - coordArrive) == 11
//        		|| Math.abs(coordDepart - coordArrive) == 10;
    }

    /**
     * @brief Methode qui permet de savoir si la piece est un roi
     * @return si la piece est un roi 
     */
    @Override
    public boolean estUnRoi() {
        return true;
    }
}
