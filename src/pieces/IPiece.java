package pieces;

import echiquier.Echiquier;

public interface IPiece {
    void manger(IPiece IPiece);
    void mortPiece(IPiece IPiece);
    boolean coupValide();
    void deplacer(Coordonnées coordonnées, Echiquier echiquier);
    //boolean deplacementPossible(Coordonnées coordonnées, Echiquier echiquier);

    /*static void déplacer(IPiece piece, Coordonnées coordonnées, Echiquier echiquier) {
        echiquier.getEchiquier()[coordonnées.getX()][coordonnées.getY()].setPiece(this);
        echiquier.getEchiquier()[piece.coord.getX()][piece.coord.getY()].setPiece(null);
    }*/
}
