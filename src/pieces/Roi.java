package pieces;

import echiquier.Echiquier;

public class Roi extends Piece {
    public Roi(String nom, Couleur couleur, Coordonnées coord, Echiquier echiquier) {
        super(nom, couleur, coord, echiquier);
    }

    @Override
    public String toString() {
        if(couleur == Couleur.BLANC)
            return "R";
        else
            return "r";
    }

    @Override
    public void manger(IPiece IPiece) {

    }

    @Override
    public void mortPiece(IPiece IPiece) {

    }

    @Override
    public boolean coupValide() {
        return false;
    }

    @Override
    public void deplacer() {

    }
}
