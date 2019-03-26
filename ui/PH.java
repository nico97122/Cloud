/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.ui;

import Cloud.fc.*;
import java.awt.Component;
import java.io.File;
import java.util.Vector;
import javax.swing.JFileChooser;
import java.lang.Package;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Juliette-Trouillet
 */
public class PH extends javax.swing.JFrame {

    Vector<String> dataNomImg = new Vector();
    ConnexionBD co = new ConnexionBD();
    ConnexionPACS con = new ConnexionPACS();
    Vector<String> dataUrlImg = new Vector();
    Vector<String> ListeImgV = new Vector();
    public ArrayList<ArrayList<String>> ListeImgR = new ArrayList<ArrayList<String>>();
    public ArrayList<String> ListeImgR2 = new ArrayList<String>();
    private String idPatient;
    private DefaultListModel modelFromBD = new DefaultListModel();
    private DefaultListModel modelFromBDExam = new DefaultListModel();
    private ArrayList<Examen> listeExamen = new ArrayList<>();
    private ArrayList<Patient> listePatient = new ArrayList<>();
    private ArrayList<Image> listeImage = new ArrayList<>();
    private ArrayList<PersonneH> listePerso = new ArrayList<>();
    int p = 0; //compteur pour reinitialiser la fenetre d'affichage des url;
    String NomPatient = "";
    String PrenomPatient = "";

    /**
     * Creates new form PH
     */
    public PH() throws SQLException, Exception {
        initComponents();
        setSize(1400, 700);
        jLabel3.setSize(1380, 660);
        jLabel4.setSize(1300, 660);
        jLabel13.setSize(1380, 660);
        jLabel12.setSize(1380, 660);

        co.connexion();
        FonctionnaliteBD f = new FonctionnaliteBD();

        listeExamen = f.ListeExamenBD();
        listeImage = f.ListeImageBD(listeExamen);
        listePatient = f.ListePatientBD(listeExamen);
        jTree1.setModel(this.buildTree());
      

    }

    public PH(String nomPH, String prenomPH) throws Exception {
        initComponents();
        setSize(1500, 700);
        jLabel3.setSize(1300, 700);
        jLabel4.setSize(1300, 700);
        jLabel1.setText(nomPH);
        jLabel13.setSize(1380, 660);
        jLabel2.setText(prenomPH);
        co.connexion();
        FonctionnaliteBD f = new FonctionnaliteBD();
        listePerso = f.ListePersonnelBD();
        listeExamen = f.ListeExamenBD();
        listeImage = f.ListeImageBD(listeExamen);
        listePatient = f.ListePatientBD(listeExamen);
        jTree1.setModel(this.buildTree());
        String idPH=""; //là on va indiquer au PH le nombre de compte rendu qui ne sont pas remplis
        for(int j=0;j<listePerso.size();j++){
            if(listePerso.get(j).getNom().equals(nomPH)){
                idPH=listePerso.get(j).getId();
            }
        }
        int q=0;
        for(int i=0;i<listeExamen.size();i++){   
            if(listeExamen.get(i).getCr().equals("non fait") && listeExamen.get(i).getIdMed().equals(idPH)){
                q=q+1;
            }
        }
        jLabel18.setText("Vous avez "+q+" comptes-rendus à écrire");

    }

    public PH(String nomPH, String prenomPH, String TypePerso) throws Exception {
        initComponents();
        setSize(1500, 700);
        jLabel3.setSize(1300, 700);
        jLabel4.setSize(1300, 700);
        jLabel1.setText(nomPH);
        jLabel13.setSize(1380, 660);
        jLabel2.setText(prenomPH);
        co.connexion();
        FonctionnaliteBD f = new FonctionnaliteBD();
        listeExamen = f.ListeExamenBD();
        listeImage = f.ListeImageBD(listeExamen);
        listePatient = f.ListePatientBD(listeExamen);
        jTree1.setModel(this.buildTree());
        if (TypePerso.contentEquals("INT")) {
            jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cloud/image/ph.png")));
        }
        String idPH=""; //là on va indiquer au PH le nombre de compte rendu qui ne sont pas remplis
        for(int j=0;j<listePerso.size();j++){
            if(listePerso.get(j).getNom().equals(nomPH)){
                idPH=listePerso.get(j).getId();
            }
        }
        int q=0;
        for(int i=0;i<listeExamen.size();i++){   
            if(listeExamen.get(i).getCr().equals("non fait") && listeExamen.get(i).getIdMed().equals(idPH)){
                q=q+1;
            }
        }
        jLabel18.setText("Vous avez "+q+" comptes-rendus à écrire");
    }

