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
    public boolean deplacementPossible(Echiquier echiquier, int[] coord) {

        //TODO : Condition à régler pour le déplacement soit effectif

        /*if(coord[1]==coord[3] && (coord[2] < Echiquier.MIN || coord[2] >= Echiquier.MAX|| coord[2]==coord[0]) ){
            return false;
        }
        if(coord[0] == coord[2] && (coord[3] < Echiquier.MIN || coord[3] >= Echiquier.MAX || coord[3]!=coord[1])){
            return false;
        }
        return true; */


        /* if( (coord[1] == coord[3] && (coord[2] < Echiquier.MIN || coord[2] >= Echiquier.MAX|| coord[2] == coord[0])) ||
                (coord[0] == coord[2] && (coord[3] < Echiquier.MIN || coord[3] >= Echiquier.MAX || coord[3] != coord[1]))
        )*/

        if (coord[0] != coord[2] && coord[1] != coord[3] ||
                ( coord[0] == coord[2] && coord[1] == coord[3]) || ( coord[1] == coord[3] && coord[0] == coord[2]) )
            return false;

        return true;
    }

}
