package jeu;

import echiquier.IJoueur;
import pieces.Couleur;
import echiquier.IPiece;

import java.util.*;

/**
 * @author A.Ibrahime, B.Marco, P.Julie
 * @date 25/05/21
 * @brief Classe abstraite Joueur
 */
public abstract class Joueur implements IJoueur {
	
	//Joueur defini par sa couleur et sa liste de pieces
    private Couleur couleur;
    private ArrayList<IPiece> pieces;
    private Mode modeDeJeu;

    //Constructeur
    public Joueur(Couleur couleur, Mode modeDeJeu) throws Exception {
        this.couleur=couleur;
        this.modeDeJeu = modeDeJeu;
        this.pieces = FabriquePiece.situation(this.modeDeJeu, this.couleur);
    }

    /**
     * @brief Methode qui supprime une piece mangee par une piece adverse 
     * @param piece la piece mangee a supprimer
     */
    public void retirerPiece(IPiece piece) {
        pieces.remove(piece);
    }

    /**
     * @brief Methode qui permet de recuperer une piece precise d'un joueur
     * @param indice l'indice de la piece dans la liste des pieces du joueur
     * @return la piece
     */
    public IPiece recupererPiece(int indice) {
        return pieces.get(indice);
    }

    /**
     * @brief Methode qui permet de recuperer toutes les pieces d'un joueur
     * @return la liste des pieces
     */
    @Override
    public IPiece[] recupererPieces() {
        IPiece[] listePieces = new IPiece[pieces.size()];
        for (int i = 0; i < pieces.size(); ++i) {
            listePieces[i] = pieces.get(i);
        }

        return listePieces;
    }

    /**
     * @brief Methode qui verifie si il ne reste qu'un roi dans la liste des pieces d'un joueur
     * @return si la liste des pieces d'un joueur ne contient plus qu'un roi 
     */
    public boolean aJusteUnRoi() {
        return pieces.size() == 1 && pieces.get(Jeu.INDICE_ROI).estUnRoi();
    }

    /**
     * @brief Methode qui recupere la couleur d'un joueur
     * @return la couleur du joueur
     */
    @Override
    public Couleur getCouleur() {
        return couleur;
    }

    /**
     * Methode qui recupere le mode de jeu
     * @return le mode de jeu du joueur
     */
    public Mode getModeDeJeu() {
        return this.modeDeJeu;
    }
}
