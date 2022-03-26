package it.unibas.tris.controllo;

import it.unibas.tris.Applicazione;
import it.unibas.tris.Costanti;
import it.unibas.tris.modello.Giocatore;
import it.unibas.tris.modello.Mossa;
import it.unibas.tris.modello.Operatore;
import it.unibas.tris.modello.Partita;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.JButton;
import javax.swing.KeyStroke;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControlloPrincipale extends AbstractAction {

    private static Logger logger = LoggerFactory.getLogger(ControlloPrincipale.class);

    private Action azioneNuovaMossa;

    private int riga;
    private int colonna;
    private Giocatore giocatore;

    public ControlloPrincipale(int row, int column, Giocatore giocatore) {
        this.putValue(SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/it/unibas/tris/immagini/icon_agg.png")));
        this.putValue(SHORT_DESCRIPTION, "Inizia una nuova partita");
        this.putValue(MNEMONIC_KEY, KeyEvent.VK_N);
        this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt N"));
        this.riga = row;
        this.colonna = column;
        this.giocatore = giocatore;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Partita partita = (Partita) Applicazione.getInstance().getModello().getBean(Costanti.PARTITA);
        String[][] matrice = (String[][]) Applicazione.getInstance().getModello().getBean(Costanti.MATRICE);

        Operatore operatore = Applicazione.getInstance().getOperatore();

        Giocatore giocatoreAttuale = (Giocatore) Applicazione.getInstance().getModello().getBean(Costanti.GIOCATORE_ATTUALE);
        String segno = giocatoreAttuale.getSegno();

        Mossa mossa = new Mossa(riga, colonna, segno);
        try {
            operatore.inserisciMossa(matrice, mossa);
            giocatore.addMossa(mossa);
        } catch (IllegalArgumentException ex) {
            Applicazione.getInstance().getFrame().mostraMessaggioErrore("Il posto è occupato");
            return;
        }

        JButton[][] matriceBottoni = (JButton[][]) Applicazione.getInstance().getModello().getBean(Costanti.MATRICE_BOTTONI);
        JButton bottone = matriceBottoni[riga][colonna];

        if (segno.equals(Costanti.SEGNO_X)) {
            bottone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unibas/tris/immagini/X.png")));
            // bottone.setEnabled(false);
        } else if (segno.equals(Costanti.SEGNO_O)) {
            bottone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unibas/tris/immagini/O.png")));
            //bottone.setEnabled(false);
        }

        if (operatore.matricePiena(matrice)) {
            Applicazione.getInstance().getFrame().mostraMessaggio("Nessuno ha vinto!");
            Applicazione.getInstance().getVistaPrincipale().disabilitaBottoni();
            logger.info("Matrice piena");
            return;
        }
        
        if(segno == null){
            logger.info("Error");
        }
        boolean verifica = false;
        try {
            verifica = operatore.controllaMossa(matrice, riga, colonna, segno);
        } catch (IllegalArgumentException ex) {
            Applicazione.getInstance().getFrame().mostraMessaggioErrore("matrice vuota");
            return;
        }
        
        if (verifica) {
            Applicazione.getInstance().getFrame().mostraMessaggio(giocatoreAttuale.getNome() + " ha vinto!");
            Applicazione.getInstance().getVistaPrincipale().disabilitaBottoni();
            return;
        }

        Giocatore gioc1 = (Giocatore) Applicazione.getInstance().getModello().getBean(Costanti.GIOCATORE_UNO);
        Giocatore gioc2 = (Giocatore) Applicazione.getInstance().getModello().getBean(Costanti.GIOCATORE_DUE);
        if (giocatoreAttuale.getNome().equals(gioc1.getNome())) {
            Applicazione.getInstance().getModello().putBean(Costanti.GIOCATORE_ATTUALE, gioc2);
            logger.info("Giocatore 2");
        } else if (giocatoreAttuale.getNome().equals(gioc2.getNome())) {
            Applicazione.getInstance().getModello().putBean(Costanti.GIOCATORE_ATTUALE, gioc1);
            logger.info("giocatore 1");
        }
        Applicazione.getInstance().getVistaPrincipale().abiitaBottoniDopoMossa(riga, colonna);
//        Applicazione.getInstance().getVistaPrincipale().aggiornaDati();

    }
}
