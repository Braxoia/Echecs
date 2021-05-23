package jeu;

import echiquier.Echiquier;
import pieces.Couleur;
import pieces.FabriquePiece;

import java.util.Scanner;

/**
 * @author A.Ibrahime, B.Marco, P.Julie
 * @date 25/05/21
 * @brief Classe Roi
 */
public class Humain extends Joueur{

	//Valeurs qui indiquent l'etat du jeu en cours
    public static final int MATCH_NUL = -1;
    public static final int MATCH_NUL_REFUSE = -2;
    public static final int MATCH_ABANDON = -3;

    //Constructeur
    public Humain(Couleur couleur, FabriquePiece.Mode mode) throws Exception {
        super(couleur, mode);
    }

    /**
     * @brief Methode qui choisi aleatoirement des coordonnes pour effectuer un deplacement
     * @return les coordonnes utilisees pour le futur deplacement
     */
    @Override
    public int[] jouer(Jeu jeu) {
        Scanner sc = new Scanner(System.in);
        String saisie = sc.nextLine();


        if(saisie.equals("null")) {
            System.out.println("Voulez-vous terminer par un match nul ?");
            saisie = sc.nextLine();
            if(saisie.trim().equalsIgnoreCase("oui"))
                return new int[] {MATCH_NUL};
            return new int[] {MATCH_NUL_REFUSE} ;
        }
        else if(saisie.equals("abandon"))
            return new int[] {MATCH_ABANDON};

        while(!Echiquier.saisieCorrecte(saisie)) {
            saisie = sc.nextLine();
        }

        return jeu.getEchiquier().decompose(saisie);
    }
    
    /**
     * @brief Methode qui permet de savoir si le joueur actif est humain
     * @return si le joueur est un humain
     */
    @Override
    public boolean estUnHumain() {
        return true;
    }

    /**
     * @brief Methode qui permet de savoir si le joueur actif est une IA
     * @return si le joueur est une IA
     */
    @Override
    public boolean estUneIA() {
        return false;
    }
}

