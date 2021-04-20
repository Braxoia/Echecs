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
    }

    @Override
    public boolean deplacementPossible(Echiquier echiquier) {
        return false;
    }

}
