package echiquier;

import pieces.Piece;

public class Case {
    private Piece piece;;

    public Case() {
        this.piece = null;
    }

    @Override
    public String toString() {
        if(this.piece == null)
            return " ";
        else
            return piece.toString();
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
