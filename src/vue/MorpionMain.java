/*
 * MorpionMain.java                  23/11/2015
 */
package vue;

import modele.MorpionModel;

/**
 * Application du patron de conception MVC à l’application Morpion
 * @author Alicia MASMAYOUX
 */
public class MorpionMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MorpionModel model = new MorpionModel();
        MorpionFrame vue = new MorpionFrame(model);
        MorpionVueFichier fichier = new MorpionVueFichier(model);
        model.addObservateur(fichier);
        model.addObservateur(vue);
        vue.setVisible(true);
    }
}
