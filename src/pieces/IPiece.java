package pieces;

public interface IPiece {
    void manger(IPiece IPiece);
    void mortPiece(IPiece IPiece);
    boolean coupValide();
    void deplacer();
}
