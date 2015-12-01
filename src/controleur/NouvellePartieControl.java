/*
 * NouvellePartieControl.java                  23/11/2015
 */
package controleur;

import vue.MorpionFrame;
import java.awt.event.ActionListener;
import modele.MorpionModel;

/**
 * Application du patron de conception MVC à l’application Morpion
 * @author Alicia MASMAYOUX
 */
public class NouvellePartieControl implements ActionListener{

    /** Correspond au modèle */
    private MorpionModel model;
    
    /** Correspond à la vue */
    private MorpionFrame vue;
    

    public NouvellePartieControl(MorpionModel m, MorpionFrame v) {
        model = m;
        vue = v;
    }
    
    public void actionPerformed(java.awt.event.ActionEvent evt) {                                   
        model.nouvellePartie();
        vue.reinitialise();
    }       
}
