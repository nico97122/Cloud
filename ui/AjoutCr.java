/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.ui;

import Cloud.fc.*;
import Cloud.fc.Fonctionnalite;
import Cloud.fc.FonctionnaliteBD;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author nicolas tyndal
 */
public class AjoutCr extends javax.swing.JFrame {

        private String nomP;
        private String numArchiv;
        private String idExamen;
        private String idPatient;
        private String typeExamen;
        private String nomMed;
    /**
     * Creates new form AjoutCr
     */
    public AjoutCr() throws Exception {
        initComponents();
        nomP="TYNDAL";
        numArchiv="13/03/2019 22:20";
        idExamen="538698839";
        idPatient="7239192132";
        typeExamen="rx";
        this.nomMed="HOUSE";
         this.jLabel6.setText(nomP);
       this.jLabel8.setText(idPatient);
       this.jLabel7.setText(idExamen);
       this.jLabel9.setText(numArchiv);
       this.jLabel11.setText(typeExamen);
       this.setSize(1200, 650);
        FonctionnaliteBD f=new FonctionnaliteBD();
       ArrayList<Examen> ListeExam=f.ListeExamenBD();
       ArrayList<Image> ListeImg=f.ListeImageBD(ListeExam);
       DefaultListModel model = new DefaultListModel();
        DefaultListModel modelVide = new DefaultListModel();
       modelVide.addElement("aucune image pour cet examen");
       for (int i=0;i<ListeImg.size();i++){
           if(ListeImg.get(i).getNumArchivage().equals(numArchiv)){
               
               
               model.addElement(ListeImg.get(i).getPath());
           }
       }
     
       this.jList1.setModel(model);
         if(model.getSize()==0){
           this.jList1.setModel(modelVide);
       }
         if(!this.jList1.getModel().getElementAt(0).equals("aucune image pour cet examen")){
       jList1.setSelectedIndex(0);
       
       this.panelIm1.setImage(this.jList1.getSelectedValue());}
    }
public AjoutCr(String nomP,String NumArchiv,String idExamen, String idPatient, String TypeExamen,String nomMed) throws Exception {
        initComponents();
       this.nomP=nomP;
       this.numArchiv=NumArchiv;
       this.idExamen=idExamen;
       this.idPatient=idPatient;
       this.typeExamen=TypeExamen;
       this.nomMed=nomMed;
       this.jLabel6.setText(nomP);
       this.jLabel8.setText(idPatient);
       this.jLabel7.setText(idExamen);
       this.jLabel9.setText(NumArchiv);
       this.jLabel11.setText(TypeExamen);
       FonctionnaliteBD f=new FonctionnaliteBD();
       ArrayList<Examen> ListeExam=f.ListeExamenBD();
       ArrayList<Image> ListeImg=f.ListeImageBD(ListeExam);
       DefaultListModel model = new DefaultListModel();
       DefaultListModel modelVide = new DefaultListModel();
       modelVide.addElement("aucune image pour cet examen");
       for (int i=0;i<ListeImg.size();i++){
           if(ListeImg.get(i).getNumArchivage().equals(NumArchiv)){
               
               
               model.addElement(ListeImg.get(i).getPath());
           }
       }
       
       this.jList1.setModel(model);
       if(model.getSize()==0){
           this.jList1.setModel(modelVide);
       }
           if(!this.jList1.getModel().getElementAt(0).equals("aucune image pour cet examen")){
       jList1.setSelectedIndex(0);
       this.panelIm1.setImage(this.jList1.getSelectedValue());}
       this.setSize(1200, 650);
       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panelIm1 = new Cloud.ui.PanelIm();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<String>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cloud/image/flecheRetour.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(40, 20, 50, 40);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("entrez votre compte rendu...");
        jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextArea1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(80, 240, 630, 330);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nom :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 100, 90, 40);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date examen :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(420, 170, 210, 30);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Id Examen :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(270, 40, 170, 30);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Identifiant :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(450, 110, 170, 30);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(260, 110, 100, 30);

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel7);
        jLabel7.setBounds(460, 40, 110, 0);

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel8);
        jLabel8.setBounds(620, 110, 90, 0);

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel9);
        jLabel9.setBounds(630, 170, 90, 0);

        panelIm1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelIm1Layout = new javax.swing.GroupLayout(panelIm1);
        panelIm1.setLayout(panelIm1Layout);
        panelIm1Layout.setHorizontalGroup(
            panelIm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
        );
        panelIm1Layout.setVerticalGroup(
            panelIm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );

        getContentPane().add(panelIm1);
        panelIm1.setBounds(810, 280, 320, 210);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "img1", "img2", "img3" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(810, 90, 320, 140);

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 28)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Type de l'examen:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(20, 170, 260, 40);

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel11);
        jLabel11.setBounds(280, 180, 110, 0);

        jButton2.setText("Ajouter ce compte rendu\n");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(940, 530, 190, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cloud/image/wallpaperFinal-4.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 10, 1190, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
       if(!this.jList1.getModel().getElementAt(0).equals("aucune image pour cet examen")){
        if (jList1.isSelectionEmpty() == false) {
            try {
                this.panelIm1.setImage(jList1.getSelectedValue());
            } catch (IOException ex) {
                Logger.getLogger(AjoutCr.class.getName()).log(Level.SEVERE, null, ex);
            }
        }}
    }//GEN-LAST:event_jList1MouseClicked

    private void jTextArea1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MouseClicked
       this.jTextArea1.selectAll();
    }//GEN-LAST:event_jTextArea1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
       if(this.jTextArea1.getText().equals("entrez votre compte rendu...")){
           JOptionPane.showMessageDialog(this,"Veuillez éditer votre compte-rendu","Erreur", JOptionPane.WARNING_MESSAGE);
       }
       else{
        ConnexionBD co =new ConnexionBD();
       String nomMed=this.nomMed;
       
       String jour=Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+"/";
       if(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)<10){
            jour="0"+Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+"/";
       }
       String month=Calendar.getInstance().get(Calendar.MONTH)+"/";
       if(Calendar.getInstance().get(Calendar.MONTH)<10){
           month="0"+Calendar.getInstance().get(Calendar.MONTH)+"/";
       }
       String year=Calendar.getInstance().get(Calendar.YEAR)+" à ";
       String heure=Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+":";
       if(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)<10){
            heure="0"+Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+":";
       }
       String minute=Calendar.getInstance().get(Calendar.MINUTE)+"";
       if(Calendar.getInstance().get(Calendar.MINUTE)<10){
           minute= Calendar.getInstance().get(Calendar.MINUTE)+"";
       }
       
       
       String dateCr=jour+month+year+heure+minute;
          
    
            try {
                co.connexion();
            } catch (Exception ex) {
                Logger.getLogger(AjoutCr.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(this.jTextArea1.getText()+"\n fait le: "+dateCr+"par "+ nomMed);
            co.update("examen", "compterendu= '"+this.jTextArea1.getText()+"\n fait le: "+dateCr+" par Dr."+ nomMed+"'" , "where numeroarchivage="+"'"+this.jLabel9.getText()+"'");
             JOptionPane.showMessageDialog(this,"Compte-rendu ajouté","Confirmation", JOptionPane.INFORMATION_MESSAGE);
             this.dispose();
       }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(AjoutCr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutCr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutCr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutCr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AjoutCr().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(AjoutCr.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private Cloud.ui.PanelIm panelIm1;
    // End of variables declaration//GEN-END:variables
}
