/*
 * MorpionModele.java                  23/11/2015
 */
package modele;

import controleur.Observateur;
import java.util.ArrayList;
import java.util.List;

/**
 * Application du patron de conception MVC à l’application Morpion
 * @author Alicia MASMAYOUX
 */
public class MorpionModel {
    
    /** Taille de la grille */
    private static final int TAILLE = 3;
    
    /** Grille représentant le jeu */
    private int[][] platform;

    /** Boolean permattant de savoir si le joueur à gagné ou perdu */
    private boolean gagnee;
    
    /** int représentant le nombre de coup */
    private int nb_coups;
    
    /** Représente le joueur suivant */
    private int nextPlayer;

    /** Liste des observateurs */
    private List<Observateur> listeObservateur;
    
    /**
     * Constructeur permettant d'initialiser le model
     */
    public MorpionModel() {
        listeObservateur = new ArrayList<Observateur>();
        platform = new int[TAILLE][TAILLE];
        nouvellePartie();
    }
    
    /**
     * Méthode permettant de définir le vainqueur d'un partie
     * @param i abscisse pour définir la coordonné de la case
     * @param j ordonnée pour définir la coordonné de la case
     * @return le vainqueur de la partie
     */
    public boolean unVainqueur(int i, int j){
    return 
        ((platform[i][0] == platform[i][1] && platform[i][1] == platform[i][2])
        // ligne pleine
        || (platform[0][j] == platform[1][j] && platform[1][j] == platform[2][j])
        // colonne pleine
        || (i == j && platform[0][0] == platform[1][1] 
            && platform[1][1] == platform[2][2])
        // premiere diagonale pleine
        || (i + j == 2	&& platform[0][2] == platform[1][1] 
            && platform[1][1] == platform[2][0]));
        // deuxieme diagonale pleine
    } 
    
    /**
     * Méthode permettant l'initialisation du plateau
     */
    public void nouvellePartie(){
        nb_coups = 0;
        gagnee = false;
        nextPlayer = 1;
        
        for(int i = 0 ; i < TAILLE; i++){
            for(int j = 0; j < TAILLE; j++){
                // init case
                platform[i][j] = 0;
            }
        }  
    }
    
    /**
     * Méthode permettant de jouer un coup
     * @param i abscisse pour définir la coordonné de la case
     * @param j ordonnée pour définir la coordonné de la case
     */
    public void jouer(int i, int j){
        System.out.println(i + " " + j);
        if(platform[i][j] == 0 ){ 
            platform[i][j] = nextPlayer;
            nb_coups ++;
            nextPlayer = (nextPlayer == 2 ? 1 :2);
            gagnee = unVainqueur(i,j);          
        }
        
        avertirObs(i,j);
    }

    /**
     * Méthode permettant de changer le joueur
     * @param joueur le joueur actuel 
     * @return le nouveau joueur
     */
    public int changerJoueur(int joueur){
        if(joueur == 1){
            return 2;
        }else if (joueur == 2){
            return 1;
        }else{
            return 1;
        }
    }
   
    /**
     * Méthode permettant d'afficher le plateau 
     * et le joueur suivant textuellement
     * @return la chaine contenant les informations
     */
    @Override
    public String toString() {
        String chaine = "";
        for(int i = 0 ; i < TAILLE; i++){
            for(int j = 0; j < TAILLE; j++){
                chaine += platform[i][j] + "\n";
            }
        }
        
        chaine += "Joueur suivant : " + nextPlayer;
        return chaine;
    }

    /**
     * Méthode permettant d'afficher sous la forme d'une chaine le joueur
     * @param player le numéro du joueur
     * @return la chaine correspondant au joueur
     */
    public String iconToString(int player){
        if(player == 1){
            return "CROIX";
        }else if(player == 2){
            return "ROND";
        }else{
            return "BLANC";
        }
    }
    
    /**
     * Accesseur permettant de récupérer le nombre de coups
     * @return le nombre de coups
     */
    public int getNb_coups() {
        return nb_coups;
    }

    /**
     * Accesseur permettant de récupérer le joueur
     * @return le joueur
     */
    public int getNextPlayer() {
        return nextPlayer;
    }

    /**
     * Accesseur permettant de récupérer la plateforme du jeu
     * @return la plateform
     */
    public int[][] getPlatform() {
        return platform;
    }
    
    /**
     * Permet d'ajouter un observateur
     * @param obs l'observateur a ajouter
     */
    public void addObservateur(Observateur obs){
        listeObservateur.add(obs);          
    }
    
    /**
     * Permet de supprimer un observatreur
     * @param obs observateur a supprimer
     */
    public void removeObservateur(Observateur obs){
        listeObservateur.remove(obs);
    }
    
    /**
     * Permet d'avertir l'observateur
     * @param i abscisse pour définir la coordonné de la case
     * @param j ordonnée pour définir la coordonné de la case
     */
    public void avertirObs(int i, int j){
        for (Observateur listeObs : listeObservateur) {
            listeObs.avertir(i,j);
        }
    }

    /**
     * Accesseur permettant de savoir si un joueur a gagné ou pas
     * @return true si il a gagné false sinon
     */
    public boolean isGagnee() {
        return gagnee;
    }

    /**
     * Accesseur permettant de récupérer la taille 
     * @return la taille
     */
    public static int getTAILLE() {
        return TAILLE;
    }
}
