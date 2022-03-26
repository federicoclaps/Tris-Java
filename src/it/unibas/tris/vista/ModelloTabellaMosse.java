package it.unibas.tris.vista;

import it.unibas.tris.modello.Giocatore;
import it.unibas.tris.modello.Mossa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaMosse extends AbstractTableModel {

    private Giocatore giocatore;
    private List<Mossa> listaMosse = new ArrayList<>();

    public void setTabella(Giocatore giocatore) {
        this.giocatore = giocatore;
        this.listaMosse = giocatore.getListaMosse();
    }

    @Override
    public int getRowCount() {
//        if(giocatore.getListaMosse() == null){
//            return 0;
//        }
        return listaMosse.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Mossa mossa = giocatore.getListaMosse().get(row);
        if (column == 0) {
            return giocatore.getNome();
        } else if (column == 1) {
            return mossa.getSegno();
        } else if (column == 2) {
            return mossa.getRow();
        } else if (column == 3) {
            return mossa.getColumn();
        }
        return "";
    }

    public String getColumnName(int column) {
        if (column == 0) {
            return "Giocatore";
        } else if (column == 1) {
            return "Segno";
        } else if (column == 2) {
            return "Riga";
        } else if (column == 3) {
            return "Colonna";
        }
        return "";
    }

    public void aggiornaContenuto() {
        this.fireTableDataChanged();
    }

}
