package pieces;

public abstract class Piece {
    private String nom;
    private Couleur couleur;

    public abstract boolean coupValide();
    public abstract void deplacer();

    public Piece(String nom, Couleur couleur) {
        this.nom = nom;
        this.couleur = couleur;
    }
}
