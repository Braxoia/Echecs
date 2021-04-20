package echiquier;

import pieces.IPiece;
import pieces.Piece;

public class Case {
    private IPiece piece;

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

    public void setPiece(IPiece piece) {
        this.piece = piece;
    }

    public IPiece getPiece() {
        return piece;
    }


}