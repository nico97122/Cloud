/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.ui;

import Cloud.fc.PanelIm;
import Cloud.fc.ConnexionPACS;
import Cloud.fc.FonctionnaliteBD;
import Cloud.fc.Image;
import Cloud.fc.Imprimer;
import Cloud.fc.random;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author nicol
 */
public class ModifImg extends javax.swing.JFrame {
    private BufferedImage img;
    private Image image;
    private PanelIm PanelImg = new PanelIm();
    private JPanel jPanelBouton = new JPanel();
    private JPanel jPanelWest = new JPanel();
    private JPanel jPanelNorth = new JPanel();
    private JPanel jPanelSouth = new JPanel();
    private JButton b1 = new JButton("  rotationD90  ");
    private JButton b2 = new JButton("  rotationG90  ");
    private JButton b3 = new JButton(" retournerImg ");
    private JButton b4 = new JButton("reinitialiserImg");
    private JButton b5 = new JButton("inverserNivGris");
    private JButton b6 = new JButton("     annoter     ");
     private JToggleButton b7 = new JToggleButton("      pointeur      ");
     private JLabel taillePointeur=new JLabel("taille du pointeur");
    private JLabel nom = new JLabel("    luminosité    ");
    private JLabel contraste = new JLabel("     contraste     ");
    private BufferedImage Imginitial;
    private BufferedImage Imginitiallumi;
    private BufferedImage Imginitialcontraste;
    private String path;
    private BufferedImage ImgAnnoter;
    private BufferedImage ImgCercle;
    private JSlider lumi = new JSlider();
    private JSlider JSliderContraste = new JSlider();
    private JSlider JSliderCercle = new JSlider();
    private JPanel jPanelSE = new JPanel();
    private JButton save = new JButton("save");
    private JButton exit = new JButton("exit");
    private JButton imprimer = new JButton("    imprimer    ");
    private JTextArea note = new JTextArea("ajouter une note");
    int incre = 0; //incrementation pour la classe éclairerAssombrirImg
    int incre2 = 0; //incrementation pour la classe éclairerAssombrirImg

    /**
     * Creates new form ModifImg
     */
    public ModifImg() {
        this.path = "src/Cloud/imageBD/468706562.png";
        setResizable(false);
        setSize(1700, 500);
        PanelImg.setSize(256, 256);
        setLayout(new BorderLayout());//modif de la presentation du panel img dans la fenetre
        add(PanelImg, BorderLayout.CENTER);
     
      
        add(jPanelSouth, BorderLayout.SOUTH);

        this.jPanelBouton.setLayout(new FlowLayout());//ajout bouton au jpanel des boutons
        this.jPanelSE.setLayout(new FlowLayout());
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        b3.setAlignmentX(Component.CENTER_ALIGNMENT);
        b4.setAlignmentX(Component.CENTER_ALIGNMENT);
        b5.setAlignmentX(Component.CENTER_ALIGNMENT);
        b6.setAlignmentX(Component.CENTER_ALIGNMENT);
        nom.setAlignmentX(Component.CENTER_ALIGNMENT);
        lumi.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.contraste.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.JSliderContraste.setAlignmentX(Component.CENTER_ALIGNMENT);
        imprimer.setAlignmentX(Component.CENTER_ALIGNMENT);
        note.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanelSE.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        lumi.setPreferredSize(new Dimension(150, 20));
        note.setPreferredSize(new Dimension(200, 300));
        JSliderContraste.setPreferredSize(new Dimension(150, 20));
        
        note.setPreferredSize(new Dimension(200, 100));
        this.jPanelBouton.setPreferredSize((new Dimension(200, 500)));
        this.jPanelBouton.add(b1);
        this.jPanelBouton.add(b2);
        this.jPanelBouton.add(b3);
        this.jPanelBouton.add(b4);
        this.jPanelBouton.add(nom);
        this.jPanelBouton.add(lumi);
        this.jPanelBouton.add(b5);
        this.jPanelBouton.add(contraste);
        this.jPanelBouton.add(JSliderContraste);
        this.jPanelBouton.add(imprimer);
        this.jPanelBouton.add(b6);
        this.jPanelBouton.add(b7);
        this.jPanelBouton.add(note);

        this.jPanelSE.add(save);
        jPanelSE.add(exit);
        this.jPanelBouton.add(jPanelSE);
        add(jPanelBouton, BorderLayout.EAST);
        
         PanelImg.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelImgMouseClicked(evt);

            }
        });
            
        lumi.addChangeListener(new javax.swing.event.ChangeListener() {
           
            
            @Override 
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                lumiStateChanged(evt);
            }
        });
