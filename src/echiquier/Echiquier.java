package echiquier;

public class Echiquier {
    private Case[][] echiquier;
    public Echiquier() {
        Case[][] echiquier = new Case[8][8];
        for(Case[] hauteur : echiquier)
            for(int i = 0; i < hauteur.length; ++i)
                hauteur[i] = new Case();
    }
}

