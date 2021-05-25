package tests;

import jeu.*;
import org.junit.Test;
import pieces.Couleur;
import echiquier.*;


import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;


public class EchiquierTest {
    @Test
    public void testInitialisationEchiquier(){
        Echiquier echiquier = new Echiquier();
        for (int i = 0;i < echiquier.getCases().length; i++) {
            for (int j = 0;j < echiquier.getCases()[i].length;j++) {
                assertEquals (null,echiquier.getCases()[i][j]);
            }
        }
    }

    @Test
    public void testSaisieCorrecte(){
        String saisie = "b7b8";
        String saisie2= "e6e5";
        String saisie3= "i8h8";
        String saisie4="            E8H8           ";
        saisie4= saisie4.trim().toLowerCase();
        assertTrue(Echiquier.saisieCorrecte(saisie));
        assertTrue(Echiquier.saisieCorrecte(saisie2));
        assertFalse(Echiquier.saisieCorrecte(saisie3));
        assertTrue(Echiquier.saisieCorrecte(saisie4));
    }

    @Test
    public void testDecompose(){
        Echiquier echiquier = new Echiquier();
        String saisie = "b7b8";
        String saisie2= "e6e5";
        assertArrayEquals(new int[]{1,1,0,1},echiquier.decompose(saisie));
        assertArrayEquals(new int[]{2,4,3,4},echiquier.decompose(saisie2));
    }

    @Test
    public void testCorrespondances(){
        String saisie= "e6e5";
        assertEquals('4',Echiquier.correspondances(saisie.charAt(0)));
        assertEquals('2',Echiquier.correspondances(saisie.charAt(1)));
        assertEquals('4',Echiquier.correspondances(saisie.charAt(2)));
        assertEquals('3',Echiquier.correspondances(saisie.charAt(3)));
    }

    @Test
    public void testToStringEchiquier(){
        Echiquier echiquier = new Echiquier();
        StringBuilder sb= new StringBuilder();
        String sautDeLigne = System.lineSeparator();
        sb.append("    a   b   c   d   e   f   g   h").append(sautDeLigne)
                .append("   --- --- --- --- --- --- --- ---").append(sautDeLigne)
                .append("8 |   |   |   |   |   |   |   |   | 8").append(sautDeLigne)
                .append("   --- --- --- --- --- --- --- ---").append(sautDeLigne)
                .append("7 |   |   |   |   |   |   |   |   | 7").append(sautDeLigne)
                .append("   --- --- --- --- --- --- --- ---").append(sautDeLigne)
                .append("6 |   |   |   |   |   |   |   |   | 6").append(sautDeLigne)
                .append("   --- --- --- --- --- --- --- ---").append(sautDeLigne)
                .append("5 |   |   |   |   |   |   |   |   | 5").append(sautDeLigne)
                .append("   --- --- --- --- --- --- --- ---").append(sautDeLigne)
                .append("4 |   |   |   |   |   |   |   |   | 4").append(sautDeLigne)
                .append("   --- --- --- --- --- --- --- ---").append(sautDeLigne)
                .append("3 |   |   |   |   |   |   |   |   | 3").append(sautDeLigne)
                .append("   --- --- --- --- --- --- --- ---").append(sautDeLigne)
                .append("2 |   |   |   |   |   |   |   |   | 2").append(sautDeLigne)
                .append("   --- --- --- --- --- --- --- ---").append(sautDeLigne)
                .append("1 |   |   |   |   |   |   |   |   | 1").append(sautDeLigne)
                .append("   --- --- --- --- --- --- --- ---").append(sautDeLigne)
                .append("    a   b   c   d   e   f   g   h");

        assertTrue(echiquier.toString().equals(sb.toString()));
    }

    @Test
    public void testEchecEtMat() throws Exception {
        Jeu jeu = new Jeu(new Humain(Couleur.BLANC, Mode.FINALE), new Humain(Couleur.NOIR, Mode.FINALE));
        String s = "b7b8";
        int[] coord = jeu.getEchiquier().decompose(s);
        jeu.getEchiquier().jouerPartie(jeu,coord);
        assertTrue(jeu.getEchiquier().echecEtMat(jeu,jeu.getJoueurActif().getCouleur()));
    }

/*    @Test
    public void testCoordPiecesAdverses(){
        Jeu jeu = new Jeu(new Humain(Couleur.BLANC), new Humain(Couleur.NOIR));
        String s = "b7b8";
        int[] coord = jeu.getEchiquier().decompose(s);
        jeu.getEchiquier().jouerPartie(jeu,coord);
        ArrayList<int[]> coordPiecesAdverses = new ArrayList<int[]>();
        coordPiecesAdverses.add(new int[]{0,1});
        coordPiecesAdverses.add(new int[]{2,4});
        ArrayList<int[]> coordPiecesAdverses2=jeu.getEchiquier().coordPiecesAdverses(jeu.getJoueurActif().getCouleur());
        for(int i=0;i<coordPiecesAdverses.size();i++){
            for(int j=0;j<coordPiecesAdverses.get(i).length;j++){
                assertEquals(coordPiecesAdverses2.get(i)[j],coordPiecesAdverses.get(i)[j]);
            }
        }

    }*/

