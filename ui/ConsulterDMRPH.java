/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.ui;

import Cloud.fc.Examen;
import Cloud.fc.FonctionnaliteBD;
import Cloud.fc.Image;
import Cloud.fc.Patient;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Juliette-Trouillet
 */
public class ConsulterDMRPH extends javax.swing.JFrame {

    /**
     * Creates new form ConsulterDMR
     */
    private ArrayList<Examen> listeExamen = new ArrayList<>();
    private ArrayList<Patient> listePatient = new ArrayList<>();
    private ArrayList<Image> listeImage = new ArrayList<>();
    private String id = "";
    private Patient p = new Patient();
    private String PrenomPH;
    private String NomPH;

    public ConsulterDMRPH(String idPat, String PrenomPH, String NomPH) throws SQLException, Exception {
        initComponents();
        setSize(1500, 700);
        this.NomPH=NomPH;
        jLabel6.setSize(1500, 700);
        FonctionnaliteBD f = new FonctionnaliteBD();
        listeExamen = f.ListeExamenBD();
        listePatient = f.ListePatientBD(listeExamen);
        id = idPat;
        jLabel7.setText(id);
        listeImage = f.ListeImageBD(listeExamen);

        for (int i = 0; i < listePatient.size(); i++) {
            if (listePatient.get(i).getId().equals(id)) {
                jLabel2.setText(listePatient.get(i).getNom());
                jLabel3.setText(listePatient.get(i).getPrenom());
                jLabel4.setText(listePatient.get(i).getDateN().toString());
                jLabel5.setText(listePatient.get(i).getSexe().toString());
            }
        }
        // on appelle notre setter de model de jTree
        jTree1.setModel(this.buildTree());
    }

    public DefaultTreeModel buildTree() {
        id = jLabel7.getText();
        //on créé la racine du jTree
        DefaultMutableTreeNode racine = new DefaultMutableTreeNode("Liste des examens :");
        DefaultTreeModel myModel = new DefaultTreeModel(racine);
        int y = 0;
        // on parcours la liste d'examen du patient sélectionné
        for (int i = 0; i < listeExamen.size(); i++) {
            if (listeExamen.get(i).getIdPat().equals(id)) {
                y += 1;
                DefaultMutableTreeNode examens = new DefaultMutableTreeNode("Examen n°" + y);
                DefaultMutableTreeNode type = new DefaultMutableTreeNode(listeExamen.get(i).getTypeExamen());
                DefaultMutableTreeNode date = new DefaultMutableTreeNode(listeExamen.get(i).getDate());
                DefaultMutableTreeNode heure = new DefaultMutableTreeNode(listeExamen.get(i).getDate().getheure());
                DefaultMutableTreeNode nomPH = new DefaultMutableTreeNode(listeExamen.get(i).getIdMed());
                DefaultMutableTreeNode CR = new DefaultMutableTreeNode(listeExamen.get(i).getCr());
                DefaultMutableTreeNode images = new DefaultMutableTreeNode("Images");
                //on parcours la liste des images des examens du patient sélectionné
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
                examens.add(CR);
                examens.add(images);

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
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Dossier Médical Radiologique");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(79, 26, 369, 30);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nom");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(360, 70, 130, 22);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Prénom");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(360, 100, 150, 22);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date de naissance");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(780, 80, 157, 22);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sexe");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(840, 120, 100, 22);

        jTree1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Liste des examens");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Examen 1");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Date");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Heure");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Compte Rendu");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Images");
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Image 1");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Image 2");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Examen 1");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Date");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Heure");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Compte Rendu");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Images");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Image 1");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Image 2");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(jTree1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(356, 156, 596, 431);

        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton1.setText("Modifier Image");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(805, 593, 147, 29);

        jButton2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton2.setText("Ajouter Compte Rendu ");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(594, 593, 205, 29);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cloud/image/flecheRetour.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(6, 6, 36, 32);

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("id");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(360, 130, 110, 22);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cloud/image/wallpaperFinal-4.png"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 1500, 710);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(ConsulterDMRPH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ModifImg modif = new ModifImg();
        modif.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
      FonctionnaliteBD f;
       ArrayList<Examen> listeExamPat=new ArrayList<>();
           String numAr = null;
           String idExam="";
           
           String typeExamen="";
             for(int i =0;i<this.listeExamen.size();i++){
                 if(this.listeExamen.get(i).getIdPat().equals(this.jLabel7.getText())){
                     listeExamPat.add(this.listeExamen.get(i));
                 }
             }
             
             if(jTree1.getSelectionPath().getPathCount()==2){
      String indexExamen=(jTree1.getSelectionPath().getLastPathComponent().toString()).split("°")[1];
                 numAr=listeExamPat.get(Integer.parseInt(indexExamen)-1).getNumArchiv();
                 idExam=listeExamPat.get(Integer.parseInt(indexExamen)-1).getidExamen();
                 typeExamen=listeExamPat.get(Integer.parseInt(indexExamen)-1).getTypeExamen().toString();
                 
              }
        try {
            AjoutCr cr=new AjoutCr(this.jLabel2.getText(),numAr,idExam,this.jLabel7.getText(),typeExamen,this.NomPH);
            cr.setVisible(true);
//AjoutCr(String nomP,String NumArchiv,String idExamen, String idPatient, String TypeExamen,String nomMed)
        } catch (Exception ex) {
            Logger.getLogger(ConsulterDMRPH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(ConsulterDMRPH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsulterDMRPH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsulterDMRPH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsulterDMRPH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ConsulterDMRPH("67322946","Gregory","House").setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ConsulterDMRPH.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
