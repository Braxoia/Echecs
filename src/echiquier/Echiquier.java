package echiquier;

import pieces.Couleur;
import jeu.Jeu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author A.Ibrahime, B.Marco, P.Julie
 * @date 25/05/21
 * @brief Classe Echiquier
 */
public class Echiquier {
	//Valeurs minimales et maximales de notre echiquier
    public static final int MAX = 8;
    public static final int MIN = 0;
    
    //Nombre de caracteres maximum saisi
    public static final int SAISIE_MAX = 4;
    
    //Definition de l'attribut de l'echiquier sous forme de cases
    private final IPiece[][] cases;

    //Constructeur 
    public Echiquier() {
        this.cases = new IPiece[MAX][MAX];
        for (IPiece[] hauteur : this.cases)
            Arrays.fill(hauteur, null);
    }

    /**
     * Creation d'un echiquier clone
     * @param echiquier l'echiquier que l'on souhaite cloner
     */
    public Echiquier(Echiquier echiquier) {
        this.cases = echiquier.getCases();
    }

    /**
     * @brief Méthode qui verifie si la saisie de l'utilisateur
     * 		  respecte le format impose
     * @param saisie la saisie a verifier
     * @return si la saisie est correcte
     */
    public static boolean saisieCorrecte(String saisie) {
        final int verifNbEntreDernier;
        final int verifNbEntrePremier;
        if (saisie.length() != SAISIE_MAX)
            return false;

        try {
            verifNbEntreDernier = Integer.parseInt(String.valueOf(saisie.charAt(3)));
            verifNbEntrePremier = Integer.parseInt(String.valueOf(saisie.charAt(1)));
        }
        catch (NumberFormatException | StringIndexOutOfBoundsException s) {
            return false;
        }

        return saisie.charAt(0) <= 'h' && saisie.charAt(2) <= 'h'
                && saisie.charAt(0) >= 'a' && saisie.charAt(2) >= 'a'
                && verifNbEntrePremier <= MAX && verifNbEntreDernier <= MAX
                && verifNbEntrePremier > MIN && verifNbEntreDernier > MIN;
    }


    /**
     * @brief Decompose la saisie de l'utilisateur en deux 
     *        couples de coordonnees
     * @param s la saisie correcte entree 
     * @return un tableau d'entier
     */
    public int[] decompose(String s) {
        s = s.trim().toLowerCase();
        char[] saisie = new char[4];
        int[] nvCoord = new int[4];
        for (int i = 0; i < saisie.length; i++) {
            saisie[i] = s.charAt(i);
            saisie[i] = correspondances(saisie[i]);
        }
        nvCoord[0] = Character.getNumericValue(saisie[1]);
        nvCoord[1] = Character.getNumericValue(saisie[0]);
        nvCoord[2] = Character.getNumericValue(saisie[3]);
        nvCoord[3] = Character.getNumericValue(saisie[2]);
        return nvCoord;
    }

    /**
     * @brief Methode statique qui associe un caractere ASCII a un entier
     * @param c le caractere auquel on associe un entier
     * @return l'entier associe au caractere
     */
    public static char correspondances(char c) {
        int coord;
        if (c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e' || c == 'f' || c == 'g' || c == 'h') {
            coord = c - 'a';
            return Integer.toString(coord).charAt(0);
        }
        coord = '8' - c;
        return Integer.toString(coord).charAt(0);
    }

    /**
     * @brief Methode qui renvoie une chaine de caracteres 
     *        represenant l'echiquier
     * @return l'echiquier
     */
    public String toString() {
        final String str = System.lineSeparator();
        StringBuilder affichage = new StringBuilder();
        String ligneLettres = "    a   b   c   d   e   f   g   h";
        String interLigne = "   --- --- --- --- --- --- --- ---";

        affichage.append(ligneLettres).append(str);

        for (int i = 0; i < MAX; i++) {
            affichage.append(interLigne).append(str);

            String chiffreLigne = String.valueOf(MAX - i);
            affichage.append(chiffreLigne);

            for (int j = 0; j < cases[0].length; j++) {
                if (cases[i][j] == null)
                    affichage.append(" | ").append(" ");
                else
                    affichage.append(" | ").append(cases[i][j]);
            }
            affichage.append(" | ").append(chiffreLigne).append(str);
        }
        affichage.append(interLigne).append(str).append(ligneLettres);
        return affichage.toString();

    }

    /**
     * @brief Recuperation de l'attribut echiquier
     * @return les cases de l'echiquier
     */
    public IPiece[][] getCases() {
        return cases;
    }

