package Principal;

import IA.Data;
import java.awt.Color;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Joaquin
 */
public class Mapa extends javax.swing.JFrame 
{   
    public Mapa() 
    {
        initComponents();
        data = new Data(17,35);
        this.iniciarPanel();
        this.iniciarOpciones();
        this.iniciarMatriz();
        data.upMatriz(matriz);  //actualizo la matriz
    }
    
    private JPanel panelmatriz;
    public Cuadro[][]matriz;
    private JLabel fondodefault;
    protected Data data;
    
    private void iniciarPanel()
    {
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);        
                
        this.panelmatriz = new JPanel();
        this.panelmatriz.setLayout(null);
        this.panelmatriz.setLocation(265,15);
        this.panelmatriz.setSize((data.tamanio*data.pixeles),(data.tamanio*data.pixeles));
        this.panelmatriz.setBorder(BorderFactory.createLineBorder(Color.BLACK,1)); 
        this.panelprincipal.add(panelmatriz);
                        
        this.fondodefault=new JLabel();        
        this.fondodefault.setLocation(0, 0);
        this.fondodefault.setSize(data.tamanio*data.pixeles,data.tamanio*data.pixeles);
        //this.fondodefault.setIcon(new ImageIcon(getClass().getResource("/Images/Hierba.jpg"))); 
        this.panelmatriz.add(fondodefault);                
    }
    
    private void iniciarMatriz()
    {
        this.matriz = new Cuadro[data.tamanio][data.tamanio];          
        for (int f = 0; f < this.data.tamanio; f++) 
        {
            for (int c = 0; c < this.data.tamanio; c++) 
            {
                matriz[f][c] = new Cuadro(f,c, data.pixeles, data);
                fondodefault.add(matriz[f][c]);
            }
        }
        panelmatriz.updateUI();
    }
        
    private void iniciarOpciones()
    {        
        this.binicio.setIcon(this.obtenerIcono(data.rutas[0], 80, 80));
        this.bfinal.setIcon(this.obtenerIcono(data.rutas[1], 80, 80));
        this.bcamino.setIcon(this.obtenerIcono("/Images/Camino.png", 80, 80));                
        this.btrafico.setIcon(this.obtenerIcono(data.rutas[3], 80, 80));        
        this.baccidente.setIcon(this.obtenerIcono(data.rutas[4], 80, 80));
        this.btrabajo.setIcon(this.obtenerIcono(data.rutas[5], 80, 80));
        this.bescolar.setIcon(this.obtenerIcono(data.rutas[6], 80, 80));
        this.blluvia.setIcon(this.obtenerIcono(data.rutas[7], 80, 80));
        this.bdesnivel.setIcon(this.obtenerIcono(data.rutas[8], 80, 80));
        this.bborrar.setIcon(this.obtenerIcono(data.rutas[9], 80, 80));
        
        this.binicio.updateUI();
        this.bfinal.updateUI();
        this.bcamino.updateUI();
        this.btrafico.updateUI();        
        this.baccidente.updateUI();        
        this.btrabajo.updateUI();        
        this.bescolar.updateUI();
        this.blluvia.updateUI();        
        this.bdesnivel.updateUI();
        this.bborrar.updateUI();          
    }
    
     private ImageIcon obtenerIcono(String ruta, int tamanioX, int tamanioY)
    {
        ImageIcon iconob = new ImageIcon();
        ImageIcon iconoa = (new ImageIcon(getClass().getResource(ruta)));
        iconob.setImage(iconoa.getImage().getScaledInstance(tamanioX, tamanioY, Image.SCALE_DEFAULT));
        return iconob;
    }       
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelprincipal = new javax.swing.JPanel();
        panelopciones = new javax.swing.JPanel();
        binicio = new javax.swing.JButton();
        bfinal = new javax.swing.JButton();
        bcamino = new javax.swing.JButton();
        btrafico = new javax.swing.JButton();
        baccidente = new javax.swing.JButton();
        btrabajo = new javax.swing.JButton();
        bescolar = new javax.swing.JButton();
        blluvia = new javax.swing.JButton();
        bdesnivel = new javax.swing.JButton();
        bborrar = new javax.swing.JButton();
        bcalcular = new javax.swing.JButton();
        barbol = new javax.swing.JButton();
        bcorrer = new javax.swing.JButton();
        bparar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mapa");

        panelprincipal.setBackground(new java.awt.Color(204, 204, 204));

        panelopciones.setBackground(new java.awt.Color(153, 153, 153));
        panelopciones.setOpaque(false);
        panelopciones.setPreferredSize(new java.awt.Dimension(235, 594));

        binicio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        binicio.setBorderPainted(false);
        binicio.setContentAreaFilled(false);
        binicio.setPreferredSize(new java.awt.Dimension(80, 80));
        binicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binicioActionPerformed(evt);
            }
        });

        bfinal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bfinal.setBorderPainted(false);
        bfinal.setContentAreaFilled(false);
        bfinal.setPreferredSize(new java.awt.Dimension(80, 80));
        bfinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bfinalActionPerformed(evt);
            }
        });

        bcamino.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bcamino.setBorderPainted(false);
        bcamino.setContentAreaFilled(false);
        bcamino.setPreferredSize(new java.awt.Dimension(80, 80));
        bcamino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaminoActionPerformed(evt);
            }
        });

        btrafico.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btrafico.setBorderPainted(false);
        btrafico.setContentAreaFilled(false);
        btrafico.setPreferredSize(new java.awt.Dimension(80, 80));
        btrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btraficoActionPerformed(evt);
            }
        });

        baccidente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        baccidente.setBorderPainted(false);
        baccidente.setContentAreaFilled(false);
        baccidente.setPreferredSize(new java.awt.Dimension(80, 80));
        baccidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baccidenteActionPerformed(evt);
            }
        });

        btrabajo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btrabajo.setBorderPainted(false);
        btrabajo.setContentAreaFilled(false);
        btrabajo.setPreferredSize(new java.awt.Dimension(80, 80));
        btrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btrabajoActionPerformed(evt);
            }
        });

        bescolar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bescolar.setBorderPainted(false);
        bescolar.setContentAreaFilled(false);
        bescolar.setPreferredSize(new java.awt.Dimension(80, 80));
        bescolar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bescolarActionPerformed(evt);
            }
        });

        blluvia.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        blluvia.setBorderPainted(false);
        blluvia.setContentAreaFilled(false);
        blluvia.setPreferredSize(new java.awt.Dimension(80, 80));
        blluvia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blluviaActionPerformed(evt);
            }
        });

        bdesnivel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bdesnivel.setBorderPainted(false);
        bdesnivel.setContentAreaFilled(false);
        bdesnivel.setPreferredSize(new java.awt.Dimension(80, 80));
        bdesnivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdesnivelActionPerformed(evt);
            }
        });

        bborrar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bborrar.setBorderPainted(false);
        bborrar.setContentAreaFilled(false);
        bborrar.setPreferredSize(new java.awt.Dimension(80, 80));
        bborrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bborrarActionPerformed(evt);
            }
        });

        bcalcular.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        bcalcular.setForeground(new java.awt.Color(204, 204, 0));
        bcalcular.setText("A*");
        bcalcular.setContentAreaFilled(false);
        bcalcular.setPreferredSize(new java.awt.Dimension(80, 31));
        bcalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcalcularActionPerformed(evt);
            }
        });

        barbol.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        barbol.setForeground(new java.awt.Color(204, 204, 0));
        barbol.setText("Arbol");
        barbol.setContentAreaFilled(false);
        barbol.setPreferredSize(new java.awt.Dimension(80, 31));
        barbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barbolActionPerformed(evt);
            }
        });

        bcorrer.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        bcorrer.setForeground(new java.awt.Color(0, 0, 153));
        bcorrer.setText("Correr");
        bcorrer.setContentAreaFilled(false);
        bcorrer.setPreferredSize(new java.awt.Dimension(80, 31));
        bcorrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcorrerActionPerformed(evt);
            }
        });

        bparar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        bparar.setForeground(new java.awt.Color(153, 0, 0));
        bparar.setText("Parar");
        bparar.setContentAreaFilled(false);
        bparar.setPreferredSize(new java.awt.Dimension(80, 31));
        bparar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpararActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelopcionesLayout = new javax.swing.GroupLayout(panelopciones);
        panelopciones.setLayout(panelopcionesLayout);
        panelopcionesLayout.setHorizontalGroup(
            panelopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelopcionesLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelopcionesLayout.createSequentialGroup()
                        .addComponent(bescolar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(blluvia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelopcionesLayout.createSequentialGroup()
                        .addComponent(binicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bfinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelopcionesLayout.createSequentialGroup()
                        .addComponent(baccidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelopcionesLayout.createSequentialGroup()
                        .addComponent(bcamino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelopcionesLayout.createSequentialGroup()
                        .addGroup(panelopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bcorrer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bdesnivel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bcalcular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bborrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barbol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bparar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );
        panelopcionesLayout.setVerticalGroup(
            panelopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelopcionesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bfinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(binicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcamino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(baccidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blluvia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bescolar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bdesnivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bborrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panelopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bcalcular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panelopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bcorrer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bparar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelprincipalLayout = new javax.swing.GroupLayout(panelprincipal);
        panelprincipal.setLayout(panelprincipalLayout);
        panelprincipalLayout.setHorizontalGroup(
            panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelprincipalLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(panelopciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(625, 625, 625))
        );
        panelprincipalLayout.setVerticalGroup(
            panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelprincipalLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(panelopciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelprincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void binicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binicioActionPerformed
        data.activo=0;
    }//GEN-LAST:event_binicioActionPerformed

    private void bfinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bfinalActionPerformed
        data.activo=1;
    }//GEN-LAST:event_bfinalActionPerformed

    private void bcaminoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaminoActionPerformed
        data.activo=2;
    }//GEN-LAST:event_bcaminoActionPerformed

    private void btraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btraficoActionPerformed
        data.activo=3;
    }//GEN-LAST:event_btraficoActionPerformed

    private void baccidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baccidenteActionPerformed
        data.activo=4;
    }//GEN-LAST:event_baccidenteActionPerformed

    private void btrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btrabajoActionPerformed
        data.activo=5;
    }//GEN-LAST:event_btrabajoActionPerformed

    private void bescolarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bescolarActionPerformed
        data.activo=6;
    }//GEN-LAST:event_bescolarActionPerformed

    private void blluviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blluviaActionPerformed
        data.activo=7;
    }//GEN-LAST:event_blluviaActionPerformed

    private void bdesnivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdesnivelActionPerformed
        data.activo=8;
    }//GEN-LAST:event_bdesnivelActionPerformed

    private void bborrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bborrarActionPerformed
        data.activo=9;
    }//GEN-LAST:event_bborrarActionPerformed

    private void bcalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcalcularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bcalcularActionPerformed

    private void barbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barbolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barbolActionPerformed

    private void bcorrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcorrerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bcorrerActionPerformed

    private void bpararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bpararActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bpararActionPerformed
    
//    public static void main(String args[]) 
//    {
//        try 
//        {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
//            {
//                if ("Windows".equals(info.getName())) 
//                {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) 
//        {java.util.logging.Logger.getLogger(Mapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
//        
//        
//        java.awt.EventQueue.invokeLater(() -> 
//        {
//            new Mapa().setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton baccidente;
    private javax.swing.JButton barbol;
    private javax.swing.JButton bborrar;
    private javax.swing.JButton bcalcular;
    private javax.swing.JButton bcamino;
    private javax.swing.JButton bcorrer;
    private javax.swing.JButton bdesnivel;
    private javax.swing.JButton bescolar;
    private javax.swing.JButton bfinal;
    private javax.swing.JButton binicio;
    private javax.swing.JButton blluvia;
    private javax.swing.JButton bparar;
    private javax.swing.JButton btrabajo;
    private javax.swing.JButton btrafico;
    private javax.swing.JPanel panelopciones;
    private javax.swing.JPanel panelprincipal;
    // End of variables declaration//GEN-END:variables
}
