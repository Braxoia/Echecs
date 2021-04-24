package pieces;

import echiquier.Echiquier;

public abstract class Piece implements IPiece {
    protected Couleur couleur;

    /*public static final int MAX_COORD = 8;
    public static final int MIN_COORD = 0;*/

    public Piece(Couleur couleur, Echiquier echiquier) {
        this.couleur = couleur;
    }


}
