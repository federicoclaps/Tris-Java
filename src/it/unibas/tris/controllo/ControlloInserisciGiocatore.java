package it.unibas.tris.controllo;

import it.unibas.tris.Applicazione;
import it.unibas.tris.Costanti;
import it.unibas.tris.modello.Giocatore;
import it.unibas.tris.modello.Partita;
import it.unibas.tris.vista.VistaInserisciGiocatore;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControlloInserisciGiocatore {
    
    private Logger logger = LoggerFactory.getLogger(ControlloInserisciGiocatore.class);

    private Action azioneInserisci = new AzioneInserisci();

    public Action getAzioneInserisci() {
        return azioneInserisci;
    }

    private class AzioneInserisci extends AbstractAction {

        public AzioneInserisci() {
            this.putValue(NAME, "Inserisci");
            this.putValue(SHORT_DESCRIPTION, "Inserisci giocatori");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_R);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt R"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Partita partita = new Partita();
            VistaInserisciGiocatore vistaInserisci = Applicazione.getInstance().getVistaInserisciGiocatore();
            String playerUno = vistaInserisci.getCampoGiocatoreUno();
            String playerDue = vistaInserisci.getCampoGiocatoreDue();
            String errori = convalida(playerUno, playerDue);
            if (!errori.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore(errori);
                return;
            }
            Giocatore giocatoreUno = new Giocatore(playerUno, Costanti.SEGNO_X);
            Giocatore giocatoreDue = new Giocatore(playerDue, Costanti.SEGNO_O);
            partita.aggiungiGiocatore(giocatoreUno);
            partita.aggiungiGiocatore(giocatoreDue);
            Applicazione.getInstance().getModello().putBean(Costanti.GIOCATORE_UNO, giocatoreUno);
            Applicazione.getInstance().getModello().putBean(Costanti.GIOCATORE_DUE, giocatoreDue);
            Applicazione.getInstance().getModello().putBean(Costanti.GIOCATORE_ATTUALE, giocatoreUno);
            String messaggio = "Giocatore 1 (Segno " + giocatoreUno.getSegno() + " ) : " + playerUno + " \nGiocatore 2 (Segno " + giocatoreDue.getSegno() + " ) : " + playerDue;
            Applicazione.getInstance().getFrame().mostraMessaggio(messaggio);

            String matrice[][] = new String[Costanti.DIM_MATRICE][Costanti.DIM_MATRICE];
            Applicazione.getInstance().getModello().putBean(Costanti.MATRICE, matrice);

            
            Applicazione.getInstance().getModello().putBean(Costanti.PARTITA, partita);
            
            Applicazione.getInstance().getVistaPrincipale().abiitaBottoni();
            Applicazione.getInstance().getVistaPrincipale().aggiornaDati();
            Applicazione.getInstance().getControlloMenu().getAzioneInterrompiPartita().setEnabled(true);
            Applicazione.getInstance().getControlloMenu().getAzioneNuovaPartita().setEnabled(false);
            Applicazione.getInstance().getVistaInserisciGiocatore().setVisible(false);

        }

        private String convalida(String g1, String g2) {
            StringBuilder errori = new StringBuilder();
            if (g1.isEmpty()) {
                errori.append("Inserire giocatore 1\n");
            }
            if (g2.isEmpty()) {
                errori.append("Inserire giocatore 2");
            }
            return errori.toString();
        }

    }

}