//ajout d'un listenner si on  bouge le Jslider lumi
        JSliderContraste.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                JSliderContrasteStateChanged(evt);
            }
        });//ajout d'un listenner si on  bouge le JSliderContraste
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });//ajout d'un listenner si on clique sur  le bouton exit
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    saveMouseClicked(evt);
                } catch (Exception ex) {
                    Logger.getLogger(ModifImg.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });  //ajout d'un listenner si on clique sur  le bouton rotation d90                            
        b1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b1MouseClicked(evt);

            }
        });//ajout d'un listenner si on clique sur  le bouton rotation90g
        
          imprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imprimerMouseClicked(evt);

            }
        });
        b2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b2MouseClicked(evt);

            }
        });//ajout d'un listenner si on clique sur  le bouton retournerimg   
        b3.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b3MouseClicked(evt);

            }
        });//ajout d'un listenner si on clique sur  le bouton reinitialiser
        b4.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b4MouseClicked(evt);

            }
        });//ajout d'un listenner si on clique sur  le bouton retourner
        b5.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b5MouseClicked(evt);

            }
        });//ajout d'un listenner si on clique sur  le bouton inverserGris
        b6.addMouseListener(new java.awt.event.MouseAdapter() {//ajout d'un listenner si on clique sur  le bouton b6(annoter)
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b6MouseClicked(evt);

            }
        });
        b7.addMouseListener(new java.awt.event.MouseAdapter() {//ajout d'un listenner si on clique sur  le bouton b7(pointeur)
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               

            }
        });
        
        note.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noteMouseClicked(evt);

            }
        });
        initComponents();
        PanelImg.setPreferredSize(new Dimension(200, 500));
        setSize(new Dimension(1000, 700));
        try {
            // TODO add your handling code here:
            this.PanelImg.setImage(this.path);  //setL'image a partir de l'url extraite de la bd ou de la fenetre précédente
            this.Imginitial = PanelImg.getImage();
            this.ImgAnnoter = PanelImg.getImage();
             this.ImgCercle = PanelImg.getImage();
        } catch (IOException ex) {
            Logger.getLogger(ModifImg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ModifImg(String pathFile) {
        this.path = pathFile;
        setResizable(false);
      
        setSize(1700, 500);
        PanelImg.setSize(256, 256);
        setLayout(new BorderLayout());//modif de la presentation du panel img dans la fenetre
        add(PanelImg, BorderLayout.CENTER);
        add(jPanelWest, BorderLayout.WEST);
        add(jPanelNorth, BorderLayout.NORTH);
        add(jPanelSouth, BorderLayout.SOUTH);

        this.jPanelBouton.setLayout(new FlowLayout());//ajout bouton au jpanel des boutons
        this.jPanelSE.setLayout(new FlowLayout());
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        b3.setAlignmentX(Component.CENTER_ALIGNMENT);
        b4.setAlignmentX(Component.CENTER_ALIGNMENT);
        b5.setAlignmentX(Component.CENTER_ALIGNMENT);
        b6.setAlignmentX(Component.CENTER_ALIGNMENT);
        b7.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.JSliderCercle.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.taillePointeur.setAlignmentX(Component.CENTER_ALIGNMENT);
        nom.setAlignmentX(Component.CENTER_ALIGNMENT);
        lumi.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.contraste.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.JSliderContraste.setAlignmentX(Component.CENTER_ALIGNMENT);
        imprimer.setAlignmentX(Component.CENTER_ALIGNMENT);
        note.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanelSE.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        lumi.setPreferredSize(new Dimension(150, 20));
        note.setPreferredSize(new Dimension(200, 150));
        JSliderContraste.setPreferredSize(new Dimension(150, 20));
        JSliderCercle.setPreferredSize(new Dimension(150, 20));
        note.setPreferredSize(new Dimension(100, 100));
        this.jPanelBouton.setPreferredSize((new Dimension(200, 500)));
        this.jPanelBouton.add(b1);
        this.jPanelBouton.add(b2);
        this.jPanelBouton.add(b3);
        this.jPanelBouton.add(b4);
        this.jPanelBouton.add(nom);
        this.jPanelBouton.add(lumi);
        this.jPanelBouton.add(b5);
        this.jPanelBouton.add(contraste);
        this.jPanelBouton.add(JSliderContraste);
        this.jPanelBouton.add(imprimer);
        
        this.jPanelBouton.add(b7);
        this.jPanelBouton.add(taillePointeur);
          this.jPanelBouton.add(JSliderCercle);
          this.jPanelBouton.add(b6);
        this.jPanelBouton.add(note);

        this.jPanelSE.add(save);
        jPanelSE.add(exit);
        this.jPanelBouton.add(jPanelSE);
        add(jPanelBouton, BorderLayout.EAST);
        lumi.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                lumiStateChanged(evt);
            }
        });
           PanelImg.addMouseListener(new java.awt.event.MouseAdapter() {//listenner du panel image
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelImgMouseClicked(evt);

            }
        });
