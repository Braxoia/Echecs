package echiquier;

import pieces.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Echiquier {
    public static final int MAX = 8;
    private Case[][] echiquier;
    // private ArrayList<IPiece> blanches = new ArrayList<IPiece>(Arrays.asList(new Roi(Couleur.BLANC, new Coordonnées(2, 4), this), new Fou(Couleur.BLANC, new Coordonnées(1, 1), this)));
    // private ArrayList<IPiece> noires = new ArrayList<IPiece>(Arrays.asList(new Roi(Couleur.NOIR, new Coordonnées(0, 4), this)));


    public Echiquier() {
        this.echiquier = new Case[MAX][MAX];
        for (Case[] hauteur : this.echiquier)
            for (int i = 0; i < hauteur.length; ++i)
                hauteur[i] = new Case();
    }

    public static boolean coupsPossibles(String saisie) {
        /*final int verifNbEntreDernier = Integer.parseInt(String.valueOf(saisie.charAt(3)));
        final int verifNbEntrePremier = Integer.parseInt(String.valueOf(saisie.charAt(1)));
        if (saisie.length() != 4 || saisie.charAt(0) > 'h' || saisie.charAt(2) > 'h' || saisie.charAt(0) < 'a' || saisie.charAt(2) < 'a'
                || verifNbEntrePremier > MAX
                || verifNbEntreDernier > MAX
                || verifNbEntrePremier <= 0
                || verifNbEntreDernier <= 0)
            return false;*/

        return true;
    }

    public int[] decompose(String s) {
        String[] saisie = new String[4];
        int[] nvCoord = new int[2];
        for (int i = 0; i < saisie.length; i++) {
            saisie[i] = s.substring(i, i + 1);
            saisie[i] = correspondances(saisie[i]);

        }
        for(int k=0;k<saisie.length;k++){
            for (int j = 0; j < nvCoord.length; j++) {
                nvCoord[j] = Integer.parseInt(saisie[j+2]);

            }
        }

        return nvCoord;
    }

    public static String correspondances(String s) {
        switch (s) {
            case "a":
            case "8":
                return "0";
            case "b":
            case "7":
                return "1";
            case "c":
            case "6":
                return "2";
            case "d":
            case "5":
                return "3";
            case "e":
            case "4":
                return "4";
            case "f":
            case "3":
                return "5";
            case "g":
            case "2":
                return "6";
            case "h":
            case "1":
                return "7";
        }
        return null;
    }

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

            for (int j = 0; j < echiquier[0].length; j++) {
                affichage.append(" | ").append(echiquier[i][j]);
            }
            affichage.append(" | ").append(chiffreLigne).append(str);
        }
        affichage.append(interLigne).append(str).append(ligneLettres);
        return affichage.toString();

    }

    public Case[][] getEchiquier() {
        return echiquier;
    }
}
