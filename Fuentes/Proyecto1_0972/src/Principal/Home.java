package Principal;

import javax.swing.JOptionPane;

/**
 *
 * @author Joaquin
 */
public class Home extends javax.swing.JFrame {

    public Home() 
    {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        bmapa = new javax.swing.JButton();
        bleyendas = new javax.swing.JButton();
        bmanual1 = new javax.swing.JButton();
        bmanual2 = new javax.swing.JButton();
        bacercade = new javax.swing.JButton();
        lbimagen1 = new javax.swing.JLabel();
        lbtitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proyecto");
        setName("Home"); // NOI18N

        panel.setBackground(new java.awt.Color(0, 0, 0));

        bmapa.setText("Cargar Mapa");
        bmapa.setPreferredSize(new java.awt.Dimension(73, 25));
        bmapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmapaActionPerformed(evt);
            }
        });

        bleyendas.setText("Leyendas");
        bleyendas.setPreferredSize(new java.awt.Dimension(73, 25));
        bleyendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bleyendasActionPerformed(evt);
            }
        });

        bmanual1.setText("Manul de Usuario");
        bmanual1.setPreferredSize(new java.awt.Dimension(73, 25));
        bmanual1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmanual1ActionPerformed(evt);
            }
        });

        bmanual2.setText("Manual Tecnico");
        bmanual2.setPreferredSize(new java.awt.Dimension(73, 25));
        bmanual2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmanual2ActionPerformed(evt);
            }
        });

        bacercade.setText("Acerca de");
        bacercade.setPreferredSize(new java.awt.Dimension(73, 25));
        bacercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bacercadeActionPerformed(evt);
            }
        });

        lbimagen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/waze_logo.png"))); // NOI18N

        lbtitulo.setFont(new java.awt.Font("Freshbot", 1, 24)); // NOI18N
        lbtitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbtitulo.setText("WACE");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(lbimagen1)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bleyendas, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bmapa, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bmanual1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bmanual2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bacercade, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbtitulo)))
                .addGap(15, 15, 15))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbimagen1)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(lbtitulo)
                        .addGap(15, 15, 15)
                        .addComponent(bmapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bleyendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bmanual1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bmanual2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bacercade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bmapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmapaActionPerformed
        Mapa m = new Mapa();
        m.setVisible(true);
    }//GEN-LAST:event_bmapaActionPerformed

    private void bleyendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bleyendasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bleyendasActionPerformed

    private void bmanual1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmanual1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bmanual1ActionPerformed

    private void bmanual2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmanual2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bmanual2ActionPerformed

    private void bacercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bacercadeActionPerformed
        JOptionPane.showMessageDialog(null,"José Joaquin Cacao Chub\nCarnet: 2012-12577\n"
                + "Guatemala Junio de 2016","Acerca de",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_bacercadeActionPerformed
    
//    public static void main(String args[]) 
//    {
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
//            {
//                if ("Nimbus".equals(info.getName())) 
//                {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) 
//        {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        
//        java.awt.EventQueue.invokeLater(() -> {
//            new Home().setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bacercade;
    private javax.swing.JButton bleyendas;
    private javax.swing.JButton bmanual1;
    private javax.swing.JButton bmanual2;
    private javax.swing.JButton bmapa;
    private javax.swing.JLabel lbimagen1;
    private javax.swing.JLabel lbtitulo;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