    @Test
    public void testDeplacementsPossibles() throws Exception {
        Mode modeDeJeu = Mode.FINALE;
        Jeu jeu = new Jeu(new Humain(Couleur.BLANC, modeDeJeu), new Humain(Couleur.NOIR, modeDeJeu));
        ArrayList<int[]> deplacements = jeu.getEchiquier().deplacementsPossibles(jeu,new int[]{0,4});
        ArrayList<int[]> deplacements2 = new ArrayList<>(Arrays.asList(new int[]{0,4,0,3},new int[]{0,4,0,5},
                new int[]{0,4,1,3},new int[]{0,4,1,4},new int[]{0,4,1,5}));
        for(int i=0;i<deplacements.size();i++){
            for(int j=0;j<deplacements.get(i).length;j++){
                assertEquals(deplacements2.get(i)[j],deplacements.get(i)[j]);
            }
        }

    }

    @Test
    public void testEchec() throws Exception {
        Mode modeDeJeu = Mode.FINALE;
        Jeu jeu = new Jeu(new Humain(Couleur.BLANC, modeDeJeu), new Humain(Couleur.NOIR, modeDeJeu));
        String s = "b7e7";
        int[] coord = jeu.getEchiquier().decompose(s);
        jeu.getEchiquier().jouerPartie(jeu,coord);
        assertTrue(jeu.getEchiquier().echec(jeu,jeu.getEchiquier().getCases()[coord[2]][coord[3]],
                new int[]{coord[2],coord[3]},jeu.getJoueurActif().getCouleur()));
    }


    @Test
    public void testRecuperationRoiAdverse() throws Exception {
        Jeu jeu = new Jeu(new Humain(Couleur.BLANC, Mode.FINALE), new Humain(Couleur.NOIR, Mode.FINALE));
        String s ="b7b8";
        int[] coord = jeu.getEchiquier().decompose(s);
        jeu.getEchiquier().jouerPartie(jeu,coord);
        int[] coordRoi =jeu.getEchiquier().recuperationRoiAdverse(jeu,jeu.getJoueurActif().getCouleur());
        assertArrayEquals(new int[]{0,4}, coordRoi);
    }

    @Test
    public void testPiecesAdversesCases() throws Exception {
        Mode modeDeJeu = Mode.FINALE;
        Jeu jeu = new Jeu(new Humain(Couleur.BLANC, modeDeJeu), new Humain(Couleur.NOIR, modeDeJeu));
        String s = "e6e7";
        int[] coord = jeu.getEchiquier().decompose(s);
        assertFalse(jeu.getEchiquier().piecesAdversesCases(jeu,coord));

    }

    @Test
    public void testDeplacer() throws Exception {
        Mode modeDeJeu = Mode.FINALE;
        Jeu jeu = new Jeu(new Humain(Couleur.BLANC, modeDeJeu), new Humain(Couleur.NOIR, modeDeJeu));
        String s ="b7b8";
        int[] coord = jeu.getEchiquier().decompose(s);
        assertNotEquals(null,jeu.getEchiquier().getCases()[coord[0]][coord[1]]);
        jeu.getEchiquier().deplacer(jeu,jeu.getEchiquier().getCases()[coord[0]][coord[1]],
                jeu.getEchiquier().getCases()[coord[2]][coord[3]],coord);
        assertEquals(null, jeu.getEchiquier().getCases()[coord[0]][coord[1]]);
    }

    @Test
    public void testJouerPartie() throws Exception {
        Mode modeDeJeu = Mode.FINALE;
        Jeu jeu = new Jeu(new Humain(Couleur.BLANC, modeDeJeu), new Humain(Couleur.NOIR, modeDeJeu));
        String s = "e6e7";
        int[] coord = jeu.getEchiquier().decompose(s);
        jeu.getEchiquier().jouerPartie(jeu,coord);
        assertEquals("NOIR",jeu.getJoueurActif().getCouleur().toString());
    }

}