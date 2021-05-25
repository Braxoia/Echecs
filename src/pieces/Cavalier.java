package pieces;

import echiquier.Echiquier;
import echiquier.IPiece;

public class Cavalier extends Piece {
    /**
     * @param couleur la couleur de la piece
     * @brief Constructeur d'un cavalier
     */
    public Cavalier(Couleur couleur) {
        super(couleur);
    }

    @Override
    public boolean deplacementPossible(Echiquier echiquier, int[] coord) {
        /**
         * Si il veut se déplacer de deux lignes
         *      Vérifier si il se déplace d'une colonne
         * Sinon si il veut se déplacer de deux colonnes
         *      Vérifier si il se déplace d'une ligne
         */

        IPiece[][] cases = echiquier.getCases();
        if(cases[coord[2]][coord[3]] != null &&
                this.getCouleur() == cases[coord[2]][coord[3]].getCouleur())
            return false;

        if(Math.abs(coord[2] - coord[0]) == 2) {
            return Math.abs(coord[3] - coord[1]) == 1;
        }
        else if (Math.abs(coord[3] - coord[1]) == 2) {
            return Math.abs(coord[2] - coord[0]) == 1;
        }

        return false;
    }

    @Override
    public boolean estUnRoi() {
        return false;
    }
}
