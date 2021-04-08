package echiquier;

import pieces.IPiece;

public class Echiquier {
    private Case[][] echiquier;

    public Echiquier() {
        this.echiquier = new Case[8][8];
        System.out.println(this.echiquier.length);
        for(Case[] hauteur : this.echiquier)
            for(int i = 0; i < hauteur.length; ++i)
                hauteur[i] = new Case();
    }

    public String toString() {
        final String str = System.lineSeparator();
        StringBuilder affichage = new StringBuilder();
        String ligneLettres = "    a   b   c   d   e   f   g   h";
        String interLigne = "   --- --- --- --- --- --- --- ---";

        affichage.append(ligneLettres).append(str);

        for(int i = 0; i < 8; i++)
        {
            affichage.append(interLigne).append(str);

            String chiffreLigne = String.valueOf(8-i);
            affichage.append(chiffreLigne);

            for(int j = 0; j < echiquier[0].length; j++) {
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