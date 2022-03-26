package it.unibas.tris.modello;

import java.util.ArrayList;
import java.util.List;

public class Giocatore {

    private String nome;
    private String segno;
    private List<Mossa> listaMosse = new ArrayList<>();

    public Giocatore(String nome, String segno) {
        this.nome = nome;
        this.segno = segno;
    }

    public String getNome() {
        return nome;
    }

    public String getSegno() {
        return segno;
    }

    public List<Mossa> getListaMosse() {
        return listaMosse;
    }

    public void addMossa(Mossa mossa) {
        this.listaMosse.add(mossa);

    }

}
