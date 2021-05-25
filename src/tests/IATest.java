package tests;

import echiquier.IPiece;
import jeu.*;
import org.junit.Test;
import pieces.Couleur;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class IATest {
    @Test
    public void testjouerIA() throws Exception {
        Mode modeDeJeu = Mode.FINALE;
        Jeu jeu = new Jeu(new IA(Couleur.BLANC, modeDeJeu), new IA(Couleur.NOIR, modeDeJeu));
        int[] coord = jeu.getJoueurActif().jouer(jeu);
        jeu.getEchiquier().jouerPartie(jeu,coord);
        IPiece pieceTrouvee = jeu.getEchiquier().getCases()[coord[2]][coord[3]];
        pieceTrouvee.deplacementPossible(jeu.getEchiquier(),coord);
    }

    @Test
    public void testPositionsPossibles() throws Exception {
        Mode modeDeJeu = Mode.FINALE;
        IA ia = new IA(Couleur.BLANC, modeDeJeu);
        Jeu jeu = new Jeu(ia, new IA(Couleur.NOIR, modeDeJeu));
        ArrayList<int[]> positionsPossibles = new ArrayList<>(Arrays.asList(new int[]{2,4,2,3},new int[]{2,4,2,5},new int[]{2,4,3,3},
                new int[]{2,4,3,4},new int[]{2,4,3,5},
                new int[]{1,1,0,1},new int[]{1,1,1,0},new int[]{1,1,1,2},new int[]{1,1,1,3},
                new int[]{1,1,1,4},new int[]{1,1,1,5},new int[]{1,1,1,6},new int[]{1,1,1,7},
                new int[]{1,1,2,1},new int[]{1,1,3,1},new int[]{1,1,4,1},new int[]{1,1,5,1},new int[]{1,1,6,1},new int[]{1,1,7,1}));
        for(int i=0;i< positionsPossibles.size();i++){
            assertArrayEquals(positionsPossibles.get(i), ia.positionsPossibles(jeu, jeu.getJoueurActif()).get(i));
        }
    }


}