//ajout d'un listenner si on  bouge le Jslider lumi
        JSliderContraste.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                JSliderContrasteStateChanged(evt);
            }
        });//ajout d'un listenner si on  bouge le JSliderContraste
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });//ajout d'un listenner si on clique sur  le boutonsave
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    saveMouseClicked(evt);
                } catch (Exception ex) {
                    Logger.getLogger(ModifImg.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });  //ajout d'un listenner si on clique sur  le bouton rotation90D                             
        b1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b1MouseClicked(evt);

            }
        });//ajout d'un listenner si on clique sur  le bouton rotation90g
        b2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b2MouseClicked(evt);

            }
        });//ajout d'un listenner si on clique sur  le bouton retournerImg 
        b3.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b3MouseClicked(evt);

            }
        });//ajout d'un listenner si on clique sur  le bouton reinitialiser
        b4.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b4MouseClicked(evt);

            }
        });//ajout d'un listenner si on clique sur  le bouton annoter
        b5.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b5MouseClicked(evt);

            }
        });//ajout d'un listenner si on clique sur  le bouton inverserGris
      
//ajout d'un listenner si on clique sur  le field ajouter une note
        note.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noteMouseClicked(evt);

            }
        });
        initComponents();
        PanelImg.setPreferredSize(new Dimension(200, 500));
        setSize(new Dimension(1000, 700));
        try {
            // TODO add your handling code here:
            this.PanelImg.setImage(pathFile);  //setL'image a partir de l'url extraite de la bd ou de la fenetre précédente
            this.Imginitial = PanelImg.getImage();
            this.img=PanelImg.getImage();
             this.ImgAnnoter = PanelImg.getImage();
             this.ImgCercle = PanelImg.getImage();
            
        } catch (IOException ex) {
            Logger.getLogger(ModifImg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




    private void exitMouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
    }

    private void saveMouseClicked(java.awt.event.MouseEvent evt) throws Exception {
        FonctionnaliteBD f = new FonctionnaliteBD();
        ConnexionPACS co = new ConnexionPACS();
        co.connexion();
        f.connexion();
        ArrayList<Image> listeImg = f.ListeImageBD(f.ListeExamenBD());
        for (int i = 0; i < listeImg.size(); i++) {
              

            if (listeImg.get(i).getPath().equals(this.path)) {// ajoute l'image modifier
             
         
              
              String id= new random().genererId(9);
              while(listeImg.contains(id)){
                   id= new random().genererId(9);
              }
                PanelImg.sauvegarderImg(PanelImg.getImage(), "src/Cloud/imageBD/"+id+"modifié"+".png");
              co.saveImage("src/Cloud/imageBD/"+id+"modifié"+".png",id+"modifié" , listeImg.get(i).getNumArchivage());
              
                
                co.retrieveImageId(id+"modifié","src/Cloud/imageBD/" , "png");
                
            }
        }
        JOptionPane.showMessageDialog(this, "Image modifié", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        f.decoBD();
    }
    

    private void b3MouseClicked(java.awt.event.MouseEvent evt) {
        BufferedImage img = PanelImg.getImage();
        BufferedImage imgr = PanelImg.retourner(img);
        this.incre = 0;
        this.incre2 = 0;
        PanelImg.setImage(imgr);
        this.ImgAnnoter = PanelImg.getImage();
        this.ImgCercle=PanelImg.getImage();
    }

    private void b5MouseClicked(java.awt.event.MouseEvent evt) {
        BufferedImage img = PanelImg.getImage();
        BufferedImage imgG = PanelImg.inversionGris(img);
        PanelImg.setImage(imgG);
        this.ImgAnnoter = PanelImg.getImage();
        this.ImgCercle = PanelImg.getImage();
        this.incre = 0;
        this.incre2 = 0;
    }

    private void b6MouseClicked(java.awt.event.MouseEvent evt) {//annote l'image
        int i = 20;
        int j = 20;
        this.incre = 0;
        this.incre2 = 0;

        BufferedImage imag = this.ImgAnnoter;

        BufferedImage imageR = PanelImg.annoterImg(imag, i, j, note.getText());
         
        PanelImg.setImage(imageR);
        this.ImgCercle = PanelImg.getImage();
    }
     private void PanelImgMouseClicked(java.awt.event.MouseEvent evt) {    //ajoute un cercle
         
     if(this.b7.isSelected()){
           this.incre = 0;
        this.incre2 = 0;
        
        BufferedImage imag = this.ImgCercle;
        int col=(int) (evt.getX()/(14.2/4.55));
        int ligne=(int) (evt.getY()/(11.5/4.5));
        
        BufferedImage imageR = PanelImg.dessinerCercle(imag,col, ligne, (int) (this.JSliderCercle.getValue()/2.5));
        
       PanelImg.setImage(imageR);
       this.ImgAnnoter = PanelImg.getImage();
     }
 }
 

    private void b4MouseClicked(java.awt.event.MouseEvent evt) {
        this.incre = 0;
        this.incre2 = 0;
        PanelImg.setImage(this.Imginitial);
        this.ImgAnnoter = PanelImg.getImage();
        this.ImgCercle = PanelImg.getImage();
        this.JSliderContraste.setValue(0);
        this.lumi.setValue(50);
    }

    private void b2MouseClicked(java.awt.event.MouseEvent evt) {
        BufferedImage img = PanelImg.getImage();
        BufferedImage imgr = PanelImg.rotation90G(img);
        PanelImg.setImage(imgr);
        this.ImgAnnoter = PanelImg.getImage();
        this.ImgCercle = PanelImg.getImage();
        this.incre = 0;
        this.incre2 = 0;
    }

    private void b1MouseClicked(java.awt.event.MouseEvent evt) {
        BufferedImage img = PanelImg.getImage();
        BufferedImage imgr = PanelImg.rotation90D(img);
        PanelImg.setImage(imgr);
        this.ImgAnnoter = PanelImg.getImage();
        this.ImgCercle = PanelImg.getImage();
        this.incre = 0;
        this.incre2 = 0;
    }
     private void imprimerMouseClicked(java.awt.event.MouseEvent evt) {
        Imprimer imp=new Imprimer(this.PanelImg);
         imp.print();
    }

    private void JSliderContrasteStateChanged(javax.swing.event.ChangeEvent evt) {
        if (incre2 == 0) {
            this.incre2 = 0;
            Imginitialcontraste = PanelImg.getImage();
        }
        incre2 += 1;
        int tauxContraste = JSliderContraste.getValue();
        BufferedImage imgcontraste = PanelImg.contraste(Imginitialcontraste, ((float) tauxContraste));
        PanelImg.setImage(imgcontraste);
        this.ImgAnnoter = PanelImg.getImage();
        this.ImgCercle = PanelImg.getImage();
        this.incre = 0;
    }

    private void lumiStateChanged(javax.swing.event.ChangeEvent evt) {
        if (incre == 0) {
            this.incre = 0;
            Imginitiallumi = PanelImg.getImage();
        }
        incre += 1;
        int tauxLumi = lumi.getValue();
        BufferedImage imglumi = PanelImg.eclairerAssombrir(Imginitiallumi, ((float) tauxLumi));
        PanelImg.setImage(imglumi);
        this.ImgAnnoter = PanelImg.getImage();
        this.ImgCercle = PanelImg.getImage();
        this.incre2 = 0;

    }
    

    private void noteMouseClicked(java.awt.event.MouseEvent evt) {
        note.setText("");
        note.setPreferredSize(new Dimension(200, 100));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.JSliderContraste.setValue(0);
        this.lumi.setValue(50);
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(ModifImg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifImg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifImg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifImg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifImg("src/Cloud/imageBD/468706562.png").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
