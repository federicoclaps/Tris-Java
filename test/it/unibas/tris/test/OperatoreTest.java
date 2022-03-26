package it.unibas.tris.test;

import it.unibas.tris.Costanti;
import it.unibas.tris.modello.Operatore;
import org.junit.Assert;
import org.junit.Test;

public class OperatoreTest {
    
    @Test
    public void testMatricePiena() {
        String[][] matrice = new String[3][3];
        Operatore operatore = new Operatore();
        for (int i = 0; i < Costanti.DIM_MATRICE; i++) {
            for (int j = 0; j < Costanti.DIM_MATRICE; j++) {
                matrice[i][j] = "piena";
            }
        }
        Assert.assertTrue(operatore.matricePiena(matrice));
    }
    
    @Test
    public void testControllaMossaRiga() {
        String[][] matrice = new String[3][3];
        matrice[0][0] = "X";
        matrice[0][1] = "X";
        matrice[0][2] = "X";
        Operatore operatore = new Operatore();
        Assert.assertTrue(operatore.controllaMossa(matrice, 0, 1, "X"));
    }
    
    @Test
    public void testControllaMossaDiagonale() {
        String[][] matrice = new String[3][3];
        matrice[0][0] = "X";
        matrice[1][1] = "X";
        matrice[2][2] = "X";
        Operatore operatore = new Operatore();
        Assert.assertTrue(operatore.controllaMossa(matrice, 1, 1, "X"));
    }
    
    @Test
    public void testControllaMossaColonna() {
        String[][] matrice = new String[3][3];
        matrice[0][0] = "X";
        matrice[1][0] = "X";
        matrice[2][0] = "X";
        Operatore operatore = new Operatore();
        Assert.assertTrue(operatore.controllaMossa(matrice, 1, 1, "X"));
    }
    

    
}
