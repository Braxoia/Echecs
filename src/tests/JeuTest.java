package tests;

import jeu.Humain;
import jeu.Jeu;
import jeu.Mode;
import org.junit.Test;
import pieces.Couleur;
import echiquier.*;
import static org.junit.Assert.assertEquals;


public class JeuTest {
    @Test
    public void testInitPosPieces() throws Exception {
        Mode modeDeJeu = Mode.FINALE;
        Jeu jeu = new Jeu(new Humain(Couleur.BLANC, modeDeJeu), new Humain(Couleur.NOIR, modeDeJeu));
        assertEquals("R",jeu.getEchiquier().getCases()[2][4].toString());
        assertEquals("r",jeu.getEchiquier().getCases()[0][4].toString());
        assertEquals("T",jeu.getEchiquier().getCases()[1][1].toString());

    }

    @Test
    public void testMiseAJourPartie() throws Exception {
        Mode modeDeJeu = Mode.FINALE;
        Jeu jeu = new Jeu(new Humain(Couleur.BLANC, modeDeJeu), new Humain(Couleur.NOIR, modeDeJeu));
        String s = "b7b8";
        int[] coord = jeu.getEchiquier().decompose(s);
        jeu.getEchiquier().jouerPartie(jeu,coord);
        assertEquals(1,jeu.miseAJourPartie(jeu.getEchiquier().getCases()[coord[2]][coord[3]],new int[]{coord[2],coord[3]}));
    }

    @Test
    public void testGetJoueurInactif() throws Exception {
        Mode modeDeJeu = Mode.FINALE;
        IJoueur HumainNoir =new Humain(Couleur.NOIR, modeDeJeu);
        Jeu jeu = new Jeu(new Humain(Couleur.BLANC, modeDeJeu),HumainNoir );
        assertEquals(HumainNoir,jeu.getJoueurInactif());
    }

    @Test
    public void testChangementJoueur() throws Exception {
        Mode modeDeJeu = Mode.FINALE;
        IJoueur HumainNoir =new Humain(Couleur.NOIR, modeDeJeu);
        IJoueur HumainBlanc =new Humain(Couleur.BLANC, modeDeJeu);
        Jeu jeu = new Jeu(HumainBlanc,HumainNoir);
        String s ="b7b8";
        jeu.changementJoueur();
        assertEquals(HumainNoir,jeu.getJoueurActif());
    }
}