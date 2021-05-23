package jeu;

import echiquier.*;
import pieces.Couleur;
import pieces.FabriquePiece;

/**
 * @author A.Ibrahime, B.Marco, P.Julie
 * @date 25/05/21
 * @brief Classe Jeu
 */
public class Jeu {
    //L'indice du roi qui doit TOUJOURS être 0
    public static final int INDICE_ROI = 0;

    //Liste des joueurs Blanc et Noir, qui jouent � tour de role
    private final IJoueur joueurBlanc;
    private final IJoueur joueurNoir;
    private IJoueur joueurActif;
    
    //Echiquier associe au jeu en cours
    private final Echiquier echiquier;
    
    //Constructeur
    public Jeu (IJoueur joueur1, IJoueur joueur2) {
        this.joueurBlanc = joueur1;
        this.joueurNoir = joueur2;
        this.echiquier = new Echiquier();
        this.joueurActif = joueur1;
        initPosPieces();
    }

    /**
     * @brief Methode d'initialisation des pieces sur l'echiquier
     */
    private void initPosPieces() {
        if(joueurActif.getModeDeJeu() == FabriquePiece.Mode.FINALE) {
            echiquier.getCases()[2][4] = joueurBlanc.recupererPiece(INDICE_ROI);
            echiquier.getCases()[1][1] = joueurBlanc.recupererPiece(1);
            echiquier.getCases()[0][4] = joueurNoir.recupererPiece(INDICE_ROI);
        }
    }

    /**
     * @brief Methode qui permet de renvoyer la situation de la partie
     * @param piece la piece qu'on deplace
     * @param coordActuelle les coordonnees actuelles de la piece deplacee
     * @return la situation de la partie
     */
    public int miseAJourPartie(IPiece piece, int[] coordActuelle) {
        try{

            if (echiquier.echec(this, piece, coordActuelle, this.getJoueurActif().getCouleur())
                    && echiquier.echecEtMat(this, this.getJoueurActif().getCouleur())) {
                return 1;
            }
            else if (echiquier.echec(this, piece, coordActuelle, this.getJoueurActif().getCouleur())) {
                return 2;
            }
            else if (joueurActif.aJusteUnRoi() && getJoueurInactif().aJusteUnRoi()) {
                return 3;
            }
        }
        catch(Exception ignored){ }

        return 0;
    }

    /**
     * @brief Recuperation de l'attribut de l'echiquier
     * @return l'echiquier
     */
    public Echiquier getEchiquier() {
        return this.echiquier;
    }

    /**
     * @brief Recuperation de l'attribut joueurActif 
     * @return le joueur actif
     */
    public IJoueur getJoueurActif() {
        return joueurActif;
    }

    /**
     * @brief Recuperation du joueur non actif a partir de l'attribut joueurActif
     * @return le joueur non actif
     */
    public IJoueur getJoueurInactif() {
        if(joueurActif.getCouleur() == Couleur.BLANC)
            return joueurNoir;
        else {
            return joueurBlanc;
        }
    }

    /**
     * @brief Methode qui permet le changement de joueur actif
     */
    public void changementJoueur() {
        if(joueurActif == joueurBlanc)
            joueurActif = joueurNoir;
        else
            joueurActif = joueurBlanc;
    }
}