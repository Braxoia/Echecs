package jeu;

import echiquier.IJoueur;
import pieces.Couleur;
import java.util.*;

import echiquier.Echiquier;
import echiquier.IPiece;
import pieces.FabriquePiece;

/**
 * @author A.Ibrahime, B.Marco, P.Julie
 * @date 25/05/21
 * @brief Classe IA
 */
public class IA extends Joueur{
	//Initialisation du generateur aleatoire
    Random r = new Random();
    
    //Constructeur
    public IA(Couleur couleur, FabriquePiece.Mode mode) throws Exception {
        super(couleur, mode);
    }

    /**
     * @brief Methode qui choisi aleatoirement des coordonnes pour effectuer un deplacement
     * @return les coordonnes utilisees pour le futur deplacement
     */
    @Override
    public int[] jouer(Jeu jeu) {
        ArrayList<int[]> positionsPossiblesPieceCourante;
        int[] coordPiece = new int[4];

        try{
            positionsPossiblesPieceCourante = positionsPossibles(jeu, jeu.getJoueurActif());
            coordPiece = positionsPossiblesPieceCourante.get(r.nextInt(positionsPossiblesPieceCourante.size()));
        } catch (Exception e) {
            System.out.println("Piece non trouvee");
        }
        return coordPiece;
    }

    /**
     * @brief Methode qui permet de savoir si le joueur actif est humain
     * @return si le joueur est un humain
     */
    @Override
    public boolean estUnHumain() {
        return false;
    }

    /**
     * @brief Methode qui permet de savoir si le joueur actif est une IA
     * @return si le joueur est une IA
     */
    @Override
    public boolean estUneIA() {
        return true;
    }

    /**
     * @brief Methode qui recupere tous les deplacements possibles pour toutes les pieces d'un joueur
     * @param jeu le jeu en cours
     * @param joueur le joueur actif
     * @return la liste de tous les deplacements possibles pour toutes les pieces du joueur
     */
    public ArrayList<int[]> positionsPossibles(Jeu jeu, IJoueur joueur) {
        ArrayList<int[]> positionsPossiblesPiece = new ArrayList<>();
        IPiece[] piecesJoueur = joueur.recupererPieces();
        int[] coordPiece;

        for(IPiece p : piecesJoueur) {
            for (int ligne = 0; ligne < Echiquier.MAX; ligne++) {
                for (int colonne = 0; colonne < Echiquier.MAX; colonne++) {
                	
                	//Recupartion des coordonnes
                    coordPiece = new int[] {p.coordPiece(jeu.getEchiquier(), p)[0],p.coordPiece(jeu.getEchiquier(), p)[1], ligne, colonne};
                    
                    //Test si le deplacement est possible entre la position actuelle de la piece et les coordonnees dans coordPiece
                    if (p.deplacementPossible(jeu.getEchiquier(), coordPiece) && jeu.getEchiquier().piecesAdversesCases(jeu,coordPiece)) {
                        positionsPossiblesPiece.add(coordPiece);
                    }
                }
            }
        }

        return positionsPossiblesPiece;
    }
}

