package pieces;

import echiquier.Case;
import echiquier.Echiquier;

public interface IPiece {
    /*void manger(IPiece IPiece);
    void mortPiece(IPiece IPiece);*/
    boolean coupValide();
    void deplacer(Case caseSource, Case caseDestination);
    boolean deplacementPossible(Echiquier echiquier, int[] coord);

    /*static void déplacer(IPiece piece, Coordonnées coordonnées, Echiquier echiquier) {
        echiquier.getEchiquier()[coordonnées.getX()][coordonnées.getY()].setPiece(this);
        echiquier.getEchiquier()[piece.coord.getX()][piece.coord.getY()].setPiece(null);
    }*/
}
