package pieces;

import echiquier.Echiquier;

public class Tour extends Piece {
    public Tour(Couleur couleur, Coordonnées coord, Echiquier echiquier) {
        super(couleur, coord, echiquier);
    }

    @Override
    public String toString() {
        if(couleur == Couleur.BLANC)
            return "T";
        else
            return "t";
    }

    //useless mais à vérifier
    @Override
    public void manger(IPiece IPiece) {

    }

    @Override
    public boolean coupValide() {
        return false;
    }

    @Override
    public void deplacer(Coordonnées coordonnées, Echiquier echiquier) {
        echiquier.getEchiquier()[coord.getX()][coord.getY()].setPiece(null);
        echiquier.getEchiquier()[coordonnées.getX()][coordonnées.getY()].setPiece(this);
        coord.setX(coordonnées.getX());
        coord.setY(coordonnées.getY());
    }

    /*@Override
    public boolean deplacementPossible(Coordonnées coordonnées, Echiquier echiquier) {
        return false;
    }*/

}
