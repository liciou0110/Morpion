/*
 * MorpionMain.java               24/11/2015
 */
package vue;

import controleur.Observateur;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import modele.MorpionModel;

/**
 *
 * @author Alicia
 */
public class MorpionVueFichier implements Observateur{

    private MorpionModel model;
    
    public MorpionVueFichier(MorpionModel m){
        model = m;
    }
    
    /**
     * Méthode permettant d'écrire dasn un fichier les évènements
     * @param chaine la chaine écrire dans le fichier
     */
    public void ecrire(String chaine){
        try {
            FileWriter file = new FileWriter("Morpion.txt" , true);
            BufferedWriter buffer = new BufferedWriter(file);
            buffer.append(chaine);
            buffer.newLine();
            buffer.close();
        } catch (IOException ex) {
            System.out.println("Erreur " + ex);
        }
    }

    @Override
    public void avertir(int i, int j) {
        if(model.isGagnee()){
            this.ecrire("Le joueur : " +  model.iconToString(model.getNextPlayer()) 
            + " a gagné.");
        }else if(model.getNb_coups() == 9){
            this.ecrire("Il n'y a pas de vainqueur.");
        }else{
            this.ecrire("Le joueur " + model.iconToString(model.getNextPlayer()) 
                      + " [ "+i+" , "+j+ " ]");
        }
    }
}
