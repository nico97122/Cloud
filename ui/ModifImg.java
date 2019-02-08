/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 *
 * @author nicol
 */
public class ModifImg extends javax.swing.JFrame {
 private PanelIm PanelImg= new PanelIm();
 private JPanel jPanelBouton=new JPanel();
 private JPanel jPanelWest=new JPanel();
 private JPanel jPanelNorth=new JPanel();
 private JPanel jPanelSouth=new JPanel();
 private JButton b1=new JButton("rotationD90");
  private JButton b2=new JButton("rotationG90");
  private JButton b3=new JButton("retournerImg");
  private JButton b4=new JButton("reinitialiserImg");
   private JButton b5=new JButton("inverserNivGris");
  private BufferedImage Imginitial;
  private BufferedImage Imginitiallumi;
  private  JSlider lumi=new JSlider();
  int incre=0; //incrementation pour la classe éclairerAssombrirImg
    /**
     * Creates new form ModifImg
     */
    public ModifImg() {
        PanelImg.setSize(256, 256);
        setLayout(new BorderLayout());//modif de la presentation du panel img dans la fenetre
        add(PanelImg, BorderLayout.CENTER);
        add(jPanelWest, BorderLayout.WEST);
        add(jPanelNorth, BorderLayout.NORTH);
        add(jPanelSouth, BorderLayout.SOUTH);
        
        
        this.jPanelBouton.setLayout(new BoxLayout(jPanelBouton,BoxLayout.Y_AXIS));//ajout bouton au jpanel des boutons
            b2.setAlignmentX(Component.CENTER_ALIGNMENT);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        b3.setAlignmentX(Component.CENTER_ALIGNMENT);
        b4.setAlignmentX(Component.CENTER_ALIGNMENT);
        b5.setAlignmentX(Component.CENTER_ALIGNMENT);
        lumi.setAlignmentX(Component.CENTER_ALIGNMENT);
      this.jPanelBouton.add(lumi);
       this.jPanelBouton.add(b1);
       this.jPanelBouton.add(b2);
       this.jPanelBouton.add(b3);
       this.jPanelBouton.add(b4);
        this.jPanelBouton.add(b5);
        add(jPanelBouton, BorderLayout.EAST);
         lumi.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                lumiStateChanged(evt);
            }
        });
                                        
        b1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               b1MouseClicked(evt);
               
               
            }
            });
         b2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               b2MouseClicked(evt);
               
               
            }
            });
          b3.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               b3MouseClicked(evt);
               
               
            }
            });
           b4.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               b4MouseClicked(evt);
               
               
            }
            });
              b5.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               b5MouseClicked(evt);
               
               
            }
            });
          
        initComponents();
    }
       private void b3MouseClicked(java.awt.event.MouseEvent evt) {  
     BufferedImage img=PanelImg.getImage();
    BufferedImage imgr= PanelImg.retourner(img);
    this.incre=0;
    PanelImg.setImage(imgr);
}
       private void b5MouseClicked(java.awt.event.MouseEvent evt) {  
     BufferedImage img=PanelImg.getImage();
    BufferedImage imgG= PanelImg.inversionGris(img);
    PanelImg.setImage(imgG);
    this.incre=0;
}
          private void b4MouseClicked(java.awt.event.MouseEvent evt) {  
     this.incre=0;
    PanelImg.setImage(this.Imginitial);
}
    private void b2MouseClicked(java.awt.event.MouseEvent evt) {  
     BufferedImage img=PanelImg.getImage();
    BufferedImage imgr= PanelImg.rotation90G(img);
    PanelImg.setImage(imgr);
    this.incre=0;
} 
private void b1MouseClicked(java.awt.event.MouseEvent evt) {  
     BufferedImage img=PanelImg.getImage();
    BufferedImage imgr= PanelImg.rotation90D(img);
    PanelImg.setImage(imgr);
    this.incre=0;
} 
    private void lumiStateChanged(javax.swing.event.ChangeEvent evt) {                                      
        if (incre==0){
            this.incre=0;
            Imginitiallumi=PanelImg.getImage();
        }
        incre+=1;
        int tauxLumi=lumi.getValue();
        BufferedImage imglumi=PanelImg.eclairerAssombrir(Imginitiallumi, ((float)tauxLumi)/20);
         PanelImg.setImage(imglumi);
        
    }  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
     PanelImg.setSize(50, 50);
     setSize(800,600);
        try {
         // TODO add your handling code here:
         this.PanelImg.setImage("src/Cloud/image/img.jpg");
         this.Imginitial=PanelImg.getImage();
     } catch (IOException ex) {
         Logger.getLogger(ModifImg.class.getName()).log(Level.SEVERE, null, ex);
     }
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
                new ModifImg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