    /**
     * @brief Methode qui teste s'il y a echec et mat
     * @param jeu le jeu en cours
     * @param couleurJoueurActif la couleur du joueur actif
     * @return s'il y a une situation d'echec et mat
     */
    public boolean echecEtMat(Jeu jeu, Couleur couleurJoueurActif) {
        boolean pasEchec = false;
        int[] roiAdversePos = recuperationRoiAdverse(jeu, jeu.getJoueurActif().getCouleur());
        ArrayList<int[]> coordPieceAdverse = coordPiecesAdverses(couleurJoueurActif);
        ArrayList<int[]> coupsPossibles = deplacementsPossibles(jeu,roiAdversePos);

        //Test pour chaque coup possible et pour chaque piece adverse, si le roi est mis en echec
        for (int[] coupPossible : coupsPossibles) {

            //On deplace le roi a une nouvelle position
            this.deplacer(
                    jeu,
                    cases[roiAdversePos[0]][roiAdversePos[1]],
                    cases[coupPossible[2]][coupPossible[3]],
                    new int[]{roiAdversePos[0], roiAdversePos[1], coupPossible[2], coupPossible[3]}
            );

            //On verifie si au moins une des pieces adverse met en echec le roi sur la nouvelle case ou il se trouve
            for (int[] pieceAdverse : coordPieceAdverse) {
                if (echec(jeu, cases[pieceAdverse[0]][pieceAdverse[1]], pieceAdverse, couleurJoueurActif)) {

                    //On redeplace le roi a sa position initiale pour tester l'echec a une autre coordonnees
                    this.deplacer(
                            jeu,
                            cases[coupPossible[2]][coupPossible[3]],
                            cases[roiAdversePos[0]][roiAdversePos[1]], new int[]{coupPossible[2],
                                    coupPossible[3], roiAdversePos[0], roiAdversePos[1]}
                    );

                    pasEchec = false;
                    break;
                }
                pasEchec = true;
            }

            //S'il n'y a pas eu d'echec, le roi reprend sa position initiale
            if (pasEchec) {
                this.deplacer(
                        jeu,
                        cases[coupPossible[2]][coupPossible[3]],
                        cases[roiAdversePos[0]][roiAdversePos[1]], new int[]{coupPossible[2],
                                coupPossible[3], roiAdversePos[0], roiAdversePos[1]}
                );
                return false;
            }

        }
        return true;
    }


    /**
     * @brief Methode qui recupère les coordonnes actuelles de toutes les pieces adverses
     * @param couleurJoueurActif la couleur du joueur actif
     * @return la liste des coordonnees des pieces adverses
     */
    public ArrayList<int[]> coordPiecesAdverses(Couleur couleurJoueurActif) {
        ArrayList<int[]> coordPieceAdverse = new ArrayList<>();

        //Si on rencontre une piece qui n'est pas de la couleur du joueur actif, alors elle appartient au joueur adverse
        for (int ligne = 0; ligne < Echiquier.MAX; ligne++) {
            for (int colonne = 0; colonne < Echiquier.MAX; colonne++) {
                if (cases[ligne][colonne] == null) continue;
                else if(cases[ligne][colonne].getCouleur() != couleurJoueurActif)
                    coordPieceAdverse.add(new int[]{ligne, colonne});
            }
        }
        return coordPieceAdverse;
    }

    /**
     * @brief Methode qui liste tous les deplacements possibles d'une piece
     * @param jeu le jeu en cours
     * @param coord les coordonnees de la piece dont on souhaite connaitre les deplacements possibles
     * @return la liste des deplacements possibles de la piece
     */
    public ArrayList<int[]> deplacementsPossibles(Jeu jeu, int[] coord) {
        ArrayList<int[]> deplacements = new ArrayList<>();
        int[] coordonnees = new int[4];

        coordonnees[0] = coord[0];
        coordonnees[1] = coord[1];
        for (int ligne = 0; ligne < Echiquier.MAX; ligne++) {
            for (int colonne = 0; colonne < Echiquier.MAX; colonne++) {
                try {
                    coordonnees[3] = colonne;
                    coordonnees[2] = ligne;
                    if (cases[coord[0]][coord[1]].deplacementPossible(this, coordonnees))
                        deplacements.add(new int[] {coordonnees[0],coordonnees[1], ligne, colonne});
                }
                catch(Exception ignored) { }
            }
        }
        return deplacements;
    }

    /**
     * @brief Methode qui test si un roi est mis en echec par la piece qu'on vient de deplacer
     * @param jeu le jeu en cours
     * @param piece la piece qu'on vient de deplacer
     * @param coordActuelle les coordonnees actuelles de la piece
     * @param couleurJoueurActif la couleur du joueur actif
     * @return si le roi est mis en echec par la piece
     */
    public boolean echec(Jeu jeu, IPiece piece, int[] coordActuelle, Couleur couleurJoueurActif) {

        if (recuperationRoiAdverse(jeu, couleurJoueurActif) == null)
            return false;

        int[] coordEchec = new int[4];
        int[] coordRoi = recuperationRoiAdverse(jeu, couleurJoueurActif);

        coordEchec[0] = coordActuelle[0];
        coordEchec[1] = coordActuelle[1];
        coordEchec[2] = coordRoi[0];
        coordEchec[3] = coordRoi[1];

        return piece.deplacementPossible(this, coordEchec);
    }

