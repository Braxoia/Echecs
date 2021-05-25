package tests;

import jeu.Humain;
import jeu.Jeu;
import jeu.Mode;
import org.junit.Test;
import pieces.Couleur;

import static org.junit.Assert.*;


public class TourTest {
    @Test
    public void testDeplacementPossible() throws Exception{
        Mode modeDeJeu = Mode.FINALE;
        Jeu jeu = new Jeu(new Humain(Couleur.BLANC, modeDeJeu), new Humain(Couleur.NOIR, modeDeJeu));
        String saisie = "b7b1";
        int[] coord =jeu.getEchiquier().decompose(saisie);
        boolean deplacementPossible = jeu.getEchiquier().getCases()[coord[0]][coord[1]].deplacementPossible(jeu.getEchiquier(), coord);
        assertTrue(deplacementPossible);
        saisie = "b7g5";
        coord = jeu.getEchiquier().decompose(saisie);
        deplacementPossible = jeu.getEchiquier().getCases()[coord[0]][coord[1]].deplacementPossible(jeu.getEchiquier(), coord);

        assertFalse(deplacementPossible);
    }

    @Test
    public void toStringTest() throws Exception {
        Mode modeDeJeu = Mode.FINALE;
        Jeu jeu = new Jeu(new Humain(Couleur.BLANC, modeDeJeu), new Humain(Couleur.NOIR, modeDeJeu));
        assertEquals(jeu.getEchiquier().getCases()[1][1].toString(), "T");

    }
}