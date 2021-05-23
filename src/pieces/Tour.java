package pieces;

import echiquier.Echiquier;

/**
 * @author A.Ibrahime, B.Marco, P.Julie
 * @date 25/05/21
 * @brief Classe Tour
 */
public class Tour extends Piece {
	
	/**
     * @brief Constructeur d'une tour
     * @param couleur la couleur de la piece
     */
    public Tour(Couleur couleur) {
        super(couleur);
    }

    /**
     * @brief Recuperation du symbole de la piece
     * @return le symbole de la piece
     */
    @Override
    public String toString() {
        if(this.getCouleur() == Couleur.BLANC)
            return "T";
        else
            return "t";
    }

    /**
     * @brief Methode qui permet de definir si un deplacement est possible
     * @return si le deplacement est autorise
     */
    @Override
    public boolean deplacementPossible(Echiquier echiquier, int[] coord) {

        int ligne = coord[0];
        int colonne = coord[1];

        if (coord[0] == coord[2] && coord[1] == coord[3])
            return false;

        //On verifie si la piece saute une autre piece :
        //On recupere les coordoonees d'arrivee de la piece et on regarde, entre la position actuelle de la piece et les coordonnes ou elle souhaite
        //aller si on rencontre une piece autre que soi
        //Si on rencontre une piece, peu importe sa couleur, le deplacement n'est pas accepte
        if(ligne == coord[2]) {
            if(colonne > coord[3]) {
                while(colonne > coord[3]) {
                    if(colonne != coord[1] && echiquier.getCases()[ligne][colonne] != null)
                        return false;
                    --colonne;
                }
            }
            while(colonne < coord[3]) {
                if(colonne != coord[1] && echiquier.getCases()[ligne][colonne] != null)
                    return false;
                ++colonne;
            }
        }
        else if (colonne == coord[3]) {
            if (ligne > coord[2]) {
                while (ligne > coord[2]) {
                    if (ligne != coord[0] && echiquier.getCases()[ligne][colonne] != null)
                        return false;
                    --ligne;
                }
            }
            while(ligne < coord[2]) {
                if (ligne != coord[0] && echiquier.getCases()[ligne][colonne] != null)
                    return false;
                ++ligne;
            }

        }

        if(echiquier.getCases()[coord[2]][coord[3]] != null &&
                this.getCouleur() == echiquier.getCases()[coord[2]][coord[3]].getCouleur())
            return false;

        return (coord[0] == coord[2] || coord[1] == coord[3]) && (coord[1] != coord[3] || coord[0] != coord[2]);
    }

    /**
     * @brief Methode qui permet de savoir si la piece est un roi
     * @return si la piece est un roi 
     */
    @Override
    public boolean estUnRoi() {
        return false;
    }
}