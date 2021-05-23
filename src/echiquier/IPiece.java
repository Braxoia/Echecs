package echiquier;

import pieces.Couleur;

/**
 * @author A.Ibrahime, B.Marco, P.Julie
 * @date 25/05/21
 * @brief Interface IPiece
 */
public interface IPiece {

	/**
     * @brief Permet de definir si un deplacement est possible
     * @return si le deplacement est autorise
     */
    boolean deplacementPossible(Echiquier echiquier, int[] coord);

    /**
     * @brief Permet de recuperer la couleur d'une piece
     * @return la couleur de la piece
     */
    Couleur getCouleur();

    /**
     * @brief Permet de recuperer les coordonnees d'une piece
     * @param echiquier l'echiquier courant
     * @param pieceCourante la piece dont on veut connaitre les coordonnees
     * @return les coordonnees de la piece
     */
    int[] coordPiece(Echiquier echiquier, IPiece pieceCourante);

    /**
     * @brief Permet de savoir si la piece est un roi
     * @return si la piece est un roi
     */
    boolean estUnRoi();
}
