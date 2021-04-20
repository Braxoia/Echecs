package pieces;

import echiquier.Case;
import echiquier.Echiquier;

public class Tour extends Piece {
    public Tour(Couleur couleur, Echiquier echiquier) {
        super(couleur, echiquier);
    }

    @Override
    public String toString() {
        if(couleur == Couleur.BLANC)
            return "T";
        else
            return "t";
    }

    @Override
    public boolean coupValide() {
        return false;
    }


    @Override
    public void deplacer(Case caseSource, Case caseDestination) {
        
    }

    @Override
    public boolean deplacementPossible(Echiquier echiquier) {
        return false;
    }

}
