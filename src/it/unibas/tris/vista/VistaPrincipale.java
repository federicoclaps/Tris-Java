package it.unibas.tris.vista;

import it.unibas.tris.Applicazione;
import it.unibas.tris.Costanti;
import it.unibas.tris.controllo.ControlloPrincipale;
import it.unibas.tris.modello.Giocatore;
import javax.swing.JButton;

public class VistaPrincipale extends javax.swing.JPanel {

    private JButton[][] matriceBottoni = new JButton[Costanti.DIM_MATRICE][Costanti.DIM_MATRICE];

    public void inizializza() {
        initComponents();
        settaBottoniMatrici();
        disabilitaBottoni();
        this.tabellaMosse.setModel(new ModelloTabellaMosse());
        this.campoGiocatoreAttuale.setEnabled(false);
    }

    public void disabilitaBottoni() {
        JButton[][] matriceButton = (JButton[][]) Applicazione.getInstance().getModello().getBean(Costanti.MATRICE_BOTTONI);
        for (int i = 0; i < Costanti.DIM_MATRICE; i++) {
            for (int j = 0; j < Costanti.DIM_MATRICE; j++) {
                matriceButton[i][j].setEnabled(false);
            }
        }
    }

    public void abiitaBottoni() {
        Giocatore giocatore = (Giocatore) Applicazione.getInstance().getModello().getBean(Costanti.GIOCATORE_ATTUALE);
        JButton[][] matriceButton = (JButton[][]) Applicazione.getInstance().getModello().getBean(Costanti.MATRICE_BOTTONI);
        setCampoGiocatore(giocatore);
        for (int i = 0; i < Costanti.DIM_MATRICE; i++) {
            for (int j = 0; j < Costanti.DIM_MATRICE; j++) {
                matriceButton[i][j].setEnabled(true);
                matriceButton[i][j].setAction(new ControlloPrincipale(i, j, giocatore));
            }
        }
    }

    public void abiitaBottoniDopoMossa(int row, int col) {
        Giocatore giocatore = (Giocatore) Applicazione.getInstance().getModello().getBean(Costanti.GIOCATORE_ATTUALE);
        setCampoGiocatore(giocatore);
        JButton[][] matrice = (JButton[][]) Applicazione.getInstance().getModello().getBean(Costanti.MATRICE_BOTTONI);
        //matrice[row][col].setEnabled(false);
    }

    private void setCampoGiocatore(Giocatore giocatore) {
        this.campoGiocatoreAttuale.setText(giocatore.getNome());
    }

    private void settaBottoniMatrici() {
        this.matriceBottoni[0][0] = this.mossa1_1;
        this.matriceBottoni[0][1] = this.mossa1_2;
        this.matriceBottoni[0][2] = this.mossa1_3;
        this.matriceBottoni[1][0] = this.mossa2_1;
        this.matriceBottoni[1][1] = this.mossa2_2;
        this.matriceBottoni[1][2] = this.mossa2_3;
        this.matriceBottoni[2][0] = this.mossa3_1;
        this.matriceBottoni[2][1] = this.mossa3_2;
        this.matriceBottoni[2][2] = this.mossa3_3;
        Applicazione.getInstance().getModello().putBean(Costanti.MATRICE_BOTTONI, this.matriceBottoni);
    }

    public void aggiornaDati() {
        Giocatore giocatore = (Giocatore) Applicazione.getInstance().getModello().getBean(Costanti.GIOCATORE_ATTUALE);
        ModelloTabellaMosse modelloTabella = (ModelloTabellaMosse) this.tabellaMosse.getModel();
        modelloTabella.setTabella(giocatore);
        modelloTabella.aggiornaContenuto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mossa1_2 = new javax.swing.JButton();
        mossa1_3 = new javax.swing.JButton();
        mossa2_2 = new javax.swing.JButton();
        mossa2_3 = new javax.swing.JButton();
        mossa3_2 = new javax.swing.JButton();
        mossa3_3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        campoGiocatoreAttuale = new javax.swing.JTextField();
        mossa3_1 = new javax.swing.JButton();
        mossa2_1 = new javax.swing.JButton();
        mossa1_1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabellaMosse = new javax.swing.JTable();

        setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));

        mossa1_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unibas/tris/immagini/icon_agg.png"))); // NOI18N

        mossa1_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unibas/tris/immagini/icon_agg.png"))); // NOI18N

        mossa2_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unibas/tris/immagini/icon_agg.png"))); // NOI18N

        mossa2_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unibas/tris/immagini/icon_agg.png"))); // NOI18N

        mossa3_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unibas/tris/immagini/icon_agg.png"))); // NOI18N

        mossa3_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unibas/tris/immagini/icon_agg.png"))); // NOI18N

        jLabel1.setText("Giocatore:");

        mossa3_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unibas/tris/immagini/icon_agg.png"))); // NOI18N

        mossa2_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unibas/tris/immagini/icon_agg.png"))); // NOI18N

        mossa1_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unibas/tris/immagini/icon_agg.png"))); // NOI18N

        tabellaMosse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tabellaMosse);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mossa1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mossa1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mossa1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(mossa2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(mossa2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(mossa3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(mossa3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mossa3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mossa2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(campoGiocatoreAttuale, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(230, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(266, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoGiocatoreAttuale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mossa1_1)
                    .addComponent(mossa1_3)
                    .addComponent(mossa1_2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mossa2_3)
                    .addComponent(mossa2_1)
                    .addComponent(mossa2_2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mossa3_2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mossa3_1)
                            .addComponent(mossa3_3, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(566, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(72, 72, 72)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(420, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoGiocatoreAttuale;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton mossa1_1;
    private javax.swing.JButton mossa1_2;
    private javax.swing.JButton mossa1_3;
    private javax.swing.JButton mossa2_1;
    private javax.swing.JButton mossa2_2;
    private javax.swing.JButton mossa2_3;
    private javax.swing.JButton mossa3_1;
    private javax.swing.JButton mossa3_2;
    private javax.swing.JButton mossa3_3;
    private javax.swing.JTable tabellaMosse;
    // End of variables declaration//GEN-END:variables

}
