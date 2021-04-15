package pieces;

import echiquier.Echiquier;

public abstract class Piece implements IPiece {
    protected Couleur couleur;
    protected Coordonnées coord;
    /*public static final int MAX_COORD = 8;
    public static final int MIN_COORD = 0;*/

    public Piece(Couleur couleur, Coordonnées coord, Echiquier echiquier) {
        this.couleur = couleur;
        this.coord = coord;
        echiquier.getEchiquier()[coord.getX()][coord.getY()].setPiece(this);
    }


}
