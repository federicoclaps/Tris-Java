package it.unibas.tris;

import it.unibas.tris.controllo.ControlloInserisciGiocatore;
import it.unibas.tris.controllo.ControlloMenu;
import it.unibas.tris.controllo.ControlloPrincipale;
import it.unibas.tris.modello.Modello;
import it.unibas.tris.modello.Operatore;
import it.unibas.tris.vista.Frame;
import it.unibas.tris.vista.VistaInserisciGiocatore;
import it.unibas.tris.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static Applicazione singleton = new Applicazione();

    public static Applicazione getInstance() {
        return singleton;
    }

    private Applicazione() {
    }

    private Modello modello;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private VistaInserisciGiocatore vistaInserisciGiocatore;
    private ControlloMenu controlloMenu;
    // private ControlloPrincipale controlloPrincipale;
    private ControlloInserisciGiocatore controlloInserisciGiocatore;
    private Operatore operatore;

    public Modello getModello() {
        return modello;
    }

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public VistaInserisciGiocatore getVistaInserisciGiocatore() {
        return vistaInserisciGiocatore;
    }

    public ControlloMenu getControlloMenu() {
        return controlloMenu;
    }

//    public ControlloPrincipale getControlloPrincipale() {
//        return controlloPrincipale;
//    }
    public ControlloInserisciGiocatore getControlloInserisciGiocatore() {
        return controlloInserisciGiocatore;
    }

    public Operatore getOperatore() {
        return operatore;
    }

    public void inizializza() {
        this.modello = new Modello();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.vistaInserisciGiocatore = new VistaInserisciGiocatore(frame, true);
        this.controlloMenu = new ControlloMenu();
        //  this.controlloPrincipale = new ControlloPrincipale();
        this.controlloInserisciGiocatore = new ControlloInserisciGiocatore();
        this.operatore = new Operatore();
        this.vistaPrincipale.inizializza();
        this.frame.inizializza();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Applicazione.getInstance().inizializza();
            }
        });
    }

}
