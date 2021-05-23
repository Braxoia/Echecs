package pieces;

import echiquier.Echiquier;
import echiquier.IPiece;

/**
 * @author A.Ibrahime, B.Marco, P.Julie
 * @date 25/05/21
 * @brief Classe abstraite Piece
 */
public abstract class Piece implements IPiece {
	
	//La couleur de la piece
    private Couleur couleur;

    /**
     * @brief Constructeur d'une piece
     * @param couleur la couleur de la piece
     */
    public Piece(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
     * @brief Methode qui permet de recuperer la couleur d'une piece
     * @return la couleur de la piece
     */
    public Couleur getCouleur() {
        return couleur;
    }

    /**
     * @brief Methode qui permet de recuperer les coordonnees d'une piece
     * @param echiquier l'echiquier courant
     * @param piece la piece dont on veut connaitre les coordonnees
     * @return les coordonnees de la piece
     */
    public int[] coordPiece(Echiquier echiquier, IPiece piece) throws RuntimeException {
        for(int ligne = 0; ligne < Echiquier.MAX; ligne++){
            for(int colonne = 0; colonne < Echiquier.MAX; colonne++) {
                if(echiquier.getCases()[ligne][colonne] == piece) {
                    return new int[] {ligne, colonne};
                }
            }
        }
        throw new RuntimeException("La piece n'existe pas ");
    }
}
