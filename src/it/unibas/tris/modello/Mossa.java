package it.unibas.tris.modello;

import it.unibas.tris.Costanti;

public class Mossa {

    private String segno;
    private int row;
    private int column;

    public Mossa(int row, int column, String segno) {
        this.segno = segno;
        this.row = row;
        this.column = column;
    }

    public String getSegno() {
        return segno;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

//    public String getSegno(int row, int column) {
//        if (row < 0 || row > Costanti.DIM_MATRICE) {
//            throw new IllegalArgumentException("Dimensiore riga non corretta");
//        }
//        if (column < 0 || column > Costanti.DIM_MATRICE) {
//            throw new IllegalArgumentException("Dimensiore colonna non corretta");
//        }
//        return this.tabellaMatrice[row][column];
//    }
}