    public DefaultTreeModel buildTree() {
        try {
            con.connexion();
        } catch (Exception ex) {
            Logger.getLogger(PH.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultMutableTreeNode racine = new DefaultMutableTreeNode("Liste des Patients :");
        DefaultTreeModel myModel2 = new DefaultTreeModel(racine);
        int k = 0;
        for (int i = 0; i < listePatient.size(); i++) {

            DefaultMutableTreeNode patients = new DefaultMutableTreeNode(listePatient.get(i).getNom());
            DefaultMutableTreeNode prenomPat = new DefaultMutableTreeNode(listePatient.get(i).getPrenom());
            DefaultMutableTreeNode idPat = new DefaultMutableTreeNode(listePatient.get(i).getId());
            DefaultMutableTreeNode sexePat = new DefaultMutableTreeNode(listePatient.get(i).getSexe());
            DefaultMutableTreeNode dateNPat = new DefaultMutableTreeNode(listePatient.get(i).getDateN());
            DefaultMutableTreeNode Examens = new DefaultMutableTreeNode("Liste de ses examens");
            k = 0;
            for (int j = 0; j < listeExamen.size(); j++) {

                if (listeExamen.get(j).getIdPat().equals(listePatient.get(i).getId())) {
                    k += 1;
                    DefaultMutableTreeNode exam = new DefaultMutableTreeNode("Examen n°" + k);
                    DefaultMutableTreeNode typeE = new DefaultMutableTreeNode(listeExamen.get(j).getTypeExamen());
                    DefaultMutableTreeNode dateE = new DefaultMutableTreeNode(listeExamen.get(j).getDate().toString());
                    DefaultMutableTreeNode heureE = new DefaultMutableTreeNode(listeExamen.get(j).getDate().getheure());

                    DefaultMutableTreeNode CRE = new DefaultMutableTreeNode(listeExamen.get(j).getCr());
                    DefaultMutableTreeNode images = new DefaultMutableTreeNode("Images");
                    for (int x = 0; x < listeImage.size(); x++) {
                        if (this.listeImage.get(x).getNumArchivage().equals(listeExamen.get(j).getNumArchiv())) {
                            DefaultMutableTreeNode image = new DefaultMutableTreeNode(listeImage.get(x).getPath());
                            images.add(image);
                        }
                    }
                    Examens.add(exam);
                    exam.add(typeE);
                    exam.add(dateE);
                    exam.add(heureE);
                    exam.add(CRE);
                    exam.add(images);
                }
            }
            racine.add(patients);
            patients.add(prenomPat);
            patients.add(idPat);
            patients.add(sexePat);
            patients.add(dateNPat);
            patients.add(Examens);

        }
        return myModel2;
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
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jButton8 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<String>();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<String>();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<String>();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        jButton21 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel4.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nom");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(111, 90, 430, 58);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Prénom ");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(110, 230, 440, 58);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cloud/image/paramètre .png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);
        jButton1.setBounds(84, 581, 44, 30);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cloud/image/Doctor_Male_icon-icons.com_75051.png"))); // NOI18N
        jLabel15.setText("jLabel15");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(980, 50, 230, 256);

        jButton15.setText("Déconnexion");
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton15MouseClicked(evt);
            }
        });
        jPanel4.add(jButton15);
        jButton15.setBounds(810, 565, 120, 50);

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Vous avez x compte rendu à rédiger");
        jPanel4.add(jLabel18);
        jLabel18.setBounds(110, 440, 730, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cloud/image/wallpaperFinal-4.png"))); // NOI18N
        jPanel4.add(jLabel3);
        jLabel3.setBounds(0, 0, 1310, 740);

        jTabbedPane1.addTab("Accueil", jPanel4);

        jPanel3.setLayout(null);

        jComboBox1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Trier par...", "Nom", "Prenom", "Id" }));
        jPanel3.add(jComboBox1);
        jComboBox1.setBounds(200, 120, 128, 27);

        jButton3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton3.setText("Trier");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(340, 120, 77, 29);

        jButton4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton4.setText("OK");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jPanel3.add(jButton4);
        jButton4.setBounds(660, 120, 75, 29);

        jTextField1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jTextField1.setText("Rechercher ...");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jPanel3.add(jTextField1);
        jTextField1.setBounds(540, 120, 107, 29);

        jButton5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton5.setText("Imprimer");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jPanel3.add(jButton5);
        jButton5.setBounds(1110, 600, 110, 40);

        jButton6.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton6.setText("Exporter en PDF");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6);
        jButton6.setBounds(940, 600, 160, 40);

        jButton14.setText("Editer un CR");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton14);
        jButton14.setBounds(800, 600, 130, 40);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Patient 1", "Patient 2", "Patient 3", "Patient 4", "Patient 5", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jList1);

        jPanel3.add(jScrollPane4);
        jScrollPane4.setBounds(200, 170, 540, 410);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("selectionnez un patient...");
        jScrollPane5.setViewportView(jTextArea2);

        jPanel3.add(jScrollPane5);
        jScrollPane5.setBounds(850, 170, 330, 420);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cloud/image/wallpaperFinal-4.png"))); // NOI18N
        jPanel3.add(jLabel4);
        jLabel4.setBounds(0, 0, 1310, 740);

        jTabbedPane1.addTab("DMR", jPanel3);

        jPanel2.setLayout(null);

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Images à modifier");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(240, 50, 260, 40);

        jButton13.setText("Modifier");
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton13MouseClicked(evt);
            }
        });
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton13);
        jButton13.setBounds(850, 60, 90, 40);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Liste des patients");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Nom du patient1");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("prénom");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("adresse");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("id");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("examen");
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("type exam1");
        javax.swing.tree.DefaultMutableTreeNode treeNode5 = new javax.swing.tree.DefaultMutableTreeNode("url image1");
        treeNode4.add(treeNode5);
        treeNode5 = new javax.swing.tree.DefaultMutableTreeNode("numéro archivage1");
        treeNode4.add(treeNode5);
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("type examen 2");
        treeNode5 = new javax.swing.tree.DefaultMutableTreeNode("url image 2");
        treeNode4.add(treeNode5);
        treeNode5 = new javax.swing.tree.DefaultMutableTreeNode("num archivage2");
        treeNode4.add(treeNode5);
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Nom du patient2");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("prénom");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("adresse");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("id");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("examen");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("type exam1");
        treeNode5 = new javax.swing.tree.DefaultMutableTreeNode("url image1");
        treeNode4.add(treeNode5);
        treeNode5 = new javax.swing.tree.DefaultMutableTreeNode("numéro archivage1");
        treeNode4.add(treeNode5);
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("type examen 2");
        treeNode5 = new javax.swing.tree.DefaultMutableTreeNode("url image 2");
        treeNode4.add(treeNode5);
        treeNode5 = new javax.swing.tree.DefaultMutableTreeNode("num archivage2");
        treeNode4.add(treeNode5);
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTree1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(240, 110, 700, 530);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cloud/image/wallpaperFinal-4.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        jLabel12.setMaximumSize(new java.awt.Dimension(1800, 900));
        jLabel12.setMinimumSize(new java.awt.Dimension(1800, 900));
        jPanel2.add(jLabel12);
        jLabel12.setBounds(0, 0, 1800, 770);

        jTabbedPane1.addTab("Modifier une Image", jPanel2);

        jPanel1.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nom : ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(190, 150, 91, 34);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 28)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Type d'examen");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(360, 30, 240, 40);

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Prénom : ");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(160, 290, 129, 34);

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 28)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Date de Naissance : ");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 440, 275, 34);

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 28)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Date : ");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(720, 140, 89, 34);

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 28)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Compte-rendu:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(720, 290, 260, 40);

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 28)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Sélectionner une image :");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(70, 540, 333, 40);

        jComboBox2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "rx", "radio", "echographie", "scanner", "irm", "mammographie", "scintigraphie" }));
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(600, 40, 180, 27);

        jTextField2.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jTextField2.setToolTipText("");
        jPanel1.add(jTextField2);
        jTextField2.setBounds(310, 150, 270, 36);

        jTextField3.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3);
        jTextField3.setBounds(310, 290, 270, 37);

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        jFormattedTextField1.setText("jj/mm/aaaa");
        jFormattedTextField1.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jFormattedTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFormattedTextField1MouseClicked(evt);
            }
        });
        jPanel1.add(jFormattedTextField1);
        jFormattedTextField1.setBounds(310, 430, 270, 40);

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        jFormattedTextField2.setText("jj/mm/aaaa");
        jFormattedTextField2.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jFormattedTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFormattedTextField2MouseClicked(evt);
            }
        });
        jPanel1.add(jFormattedTextField2);
        jFormattedTextField2.setBounds(820, 140, 240, 36);

        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        jFormattedTextField3.setText("hh:mm");
        jFormattedTextField3.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jFormattedTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFormattedTextField3MouseClicked(evt);
            }
        });
        jPanel1.add(jFormattedTextField3);
        jFormattedTextField3.setBounds(830, 210, 230, 37);

        jButton8.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton8.setText("Parcourir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(740, 550, 110, 29);

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "selectionnez une image..." };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(410, 550, 290, 90);

        jButton9.setText("RetirerImgS");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(740, 600, 110, 30);

        jButton10.setText("ViderListe");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(870, 600, 110, 30);

        jButton11.setText("Visualiser");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11);
        jButton11.setBounds(870, 550, 110, 30);

        jButton12.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jButton12.setText("Enregistrer");
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton12MouseClicked(evt);
            }
        });
        jPanel1.add(jButton12);
        jButton12.setBounds(1060, 570, 120, 60);

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 0, 28)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Heure : ");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(720, 210, 108, 34);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(720, 330, 410, 180);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cloud/image/wallpaperFinal-4.png"))); // NOI18N
        jPanel1.add(jLabel13);
        jLabel13.setBounds(0, 0, 1310, 740);

        jTabbedPane1.addTab("Ajouter un examen", jPanel1);

        jPanel5.setLayout(null);

        jList4.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Patient 1", "Patient 2", "Patient 3", "Patient 4", "Patient 5", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane7.setViewportView(jList4);

        jPanel5.add(jScrollPane7);
        jScrollPane7.setBounds(300, 130, 570, 400);

        jTextField4.setText("Rechercher...");
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField4);
        jTextField4.setBounds(650, 90, 140, 30);

        jButton2.setText("OK");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel5.add(jButton2);
        jButton2.setBounds(790, 90, 79, 29);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Trier par...", "identifiant examen", "date", "nom patient" }));
        jPanel5.add(jComboBox3);
        jComboBox3.setBounds(300, 90, 110, 30);

        jButton16.setText("Trier");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton16);
        jButton16.setBounds(430, 90, 75, 29);

        jButton17.setText("Parcourir");
        jButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton17MouseClicked(evt);
            }
        });
        jPanel5.add(jButton17);
        jButton17.setBounds(650, 550, 100, 30);

        jButton18.setText("Visualiser");
        jButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton18MouseClicked(evt);
            }
        });
        jPanel5.add(jButton18);
        jButton18.setBounds(760, 550, 100, 30);

        jButton19.setText("retirerImgS");
        jButton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton19MouseClicked(evt);
            }
        });
        jPanel5.add(jButton19);
        jButton19.setBounds(650, 590, 100, 30);

        jButton20.setText("ViderListe");
        jButton20.setToolTipText("");
        jButton20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton20MouseClicked(evt);
            }
        });
        jPanel5.add(jButton20);
        jButton20.setBounds(760, 590, 100, 30);

        jList3.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Selectioner une image ..." };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane8.setViewportView(jList3);

        jPanel5.add(jScrollPane8);
        jScrollPane8.setBounds(300, 550, 340, 110);

        jButton21.setText("Ajouter l'image");
        jButton21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton21MouseClicked(evt);
            }
        });
        jPanel5.add(jButton21);
        jButton21.setBounds(650, 630, 210, 29);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cloud/image/wallpaperFinal-4.png"))); // NOI18N
        jPanel5.add(jLabel17);
        jLabel17.setBounds(0, 0, 1800, 739);

        jTabbedPane1.addTab("ajouter une image", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Accueil");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        jTextField1.setText("");
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        jTextField3.setText("");
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jFormattedTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextField2MouseClicked
        jFormattedTextField2.setText("");
    }//GEN-LAST:event_jFormattedTextField2MouseClicked

    private void jFormattedTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextField3MouseClicked
        jFormattedTextField3.setText("");
    }//GEN-LAST:event_jFormattedTextField3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String iddbPerso = "";

            FonctionnaliteBD f = new FonctionnaliteBD();
            ArrayList<PersonneH> listePerso = f.ListePersonnelBD();
            for (int i = 0; i < listePerso.size(); i++) {

                if (listePerso.get(i).getNom().equals(this.jLabel1.getText() + "")) {
                    iddbPerso = listePerso.get(i).getId();

                }
            }
            ChangerMdp changemanip = new ChangerMdp(iddbPerso);
            changemanip.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(ManipRadio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        JFileChooser fileOuvrir = new JFileChooser();

        if (fileOuvrir.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            this.dataUrlImg.add(new File(fileOuvrir.getSelectedFile().getAbsolutePath()).getPath());
            dataNomImg.add(new File(fileOuvrir.getSelectedFile().getAbsolutePath()).getName());
            this.jList2.setListData(dataNomImg);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked

        if (jList2.getLastVisibleIndex() != -1) {

            if ("selectionnez une image...".equals(jList2.getModel().getElementAt(0))) {

                Vector<String> dataIni = new Vector();
                this.jList2.setListData(dataIni);

            }
        }


    }//GEN-LAST:event_jList2MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        if (jList2.getSelectedIndex() != -1) {
            int elemASup = this.jList2.getSelectedIndex();
            dataUrlImg.remove(elemASup);
            dataNomImg.remove(elemASup);
            jList2.setListData(dataNomImg);
        }
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        Vector<String> dataIni = new Vector();
        dataUrlImg.clear();
        dataNomImg.clear();
        jList2.setListData(dataIni);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        if (jList2.getLastVisibleIndex() != -1) {
            if (!"selectionnez une image...".equals(jList2.getModel().getElementAt(0))) {
                new VisualisationImg(dataUrlImg.elementAt(jList2.getSelectedIndex())).setVisible(true);
            }
        }
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:

        // ModifImg modif=new ModifImg(pathImg);
        //  modif.setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseClicked
        // TODO add your handling code here:
        ConnexionSIR co = new ConnexionSIR();
        this.dispose();
        co.setVisible(true);
    }//GEN-LAST:event_jButton15MouseClicked

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        if (jList1.isSelectionEmpty() == false) {

            Patient p = new Patient();

            try {

                String IdNomPrenom = jList1.getSelectedValue().toString();
                String nom = IdNomPrenom.split("   ")[1];
                String prenom = IdNomPrenom.split("   ")[2];
                String Id = IdNomPrenom.split("   ")[0];
                FonctionnaliteBD f = new FonctionnaliteBD();
                ArrayList<Examen> listeE = f.ListeExamenBD();
                ArrayList<Patient> listeP = f.ListePatientBD(listeE);
                ArrayList<PersonneH> listePersonnel = f.ListePersonnelBD();
                for (int i = 0; i < listeP.size(); i++) {
                    if (listeP.get(i).getId().equals(Id)) {
                        p.setDateN(listeP.get(i).getDateN());
                        p.setId(Id);
                        p.setListeExam(listeP.get(i).getListeExam());
                        p.setNom(nom);
                        p.setPrenom(prenom);
                        p.setSexe(listeP.get(i).getSexe());

                    }

                }
                String AffichageLE = "";
                String nomPracticien = "";

                for (int j = 0; j < p.getListeExam().size(); j++) {
                    for (int x = 0; x < listePersonnel.size(); x++) {
                        //System.out.println("idmed"+p.getListeExam().get(j).);
                        //  System.out.println("idmed"+listePersonnel.get(x).getId());
                        if (p.getListeExam().get(j).getIdMed().equals(listePersonnel.get(x).getId())) {

                            nomPracticien = listePersonnel.get(x).getNom() + listePersonnel.get(x).getPrenom();
                        }
                    }

                }
                for (int i = 0; i < p.getListeExam().size(); i++) {
                    AffichageLE += "\n  Type Examen : " + p.getListeExam().get(i).getTypeExamen().toString() + "\n" + "  Date : " + p.getListeExam().get(i).getDate() + "\n" + "  Praticien : " + nomPracticien + "\n" + "  Compte Rendu: :\n" + p.getListeExam().get(i).getCr() + "\n";

                }

                this.jTextArea2.setText("Nom :" + nom + "\n" + "Prénom" + prenom + "\n" + "Date de Naissance :" + p.getDateN().toString() + "\n" + "Sexe :" + p.getSexe().toString() + "\n" + "Examens : \n" + AffichageLE);

            } catch (Exception ex) {
                Logger.getLogger(SecretaireMedicale.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jList1MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        //on construit la liste qui est dans l'interface PH dans l'onglet DMR 
        try {
            co.connexion();
        } catch (Exception ex) {
            Logger.getLogger(PH.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FonctionnaliteBD f = new FonctionnaliteBD();
            DefaultListModel model = new DefaultListModel();
            ArrayList<String> listNom = new ArrayList<>();
            ArrayList<String> listPrenom = new ArrayList<>();
            //ArrayList<ArrayList<String>> listepatient = new ArrayList<>();

            ArrayList<Examen> listeE = f.ListeExamenBD();

            ArrayList<Patient> listeP = f.ListePatientBD(listeE);

            for (int i = 0; i < listeP.size(); i++) {
                model.addElement(listeP.get(i).getId() + "   " + listeP.get(i).getNom() + "   " + listeP.get(i).getPrenom());

            }
            jList1.setModel(model);
            modelFromBD = model;

        } catch (Exception ex) {
            Logger.getLogger(SecretaireMedicale.class.getName()).log(Level.SEVERE, null, ex);
        }

        // on construit la liste qui est dans l'interface Ph dans l'onglet ajouter une image
        try {
            co.connexion();
        } catch (Exception ex) {
            Logger.getLogger(PH.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FonctionnaliteBD f = new FonctionnaliteBD();
            DefaultListModel model2 = new DefaultListModel();
            ArrayList<String> listNom = new ArrayList<>();
            ArrayList<String> listPrenom = new ArrayList<>();
            //ArrayList<ArrayList<String>> listepatient = new ArrayList<>();
            ArrayList<Examen> listeE = f.ListeExamenBD();
            ArrayList<Patient> listeP = f.ListePatientBD(listeE);

            for (int j = 0; j < listeE.size(); j++) {
                for (int k = 0; k < listeP.size(); k++) {
                    if (listeE.get(j).getIdPat().equals(listeP.get(k).getId())) {
                        NomPatient = listeP.get(k).getNom();
                        PrenomPatient = listeP.get(k).getPrenom();
                    }
                }
                model2.addElement(listeE.get(j).getTypeExamen() + "  " + listeE.get(j).getNumArchiv() + "  " + NomPatient + " " + PrenomPatient);
            }
            jList4.setModel(model2);
            modelFromBDExam = model2;

        } catch (Exception ex) {
            Logger.getLogger(SecretaireMedicale.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_formWindowOpened

    private void jButton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseClicked
        ArrayList<String> listenompatient = new ArrayList<>();
        ConnexionBD co = new ConnexionBD();
        boolean b = false;
        try {
            co.connexion();
        } catch (Exception ex) {
            Logger.getLogger(PH.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {// verifie si la patient existe dans la bd            

            listenompatient = co.requete("nom", "patient", "").get(0);

        } catch (SQLException ex) {
            Logger.getLogger(PH.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < listenompatient.size(); i++) {
            if (listenompatient.get(i).toLowerCase().equals(this.jTextField2.getText().toLowerCase())) {
                b = true;
            }
        }

        if (b == false) {
            JOptionPane.showMessageDialog(this, "Patient Inexistant", "Erreur", JOptionPane.WARNING_MESSAGE);
        } else if (this.jList2.getModel().getElementAt(0).equals("selectionnez une image...") || this.jList2.getModel().getElementAt(0).equals("")) {
            JOptionPane.showMessageDialog(this, "Veuillez ajouter une image", "Erreur", JOptionPane.WARNING_MESSAGE);
        } else if (jFormattedTextField2.getText().equals("jj/mm/aaaa")) {  //on regarde si l'utilisateur à bien completé la date
            JOptionPane.showMessageDialog(this, "Veuillez compléter la date de l'examen", "Erreur", JOptionPane.WARNING_MESSAGE);
        } else if (jFormattedTextField3.getText().equals("hh:mm")) {
            JOptionPane.showMessageDialog(this, "Veuillez compléter l'heure de l'examen", "Erreur", JOptionPane.WARNING_MESSAGE);
        } else if (jFormattedTextField1.getText().equals("jj/mm/aaaa")) {
            JOptionPane.showMessageDialog(this, "Veuillez compléter la date de naissance", "Erreur", JOptionPane.WARNING_MESSAGE);

        } else {

            ArrayList<ArrayList<String>> listeIdExamen = new ArrayList<>();
            String nom = this.jTextField2.getText();
            String prenom = this.jTextField3.getText();
            Date2 date = new Date2(jFormattedTextField1.getText());
            Date2 dateE = new Date2(jFormattedTextField2.getText() + " " + this.jFormattedTextField3.getText());
            String cr = null;
            String NomPerso = this.jLabel1.getText();
            if (!this.jTextArea1.getText().isEmpty()) {
                cr = this.jTextArea1.getText();
            }
            String iddbExamen = "";
            String iddbPersonnel = "";
            String idPatient = "";
            random r = new random();
            String typeE = (String) this.jComboBox2.getSelectedItem();
            String NumArchivage = dateE.toStringDateHeure();

            try {
                listeIdExamen = co.requete("iddbexamen", "examen", "");

            } catch (SQLException ex) {
                Logger.getLogger(PH.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {//prend id ccorrespondant au patient dans la bd
                idPatient = co.requete("idpatient", "patient", "where nom= '" + nom + "'").get(0).get(0);
            } catch (SQLException ex) {
                Logger.getLogger(PH.class.getName()).log(Level.SEVERE, null, ex);
            }

            iddbExamen = r.genererId(9);  //generer un id pour la database
            while (listeIdExamen.get(0).contains(iddbExamen)) {  //sert à eviter les doublons d'id dans la base de donnée.
                iddbExamen = r.genererId(9);
            }
            // System.out.println("iddbExamen :" + iddbExamen);

            try {
                iddbPersonnel = co.requete("iddbpersonnel", "personnel", "where nom=" + "'" + NomPerso + "'").get(0).get(0);
            } catch (SQLException ex) {
                Logger.getLogger(PH.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(NumArchivage);
            int i = co.insert("examen", "iddbexamen,iddbmedecin,dateexam,typeexam,numeroarchivage,idpatient,compterendu", "'" + iddbExamen + "'" + "," + "'" + iddbPersonnel + "'" + "," + "'" + dateE.toStringDateNaissDB() + "'" + "," + "'" + typeE + "'" + "," + "'" + NumArchivage + "'" + "," + "'" + idPatient + "'" + "," + "'" + cr +"\n fait le :"+this.jFormattedTextField2.getText()+" à :"+this.jFormattedTextField3.getText()+ "'");

            try {
                co.deconnexion();
            } catch (Exception ex) {
                Logger.getLogger(PH.class.getName()).log(Level.SEVERE, null, ex);
            }

            ConnexionPACS con = new ConnexionPACS();//gestion de l'enregistrement des images
            try {
                con.connexion();
            } catch (Exception ex) {
                Logger.getLogger(PH.class.getName()).log(Level.SEVERE, null, ex);
            }
            ArrayList<ArrayList<String>> listeIdImg = new ArrayList<>();

            try {
                listeIdImg = con.requetePACS("id", "PACS", "");

            } catch (SQLException ex) {
                Logger.getLogger(PH.class.getName()).log(Level.SEVERE, null, ex);
            }

            String numArchivage = this.jFormattedTextField2.getText() + " " + this.jFormattedTextField3.getText();
            for (int j = 0; j < this.jList2.getModel().getSize(); j++) {
                String idImg = r.genererId(9);  //generer un id pour la database
                while (listeIdImg.get(0).contains(idImg)) {  //sert à eviter les doublons d'id dans la base de donnée.
                    idImg = r.genererId(9);
                }
                con.saveImage(this.dataUrlImg.elementAt(j), idImg, numArchivage);

            }
            JOptionPane.showMessageDialog(this, "Examen ajouté", "confirmation", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton12MouseClicked

    private void jFormattedTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextField1MouseClicked
        jFormattedTextField1.setText("");
    }//GEN-LAST:event_jFormattedTextField1MouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        if (this.jTabbedPane1.getSelectedIndex() == 2) {
            FonctionnaliteBD f;
            try {
                f = new FonctionnaliteBD();
                this.listeExamen = f.ListeExamenBD();
                this.listePatient = f.ListePatientBD(listeExamen);
                this.listeImage = f.ListeImageBD(listeExamen);
            } catch (Exception ex) {
                Logger.getLogger(PH.class.getName()).log(Level.SEVERE, null, ex);
            }
            jTree1.setModel(this.buildTree());

        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        ListModel l = this.jList1.getModel();
        DefaultListModel model = new DefaultListModel();

        ArrayList<String> listepourrecherche = new ArrayList<>();
        for (int i = 0; i < modelFromBD.getSize(); i++) {
            listepourrecherche.add((String) modelFromBD.getElementAt(i));
        }

        Fonctionnalite f = new Fonctionnalite();
        ArrayList<String> listeElementTrouve = f.recherche(this.jTextField1.getText(), listepourrecherche);
        for (int i = 0; i < listeElementTrouve.size(); i++) {
            model.addElement(listeElementTrouve.get(i));
        }
        jList1.setModel(model);
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        if (this.jComboBox1.getSelectedIndex() == 3) {
            DefaultListModel model = new DefaultListModel();
            ArrayList<String> listeTrie = new ArrayList<>();
            Fonctionnalite f = new Fonctionnalite();
            ListModel l = this.jList1.getModel();
            ArrayList<String> listePourTri = new ArrayList<>();
            for (int i = 0; i < l.getSize(); i++) {
                listePourTri.add((String) l.getElementAt(i));
            }
            listeTrie = f.tri(listePourTri);
            for (int j = 0; j < listeTrie.size(); j++) {
                model.addElement(listeTrie.get(j));
            }
            this.jList1.setModel(model);
        }

        if (this.jComboBox1.getSelectedIndex() == 1) {
            DefaultListModel model = new DefaultListModel();
            ArrayList<String> listeTrie = new ArrayList<>();
            Fonctionnalite f = new Fonctionnalite();
            ListModel l = this.jList1.getModel();
            ArrayList<String> listePourTri = new ArrayList<>();
            ArrayList<String> listeInitial = new ArrayList<>();

            for (int i = 0; i < l.getSize(); i++) {
                listePourTri.add(((String) l.getElementAt(i)).split("   ")[1]);
                listeInitial.add((String) l.getElementAt(i));
            }

            listeTrie = f.tri(listePourTri);
            for (int j = 0; j < listeTrie.size(); j++) {
                for (int k = 0; k < listeInitial.size(); k++) {
                    if (listeInitial.get(k).split("   ")[1].contains(listeTrie.get(j))) {
                        model.addElement(listeInitial.get(k));
                    }

                }

            }
            this.jList1.setModel(model);
        }
        if (this.jComboBox1.getSelectedIndex() == 2) {
            ArrayList<String> listeTrie = new ArrayList<>();
            DefaultListModel model = new DefaultListModel();
            Fonctionnalite f = new Fonctionnalite();
            ListModel l = this.jList1.getModel();
            ArrayList<String> listePourTri = new ArrayList<>();
            ArrayList<String> listeInitial = new ArrayList<>();
            for (int i = 0; i < l.getSize(); i++) {
                listePourTri.add(((String) l.getElementAt(i)).split("   ")[2]);
                listeInitial.add((String) l.getElementAt(i));
            }
            listeTrie = f.tri(listePourTri);
            for (int j = 0; j < listeTrie.size(); j++) {
                for (int k = 0; k < listeInitial.size(); k++) {
                    if (listeInitial.get(k).split("   ")[2].contains(listeTrie.get(j))) {
                        model.addElement(listeInitial.get(k));
                    }

                }

            }
            this.jList1.setModel(model);
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseClicked

        if (jTree1.getSelectionCount() > 0) {
            if (jTree1.getSelectionModel().getSelectionPath().getPathCount() == 6) {

                String s = jTree1.getSelectionPath().getLastPathComponent().toString();
                ModifImg modif = new ModifImg(s);
                modif.setVisible(true);
            }
        }
    }//GEN-LAST:event_jButton13MouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if (this.jList1.getSelectedIndex() != -1) {
            idPatient = jList1.getSelectedValue().toString().split(" ")[0];
            try {
                ConsulterDMRPH consultDMR = new ConsulterDMRPH(idPatient, this.jLabel2.getText(), this.jLabel1.getText());
                consultDMR.setVisible(true);
                //BD
            } catch (Exception ex) {
                Logger.getLogger(PH.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez selectionner un patient", "Erreur", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        Imprimer imp = new Imprimer(this.jTextArea2);
        imp.print();
    }//GEN-LAST:event_jButton5MouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseClicked
        JFileChooser fileOuvrir2 = new JFileChooser();
        if (fileOuvrir2.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            this.dataUrlImg.add(new File(fileOuvrir2.getSelectedFile().getAbsolutePath()).getPath());
            dataNomImg.add(new File(fileOuvrir2.getSelectedFile().getAbsolutePath()).getName());
            this.jList3.setListData(dataNomImg);
        }
    }//GEN-LAST:event_jButton17MouseClicked

    private void jButton18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseClicked
        if (jList3.getLastVisibleIndex() != -1) {
            if (!"selectionnez une image...".equals(jList3.getModel().getElementAt(0))) {
                new VisualisationImg(dataUrlImg.elementAt(jList3.getSelectedIndex())).setVisible(true);
            }
        }
    }//GEN-LAST:event_jButton18MouseClicked

    private void jButton19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19MouseClicked
        if (jList3.getSelectedIndex() != -1) {
            int elemASup = this.jList3.getSelectedIndex();
            dataUrlImg.remove(elemASup);
            dataNomImg.remove(elemASup);
            jList3.setListData(dataNomImg);
        }
    }//GEN-LAST:event_jButton19MouseClicked

    private void jButton20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton20MouseClicked
        Vector<String> dataIni = new Vector();
        dataUrlImg.clear();
        dataNomImg.clear();
        jList3.setListData(dataIni);
    }//GEN-LAST:event_jButton20MouseClicked

    private void jButton21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton21MouseClicked
        ConnexionPACS con = new ConnexionPACS();//gestion de l'enregistrement des images
        random r2 = new random();
        String iddbImage = "";
        try {
            con.connexion();
        } catch (Exception ex) {
            Logger.getLogger(PH.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<ArrayList<String>> listeIdImg = new ArrayList<>();

        try {
            listeIdImg = con.requetePACS("id", "PACS", "");

        } catch (SQLException ex) {
            Logger.getLogger(PH.class.getName()).log(Level.SEVERE, null, ex);
        }

        String DebutnumArchivage = jList4.getSelectedValue().toString().split(" ")[1];
        String FinnumArchivage = jList4.getSelectedValue().toString().split(" ")[2];
        String numArchivageFinal = DebutnumArchivage + " " + FinnumArchivage;

        for (int j = 0; j < this.jList3.getModel().getSize(); j++) {
            String idImg = r2.genererId(9);  //generer un id pour la database pour pouvoir rentrer dans le while
            while (listeIdImg.get(0).contains(idImg)) {  //sert à eviter les doublons d'id dans la base de donnée.
                idImg = r2.genererId(9);
            }
            con.saveImage(this.dataUrlImg.elementAt(j), idImg, numArchivageFinal);

        }
    }//GEN-LAST:event_jButton21MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        ListModel ml = this.jList4.getModel();
        DefaultListModel model = new DefaultListModel();

        ArrayList<String> listepourrecherche = new ArrayList<>();
        for (int i = 0; i < modelFromBD.getSize(); i++) {
            listepourrecherche.add((String) modelFromBD.getElementAt(i));
        }

        Fonctionnalite f = new Fonctionnalite();
        ArrayList<String> listeElementTrouve = f.recherche(this.jTextField4.getText(), listepourrecherche);
        for (int i = 0; i < listeElementTrouve.size(); i++) {
            model.addElement(listeElementTrouve.get(i));
        }
        jList4.setModel(model);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        jTextField4.setText("");
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTree1MouseClicked

    private void jTree1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTree1MouseEntered

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
            java.util.logging.Logger.getLogger(PH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PH().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(PH.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList jList3;
    private javax.swing.JList<String> jList4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
