package pieces;

import echiquier.Echiquier;

public class Tour extends Piece {
    public Tour(String nom, Couleur couleur, Coordonnées coord, Echiquier echiquier) {
        super(nom, couleur, coord, echiquier);
    }

    @Override
    public String toString() {
        if(couleur == Couleur.BLANC)
            return "T";
        else
            return "t";
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
