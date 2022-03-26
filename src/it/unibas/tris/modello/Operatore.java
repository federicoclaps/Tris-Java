package it.unibas.tris.modello;

import it.unibas.tris.Applicazione;
import it.unibas.tris.Costanti;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Operatore {

    private static Logger logger = LoggerFactory.getLogger(Operatore.class);

    public void inserisciMossa(String[][] matrice, Mossa mossa) {
        if (matrice[mossa.getRow()][mossa.getColumn()] != null) {
            throw new IllegalArgumentException("Il posto è occupato");
        }
        matrice[mossa.getRow()][mossa.getColumn()] = mossa.getSegno();
    }

    public boolean matricePiena(String[][] matrice) {
        for (int i = 0; i < Costanti.DIM_MATRICE; i++) {
            for (int j = 0; j < Costanti.DIM_MATRICE; j++) {
                if (matrice[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean controllaMossa(String[][] matrice, int row, int column, String segno) {
        if(matrice == null){
            throw new IllegalArgumentException("matrice vuota");
        }
        boolean verificaRiga = controllaRiga(matrice, row, segno);
        boolean verificaColonna = controllaColonna(matrice, column, segno);
        if (row == column) {
            boolean verificaDiagonale = controllaDiagonale(matrice, row, segno);
            return verificaRiga || verificaColonna || verificaDiagonale;
        }
        return verificaRiga || verificaColonna;
    }

    private boolean controllaColonna(String[][] matrice, int column, String segno) {
        if (verificaColonnaPiena(matrice, column)) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (!matrice[i][column].equals(segno)) {
                return false;
            }
        }
        return true;
    }

    private boolean controllaRiga(String[][] matrice, int row, String segno) {
        if (verificaRigaPiena(matrice, row)) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (!matrice[row][i].equals(segno)) {
                return false;
            }
        }
        return true;
    }

    private boolean controllaDiagonale(String[][] matrice, int num, String segno) {
        if (verificaDiagonalePiena(matrice)) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (!matrice[i][i].equals(segno)) {
                return false;
            }
        }
        return true;
    }

    private boolean verificaRigaPiena(String[][] matrice, int row) {
        for (int i = 1; i < Costanti.DIM_MATRICE; i++) {
            if (matrice[row][i] == null) {
                logger.info("verifica riga piena");
                return true;
            }
        }
        return false;
    }

    //verifica se è vuoto
    private boolean verificaColonnaPiena(String[][] matrice, int col) {
        for (int i = 1; i < Costanti.DIM_MATRICE; i++) {
            if (matrice[i][col] == null) {
                logger.info("verifica colonna piena");
                return true;
            }
        }
        return false;
    }

    private boolean verificaDiagonalePiena(String[][] matrice) {
        for (int i = 1; i < Costanti.DIM_MATRICE; i++) {
            if (matrice[i][i] == null) {
                logger.info("verifica diagonale piena");
                return true;
            }
        }
        return false;
    }

}
