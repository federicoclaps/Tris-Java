package it.unibas.tris.vista;

import com.formdev.flatlaf.FlatLightLaf;
import it.unibas.tris.Applicazione;
import it.unibas.tris.Costanti;
import it.unibas.tris.modello.Partita;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Frame extends javax.swing.JFrame {

    static {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inizializza() {
        initComponents();
        inizializzaAzioni();
        this.setContentPane(new JScrollPane(Applicazione.getInstance().getVistaPrincipale()));
        setLocationRelativeTo(null);
        this.pack();
        setVisible(true);
    }

    private void inizializzaAzioni() {
        this.menuEsci.setAction(Applicazione.getInstance().getControlloMenu().getAzioneEsci());
        this.menuNuovaPartita.setAction(Applicazione.getInstance().getControlloMenu().getAzioneNuovaPartita());
        this.menuInterrompiPartita.setAction(Applicazione.getInstance().getControlloMenu().getAzioneInterrompiPartita());
    }

    public void mostraMessaggio(String messaggio) {
        JOptionPane.showMessageDialog(this, messaggio, "Tris", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostraMessaggioErrore(String messaggio) {
        JOptionPane.showMessageDialog(this, messaggio, "Errore!", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
        menuNuovaPartita = new javax.swing.JMenuItem();
        menuInterrompiPartita = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuEsci = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tris");

        jMenu1.setText("File");

        menuNuovaPartita.setText("jMenuItem1");
        jMenu1.add(menuNuovaPartita);

        menuInterrompiPartita.setText("jMenuItem2");
        jMenu1.add(menuInterrompiPartita);
        jMenu1.add(jSeparator1);

        menuEsci.setText("jMenuItem3");
        jMenu1.add(menuEsci);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem menuEsci;
    private javax.swing.JMenuItem menuInterrompiPartita;
    private javax.swing.JMenuItem menuNuovaPartita;
    // End of variables declaration//GEN-END:variables
}
