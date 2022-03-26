package it.unibas.tris.modello;

import it.unibas.tris.Costanti;
import java.util.ArrayList;
import java.util.List;

public class Partita {

    private List<Giocatore> listaGiocatori = new ArrayList<>();

    public Partita() {
    }

    public List<Giocatore> getListaGiocatori() {
        return listaGiocatori;
    }

    public void aggiungiGiocatore(Giocatore giocatore) {
        if (this.listaGiocatori.size() > Costanti.NUM_GIOCATORI) {
            throw new IllegalArgumentException("I giocatori sono solo 2");
        }
        this.listaGiocatori.add(giocatore);
    }

}
