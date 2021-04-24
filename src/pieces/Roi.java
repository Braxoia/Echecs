package pieces;

import echiquier.Echiquier;
import echiquier.Case;

public class Roi extends Piece {

    public Roi(Couleur couleur, Echiquier echiquier) {
        super(couleur, echiquier);
    }

    @Override
    public String toString() {
        if(couleur == Couleur.BLANC)
            return "R";
        else
            return "r";
    }

    @Override
    public boolean coupValide() {
        return false;
    }

    @Override
    public void deplacer(Case caseSource, Case caseDestination) {
        caseDestination.setPiece(caseSource.getPiece());
        caseSource.setPiece(null);
    }

    @Override
    public boolean deplacementPossible(Echiquier echiquier, int[] coord) {
        if(Math.abs((coord[2] - coord[3]) - (coord[0] - coord[1])) > 2 ||
                    (coord[1] == coord[3] && coord[0] == coord[2]))
            return false;

        return true;
    }

}
