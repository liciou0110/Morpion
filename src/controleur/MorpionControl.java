/*
 * MorpionControl.java                  23/11/2015
 */
package controleur;

import vue.MorpionFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modele.MorpionModel;

/**
 * Application du patron de conception MVC à l’application Morpion
 * @author Alicia MASMAYOUX
 */
public class MorpionControl extends MouseAdapter{
    
    /** Correspond à l'abscisse de la coordonnée de la case */
    private int i;
    
    /** Correspond à l'ordonnée de la coordonnées de la case */
    private int j;
    
    /** Correspond au modèle */
    private MorpionModel model;
    
    /** Correspond à la vue */
    private MorpionFrame vue;

    /**
     * Constructeur par défaut
     * @param m correspond au modèle
     * @param v correpsond à la vue
     * @param _i abscisse pour définir la coordonné de la case
     * @param _j ordonnée pour définir la coordonné de la case
     */
    public MorpionControl(MorpionModel m, MorpionFrame v, int _i, int _j){
        i = _i;
        j = _j;
        model  = m;
        vue = v;
    }
    
    @Override
    public void mouseClicked(MouseEvent e){
        if(model.getPlatform()[i][j] == 0 ){
            vue.setPlateformIcon(i, j, model.getNextPlayer());
            model.jouer(i, j);
        }
    }
    
}
