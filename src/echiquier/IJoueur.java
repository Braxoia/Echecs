package echiquier;

import jeu.Jeu;
import pieces.Couleur;
import pieces.FabriquePiece;

import java.util.ArrayList;

/**
 * @author A.Ibrahime, B.Marco, P.Julie
 * @date 25/05/21
 * @brief Interface IJoueur
 */
public interface IJoueur {
	
	/**
     * @brief Choisi aleatoirement des coordonnes pour effectuer un deplacement
     * @return les coordonnes utilisees pour le futur deplacement
     */
    int[] jouer(Jeu jeu);
    
    /**
     * @brief Recupere la couleur d'un joueur
     * @return la couleur du joueur
     */
    Couleur getCouleur();

    /**
     * @brief Supprime une piece mangee de la liste des pieces d'un joueur
     * @param piece la piece mangee a supprimer
     */
    void retirerPiece(IPiece piece);
    
    /**
     * @brief Permet de recuperer une piece precise d'un joueur
     * @param indice l'indice de la piece dans la liste des pieces du joueur
     * @return la piece
     */
    IPiece recupererPiece(int indice);

    /**
     * @brief Permet de recuperer toutes les pieces d'un joueur
     * @return la liste de toutes les pieces d'un joueur
     */
    IPiece[] recupererPieces();

    /**
     * @brief Verifie si il ne reste qu'un roi dans la liste des pieces d'un joueur
     * @return si la liste des pieces d'un joueur ne contient plus qu'un roi 
     */
    boolean aJusteUnRoi();
    
    /**
     * @brief Permet de savoir si le joueur actif est humain
     * @return si le joueur est un humain
     */
    boolean estUnHumain();
    
    /**
     * @brief Permet de savoir si le joueur actif est une IA
     * @return si le joueur est une IA
     */
    boolean estUneIA();

    /**
     * Methode qui recupere le mode de jeu
     * @return le mode de jeu du joueur
     */
    FabriquePiece.Mode getModeDeJeu();
}
