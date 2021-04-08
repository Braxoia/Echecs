package echiquier;

public class Echiquier {
    private Case[][] echiquier;
    public Echiquier() {
        Case[][] echiquier = new Case[8][8];
        for(Case[] hauteur : echiquier)
            for(int i = 0; i < hauteur.length; ++i)
                hauteur[i] = new Case();
    }

    public String toString() {

        String affichage;
        String ligneLettres = "    a   b   c   d   e   f   g   h";
        String sautLigne = System.getProperty("line.separator");
        String interLigne = "   --- --- --- --- --- --- --- ---";
        affichage = ligneLettres + sautLigne;

        for(int i = 0; i < 8; i++) {
            affichage = affichage + interLigne + sautLigne;

            String chiffreLigne = String.valueOf(8-i);
            affichage = affichage + chiffreLigne;

            for(int j = 0; j < 9; j++) {
                String colonne = " | ";
                affichage = affichage + colonne;
                affichage = affichage + " ";

            }

            affichage = affichage + chiffreLigne + sautLigne;

        }
        affichage = affichage + interLigne + sautLigne + ligneLettres;
        return affichage;

    }
}

