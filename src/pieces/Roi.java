package pieces;

import echiquier.Echiquier;

public class Roi extends Piece {

    public Roi(Couleur couleur, Coordonnées coord, Echiquier echiquier) {
        super(couleur, coord, echiquier);
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
    public void deplacer(Coordonnées coordonnées, Echiquier echiquier) {
        /*if (colonne < 1 || colonne > 8 || ligne < 1 || ligne > 8)
            return false;
        if (Math.abs(this.getColonne() - colonne) != Math.abs(this.getLigne() - ligne))
            return false;
        int dx = this.getColonne() - colonne > 0 ? -1 : 1;
        int dy = this.getLigne() - ligne > 0 ? -1 : 1;
        for (int i = 1; i < Math.abs(this.getColonne() - colonne); ++i)
            if (e.estLibre(this.getColonne() + i * dx, this.getLigne() + i * dy))
                return false;
        return true; */

        echiquier.getEchiquier()[coord.getX()][coord.getY()].setPiece(null);
        echiquier.getEchiquier()[coordonnées.getX()][coordonnées.getY()].setPiece(this);
        coord.setX(coordonnées.getX());
        coord.setY(coordonnées.getY());
    }

    /*@Override
    public boolean deplacementPossible(Coordonnées coordonnées, Echiquier echiquier) {
        if(!dansLesLimites())
            return false;
        return true;
    }*/

}
