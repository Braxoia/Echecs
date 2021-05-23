package pieces;

import echiquier.IPiece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author A.Ibrahime
 * @date 25/05/21
 * @brief Classe fabriquant les pièces
 */
public class FabriquePiece {

    /**
     * @brief Classe énumérée représentant les modes
     * possibles
     */
    public enum Mode {
        OUVERTURE, MILLIEU, FINALE
    }

    /**
     * @brief Méthode retourtant une liste de pièces en fonction
     *        du mode entré en paramètre
     * @param mode le mode de jeu
     * @param couleur la couleur des pièces générées
     * @return la liste de pièces
     * @throws Exception si le mode n'existe pas ou si il n'a pas été défini
     */
    public static ArrayList<IPiece> situation(Mode mode, Couleur couleur) throws Exception {
        switch(mode) {
            case FINALE : {
                if(couleur == Couleur.BLANC)
                    return new ArrayList<>(Arrays.asList(new Roi(couleur), new Tour(couleur)));
                return new ArrayList<>(Collections.singletonList(new Roi(couleur)));
            }
            case MILLIEU: {
                //Pieces supplémentaires à rajouter pour faire une telle situation
                //Va créer une exception
            }
            case OUVERTURE: {
                //Pieces supplémentaires à rajouter pour faire une telle situation
            }
            default: throw new Exception("La situation demandée n'existe pas !");
        }
    }
}
