/*
 * Observateur.java                  23/11/2015
 */
package controleur;

/**
 * Application du patron de conception MVC à l’application Morpion
 * @author Alicia MASMAYOUX
 */
public interface Observateur {

    public void avertir(int i, int j);
}
