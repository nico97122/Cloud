/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.ui;

/**
 *
 * @author Juliette-Trouillet
 */
public class SecretaireMedicale extends javax.swing.JFrame {

    /**
     * Creates new form SecretaireMedicale
     */
    public SecretaireMedicale() {
        initComponents();
        setResizable(false);
        jLabel1.setSize(1800,900);
        jLabel7.setSize(1800,900);
        jLabel10.setSize(1800,900);
        setSize(1800,900);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jComboBox2 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel1.setLayout(null);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Patien 1", "Patient 2", "Patient 3", "Patient 4", "Patient 5", "Patient 6", "Patient 7", "Patien 1", "Patient 2", "Patient 3", "Patient 4", "Patient 5", "Patient 6", "Patient 7", "Patien 1", "Patient 2", "Patient 3", "Patient 4", "Patient 5", "Patient 6", "Patient 7", "Patien 1", "Patient 2", "Patient 3", "Patient 4", "Patient 5", "Patient 6", "Patient 7" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jList1ComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(330, 190, 770, 450);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Trier par...", "Médecin", "Date", "??" }));
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(320, 130, 121, 27);

        jButton4.setText("Trier");
        jButton4.setActionCommand("Trier");
        jPanel1.add(jButton4);
        jButton4.setBounds(480, 130, 75, 29);

        jTextField4.setText("Rechercher...");
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });
        jPanel1.add(jTextField4);
        jTextField4.setBounds(740, 130, 144, 28);

        jButton5.setText("OK");
        jPanel1.add(jButton5);
        jButton5.setBounds(890, 130, 75, 29);

        jButton6.setText("Exporter en PDF");
        jPanel1.add(jButton6);
        jButton6.setBounds(750, 690, 144, 29);

        jButton7.setText("Imprimer");
        jPanel1.add(jButton7);
        jButton7.setBounds(1000, 690, 101, 29);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cloud/image/wallpaperFinal-4.png"))); // NOI18N
        jPanel1.add(jLabel10);
        jLabel10.setBounds(0, 0, 1730, 830);

        jTabbedPane1.addTab("Exporter un DMR", jPanel1);

        jPanel2.setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cloud/image/paramètre .png"))); // NOI18N
        jPanel2.add(jButton1);
        jButton1.setBounds(90, 702, 60, 50);

        jButton2.setText("Déconnexion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(1140, 709, 150, 40);

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nom");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(90, 90, 160, 40);

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Prénom");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(90, 240, 220, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cloud/image/wallpaperFinal-4.png"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 1720, 830);

        jTabbedPane1.addTab("Accueil", jPanel2);

        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nom : ");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(310, 70, 90, 30);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Prénom : ");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(280, 170, 130, 30);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date de Naissance : ");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(150, 260, 260, 30);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Identifiant : ");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(240, 350, 170, 30);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Sexe : ");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(310, 440, 90, 30);

        jComboBox1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Femme", "Homme" }));
        jPanel3.add(jComboBox1);
        jComboBox1.setBounds(440, 440, 150, 27);

        jTextField1.setText("                            ");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jPanel3.add(jTextField1);
        jTextField1.setBounds(440, 70, 250, 28);

        jTextField2.setText("                            ");
        jTextField2.setToolTipText("");
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jPanel3.add(jTextField2);
        jTextField2.setBounds(440, 170, 250, 28);

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        jFormattedTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFormattedTextField1MouseClicked(evt);
            }
        });
        jPanel3.add(jFormattedTextField1);
        jFormattedTextField1.setBounds(440, 260, 250, 28);

        jTextField3.setText("                           ");
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });
        jPanel3.add(jTextField3);
        jTextField3.setBounds(440, 360, 250, 28);

        jButton3.setText("Ajouter ce patient");
        jPanel3.add(jButton3);
        jButton3.setBounds(780, 670, 160, 29);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cloud/image/wallpaperFinal-4.png"))); // NOI18N
        jPanel3.add(jLabel7);
        jLabel7.setBounds(0, 0, 1730, 830);

        jTabbedPane1.addTab("Ajouter un patient", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1767, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ConnexionSIR decoSM = new ConnexionSIR();
        decoSM.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        jTextField4.setText("");
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        jTextField1.setText("");
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        jTextField2.setText("");
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jFormattedTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextField1MouseClicked
        jFormattedTextField1.setText("");
    }//GEN-LAST:event_jFormattedTextField1MouseClicked

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        jTextField3.setText("");
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jList1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jList1ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jList1ComponentShown

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SecretaireMedicale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SecretaireMedicale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SecretaireMedicale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SecretaireMedicale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SecretaireMedicale().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
