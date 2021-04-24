package echiquier;

public class Echiquier {
    public static final int MAX = 8;
    public static final int MIN = 0;
    private Case[][] echiquier;
    // private ArrayList<IPiece> blanches = new ArrayList<IPiece>(Arrays.asList(new Roi(Couleur.BLANC, new Coordonnées(2, 4), this), new Fou(Couleur.BLANC, new Coordonnées(1, 1), this)));
    // private ArrayList<IPiece> noires = new ArrayList<IPiece>(Arrays.asList(new Roi(Couleur.NOIR, new Coordonnées(0, 4), this)));


    public Echiquier() {
        this.echiquier = new Case[MAX][MAX];
        for (Case[] hauteur : this.echiquier)
            for (int i = 0; i < hauteur.length; ++i)
                hauteur[i] = new Case();
    }

    public static boolean saisieCorrecte(String saisie) {
        final int verifNbEntreDernier = Integer.parseInt(String.valueOf(saisie.charAt(3)));
        final int verifNbEntrePremier = Integer.parseInt(String.valueOf(saisie.charAt(1)));
        return saisie.length() == 4 && saisie.charAt(0) <= 'h' && saisie.charAt(2) <= 'h'
                                    && saisie.charAt(0) >= 'a' && saisie.charAt(2) >= 'a'
                                    && verifNbEntrePremier <= MAX && verifNbEntreDernier <= MAX
                                    && verifNbEntrePremier > MIN  && verifNbEntreDernier > MIN;
    }

    public int[] decompose(String s) {
        String[] saisie = new String[4];
        int[] nvCoord = new int[4];
        for (int i = 0; i < saisie.length; i++) {
            saisie[i] = s.substring(i, i + 1);
            //TODO : Arrêtez la fonction dans le cas où l'on rencontre un -1
            if(saisie[i].equals("-1")){
                return nvCoord;
            }
            saisie[i] = correspondances(saisie[i]);
        }
        for(int j=0; j < nvCoord.length; j++){
            nvCoord[j] = Integer.parseInt(saisie[j]);
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
        return "-1";
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
