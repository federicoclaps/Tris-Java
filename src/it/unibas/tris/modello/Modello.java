package it.unibas.tris.modello;

import java.util.HashMap;
import java.util.Map;

public class Modello {

    private Map<String, Object> beans = new HashMap<>();

    public void putBean(String chiave, Object valore) {
        this.beans.put(chiave, valore);
    }

    public Object getBean(String chiave) {
        return this.beans.get(chiave);
    }

    String[][] get(String MATRICE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