    /**
     * @brief Methode qui recupere les coordonnees du roi de couleur opposee
     * @param jeu le jeu en cours
     * @param couleurJoueurActif la couleur du joueur actif
     * @return les coordonnees du roi de couleur opposee
     */
    public int[] recuperationRoiAdverse(Jeu jeu, Couleur couleurJoueurActif)  {
        for (int ligne = 0; ligne < Echiquier.MAX; ligne++) {
            for (int colonne = 0; colonne < Echiquier.MAX; colonne++) {
                if (couleurJoueurActif == jeu.getJoueurActif().getCouleur()
                        && cases[ligne][colonne] == jeu.getJoueurActif().recupererPiece(0)) {
                    return new int[]{ligne, colonne};
                }
            }
        }
        return null;
    }

    /**
     * @brief Methode qui indique si le deplacement d'un roi cree une situation d'echec 
     * @param jeu le jeu en cours
     * @param coord les coordonnees actuelles et les futures coordonnees d'une piece
     * @return si le deplacement du roi le met en echec
     */
    public boolean piecesAdversesCases(Jeu jeu, int[] coord) {

    	//Definition d'un echiquier clone
        Echiquier echiquierClone = new Echiquier(this);
        IPiece[][] casesClone = echiquierClone.cases;
        
        for (int ligne = 0; ligne < Echiquier.MAX; ++ligne)
        {
            for (int colonne = 0; colonne < Echiquier.MAX; ++colonne)
            {
                if(casesClone[ligne][colonne] == null)
                    continue;

                IPiece pieceEtudiee = casesClone[ligne][colonne];

                //Si la piece adverse n'est pas roi alors le deplacement est autorise
                if(!(casesClone[coord[0]][coord[1]].estUnRoi()))
                    return true;

                //Si le deplacement est possible et que le roi en face est une piece adverse alors le deplacement n'est pas possible
                if(casesClone[ligne][colonne].deplacementPossible(echiquierClone, new int[]{colonne, ligne, coord[3], coord[2]})
                        && pieceEtudiee.getCouleur() != jeu.getJoueurActif().getCouleur()) {
                    return false;
                }
            }
        }

        return true;
    }


    /*public boolean echecEtPat(IJoueur joueurActif) {
        Case[][] cases = echiquier.getCases();
        int nbEchecs = 0;
        for(int ligne = 0; ligne < Echiquier.MAX; ligne++){
            for(int colonne = 0; colonne < Echiquier.MAX; colonne++) {
                try {
                    if (cases[ligne][colonne].getPiece().getCouleur() != couleurJoueurActif &&
                            this.echec(cases[ligne][colonne].getPiece(), new int[]{colonne, ligne}, couleurJoueurActif)) {
                        nbEchecs++;
                    }
                }
                catch (NullPointerException e)
                {
                    continue;
                }
            }
        }

        return nbEchecs == joueurActif.getPieces().size();
    }*/

    /**
     * @brief Methode qui effectue le deplacement d'une piece
     * @param jeu le jeu en cours
     * @param caseSource la case ou se trouve la piece actuellement
     * @param caseDestination la case ou la piece souhaite se deplacer
     * @param coord les coordonnes actuelles et les futures coordonnees de la piece
     */
    public void deplacer(Jeu jeu, IPiece caseSource, IPiece caseDestination, int[] coord) {

        if (caseDestination != null) {
            jeu.getJoueurInactif().retirerPiece(caseDestination);

            this.getCases()[coord[2]][coord[3]] = null;
        }

        this.getCases()[coord[2]][coord[3]] = caseSource;
        this.getCases()[coord[0]][coord[1]] = null;
    }

    /**
     * @brief Methode qui effectue les actions de jeu
     * @param jeu le jeu en cours
     * @param coordPiece les coordonnes actuelles et les futures coordonnees de la piece
     */
    public void jouerPartie(Jeu jeu, int[] coordPiece) {
        try {
        	//Deplacement de la piece
            this.deplacer(
                    jeu,
                    jeu.getEchiquier().getCases()[coordPiece[0]][coordPiece[1]],
                    jeu.getEchiquier().getCases()[coordPiece[2]][coordPiece[3]],
                    coordPiece
            );

            //Affichage de l'echiquier mis a jour
            System.out.println(jeu.getEchiquier());
            
            //Changement du joueur actif 
            jeu.changementJoueur();
        } catch (Exception e) {
            System.err.println("La piece ne peut pas être deplacee ici !");
        }
    }
}



