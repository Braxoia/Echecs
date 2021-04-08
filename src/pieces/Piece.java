package pieces;

import echiquier.Echiquier;

public abstract class Piece implements IPiece {
    protected String nom;
    protected Couleur couleur;
    protected Coordonnées coord;

    public Piece(String nom, Couleur couleur, Coordonnées coord, Echiquier echiquier) {
        this.nom = nom;
        this.couleur = couleur;
        this.coord = coord;
        echiquier.getEchiquier()[coord.getX()][coord.getY()].setPiece(this);
    }
}
