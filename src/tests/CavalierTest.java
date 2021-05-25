package tests;


import jeu.Humain;
import jeu.Jeu;
import jeu.Mode;
import org.junit.jupiter.api.Test;
import echiquier.*;
import pieces.Couleur;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CavalierTest {
    @Test
    public void testdeplacementsPossibles() throws Exception {
        Mode modeDeJeu = Mode.FINALE;
        Jeu jeu = new Jeu(new Humain(Couleur.BLANC, modeDeJeu), new Humain(Couleur.NOIR, modeDeJeu));
        String s = "f3h4";
        int[] coord = jeu.getEchiquier().decompose(s);
        boolean deplacementPossible = jeu.getEchiquier().getCases()[coord[0]][coord[1]].deplacementPossible(jeu.getEchiquier(), coord);
        assertTrue(deplacementPossible);


    }
}