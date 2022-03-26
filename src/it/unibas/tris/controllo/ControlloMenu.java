package it.unibas.tris.controllo;

import it.unibas.tris.Applicazione;
import it.unibas.tris.Costanti;
import it.unibas.tris.modello.Giocatore;
import it.unibas.tris.modello.Partita;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControlloMenu {

    private Logger logger = LoggerFactory.getLogger(ControlloMenu.class);

    private Action azioneNuovaPartita = new AzioneNuovaPartita();
    private Action azioneInterrompiPartita = new AzioneInterrompiPartita();
    private Action azioneEsci = new AzioneEsci();

    public Action getAzioneNuovaPartita() {
        return azioneNuovaPartita;
    }

    public Action getAzioneInterrompiPartita() {
        return azioneInterrompiPartita;
    }

    public Action getAzioneEsci() {
        return azioneEsci;
    }

    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt E"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class AzioneNuovaPartita extends AbstractAction {

        public AzioneNuovaPartita() {
            this.putValue(NAME, "Nuova partita");
            this.putValue(SHORT_DESCRIPTION, "Inizia una nuova partita");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_N);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt N"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Partita partita = new Partita();
            Applicazione.getInstance().getModello().putBean(Costanti.PARTITA, partita);
            Applicazione.getInstance().getVistaInserisciGiocatore().inizializza();

        }
    }

    private class AzioneInterrompiPartita extends AbstractAction {

        public AzioneInterrompiPartita() {
            this.putValue(NAME, "Interrompi partita");
            this.putValue(SHORT_DESCRIPTION, "Interrompi la  partita");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_I);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt I"));
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Partita partita = (Partita) Applicazione.getInstance().getModello().getBean(Costanti.PARTITA);
//            List<Giocatore> listaGiocatori = partita.getListaGiocatori();
//            partita.getListaGiocatori().removeAll(listaGiocatori);
            Applicazione.getInstance().getFrame().mostraMessaggio("La partita è stata interrotta!");
//            Applicazione.getInstance().getVistaInserisciGiocatore().azzerraCampi();
            Applicazione.getInstance().getControlloMenu().getAzioneNuovaPartita().setEnabled(true);
            Applicazione.getInstance().getVistaPrincipale().disabilitaBottoni();
            getAzioneInterrompiPartita().setEnabled(false);
        }
    }

}
