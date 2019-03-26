 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.ui;

import Cloud.fc.ConnexionBD;
import Cloud.fc.Date2;
import Cloud.fc.Examen;
import Cloud.fc.FonctionnaliteBD;
import Cloud.fc.Image;
import Cloud.fc.Patient;
import Cloud.fc.Sexe;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Juliette-Trouillet
 */
public class ConsulterDMRMR extends javax.swing.JFrame {

    /**
     * Creates new form ConsulterDMRMR
     */
    private ArrayList<Examen> listeExamen = new ArrayList<>();
    private ArrayList<Patient> listePatient = new ArrayList<>();
    private ArrayList<Image> listeImage = new ArrayList<>();

    private String id = "";
    private Patient p = new Patient();

    public ConsulterDMRMR(String idPat) throws SQLException, Exception {
        initComponents();
        setSize(1500, 700);
        jLabel6.setSize(1500, 700);
        FonctionnaliteBD f = new FonctionnaliteBD();
        listeExamen = f.ListeExamenBD();
        listePatient = f.ListePatientBD(listeExamen);
        id = idPat;
        jLabel7.setText(id);

        // L'interface est remplie avec les informations du patient (pour que le PH sache le patient dont il regarde le DMR)
        for (int i = 0; i < listePatient.size(); i++) {
            if (listePatient.get(i).getId().equals(id)) {
                jLabel1.setText(listePatient.get(i).getNom());
                jLabel2.setText(listePatient.get(i).getPrenom());
                jLabel3.setText(listePatient.get(i).getDateN().toString());
                jLabel4.setText(listePatient.get(i).getSexe().toString());
            }
        }

        jTree1.setModel(this.buildTree()); // on applique le modèle du Tree dévelopé plus bas pour qu'il soit mis à jour 

    }

    ConnexionBD co = new ConnexionBD();

    //on construit le jTree ici 
    public DefaultTreeModel buildTree() {
        id = jLabel7.getText();
        int k = 0;
        //on défini la racine 
        DefaultMutableTreeNode racine = new DefaultMutableTreeNode("Liste des examens :");
        DefaultTreeModel myModel = new DefaultTreeModel(racine);
        //on parcours la liste d'examen en appliquant une condition qui nous permet de sélectionner uniquement le patient sélectionné par le MR dans l'interface précédente
        for (int i = 0; i < listeExamen.size(); i++) {
            if (listeExamen.get(i).getIdPat().equals(id)) {
                k += 1;
                // on récupère ensuite toutes les informations de tous les examens du patient 
                DefaultMutableTreeNode examens = new DefaultMutableTreeNode("Examen n°" + k);
                DefaultMutableTreeNode type = new DefaultMutableTreeNode(listeExamen.get(i).getTypeExamen());
                DefaultMutableTreeNode date = new DefaultMutableTreeNode(listeExamen.get(i).getDate());
                DefaultMutableTreeNode heure = new DefaultMutableTreeNode(listeExamen.get(i).getDate().getheure());
                DefaultMutableTreeNode nomPH = new DefaultMutableTreeNode(listeExamen.get(i).getIdMed());
                DefaultMutableTreeNode images = new DefaultMutableTreeNode("Images");
                for (int x = 0; x < listeImage.size(); x++) {
                    System.out.println(this.listeImage.get(x).getNumArchivage());
                    System.out.println(listeExamen.get(i).getNumArchiv());
                    if (this.listeImage.get(x).getNumArchivage().equals(listeExamen.get(i).getNumArchiv())) {
                        DefaultMutableTreeNode image = new DefaultMutableTreeNode(listeImage.get(x).getPath());
                        images.add(image);
                    }
                }

                examens.add(type);
                examens.add(date);
                examens.add(heure);
                examens.add(nomPH);
                examens.add(images);
                racine.add(examens);


                racine.add(examens);
            }
        }
        return myModel;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(1500, 700));

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nom");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(360, 80, 160, 22);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Prénom");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(360, 120, 170, 22);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date de naissance");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(800, 90, 160, 22);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sexe");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(870, 150, 100, 22);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Dossier Médical Radiologique");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(100, 20, 369, 30);

        jTree1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Liste des examens");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Examen 1");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Date");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Heure");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("PH");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Images");
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Image 1");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Image2");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Examen 2");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Date");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Heure");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("PH");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Images");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Image 1");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Image 2");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTree1ComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(363, 176, 609, 446);

        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton1.setText("Modifier image ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(821, 628, 151, 29);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cloud/image/flecheRetour.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(10, 20, 50, 40);

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("id");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(360, 150, 130, 22);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cloud/image/wallpaperFinal-4.png"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 1440, 670);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1234, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
  
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ModifImg modif = new ModifImg();
        modif.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTree1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTree1ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jTree1ComponentShown

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
            java.util.logging.Logger.getLogger(ConsulterDMRMR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsulterDMRMR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsulterDMRMR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsulterDMRMR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ConsulterDMRMR("67322946").setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ConsulterDMRMR.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
