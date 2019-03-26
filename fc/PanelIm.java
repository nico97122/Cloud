/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.fc;

/**
 *
 * @author nicol
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
//import static java.lang.Integer.max;
//import static java.lang.Integer.min;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelIm extends JPanel {

    private BufferedImage image;
    private BufferedImage imgIni;

    /**
     * cree un nouveau panel Image
     */
    public PanelIm() {

        super();

    }
/**
 * 
 * @param image image a afficher
 */
    public PanelIm(BufferedImage image) {
        super();

        setStartImage(image);
    }
/**
 * 
 * @param path le chemin du l'image a afficher
 * @throws IOException 
 */
    public PanelIm(String path) throws IOException {
        super();

        setStartImage(path);

    }
/**
 * 
 * @param path de l'image de depart
 * @throws IOException 
 */
    public void setStartImage(String path) throws IOException {//set img avec path
        try {
            this.imgIni = ImageIO.read(new File(path));
            this.image = ImageIO.read(new File(path));
            repaint();
        } catch (IOException e) {
            throw new IOException(path + " introuvable", e);
        }
    }
/**
 * 
 * @param image, image a afficher au debut 
 */
    public void setStartImage(BufferedImage image) { //set img avec img
        this.image = image;
        this.imgIni = image;
        repaint();
    }
/**
 * 
 * @param image , image a afficher
 */
    public void setImage(BufferedImage image) { //set img avec img
        this.image = image;
        setStartImage(image);

        repaint();
    }


    
    public void setImgIni(String path) throws IOException {

        try {
            this.image = ImageIO.read(new File(path));
            repaint();
        } catch (IOException e) {
            throw new IOException(path + " introuvable", e);
        }
    }


              public void setImgIni(BufferedImage img) {
        imgIni = img;
    }

    public void setImage(String path) throws IOException {//set img avec path
        try {
            this.image = ImageIO.read(new File(path));
            repaint();
        } catch (IOException e) {
            throw new IOException(path + " introuvable", e);
        }
    }
/**
 * 
 * @return l'image afficher 
 */
    public BufferedImage getImage() {
        return image;
    }

    public BufferedImage getImageInitial() {
        return imgIni;
    }

    @Override
    public void paintComponent(Graphics g) {
        if (image != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        }
    }
/**
 * 
 * @param img l'image a tourner
 * @return l'imge tourner de 90 degres sur la droite
 */
    public BufferedImage rotation90D(BufferedImage img) {
        int pix;
        int ligne = img.getWidth();
        int colonne = img.getHeight();
        BufferedImage imgr = new BufferedImage(colonne,ligne, BufferedImage.TYPE_BYTE_GRAY);
       
        for (int i = 0; i < colonne; i++) {
            for (int j = 0; j < ligne; j++) {
                pix = img.getRGB(ligne-j-1, i);
              
                imgr.setRGB(i , j, pix);

            }

        }
        return imgr;
    }
/**
 * 
 * @param img l'image a tourner
 * @return l'imge tourner de 90 degres sur la gauche
 */
    public BufferedImage rotation90G(BufferedImage img) {
        int pix;
        int ligne = img.getWidth();
        int colonne = img.getHeight();
        BufferedImage imgr = new BufferedImage(colonne,ligne, BufferedImage.TYPE_BYTE_GRAY);

        for (int i = 0; i < colonne; i++) {
            for (int j = 0; j < ligne; j++) {
                pix = img.getRGB(j, colonne - 1 - i);
                imgr.setRGB(i, j, pix);

            }

        }
        return imgr;
    }
/**
 * 
 * @param img l'image a retourner
 * @return l'image retourner
 */
    public BufferedImage retourner(BufferedImage img) {
        int pix;
        int ligne = img.getWidth();
        int colonne = img.getHeight();
        BufferedImage imgr = new BufferedImage(ligne, colonne, BufferedImage.TYPE_BYTE_GRAY);
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
                pix = img.getRGB(i, j);
                imgr.setRGB(ligne - i - 1, j, pix);

            }

        }
        return imgr;
    }
/**
 * 
 * @param img l'image dont il faut modifier les niveaux de gris
 * @return l'image avec les niveaux de gris inverses
 */
    public BufferedImage inversionGris(BufferedImage img) {
        Color pix;
        int ligne = img.getWidth();
        int colonne = img.getHeight();
        BufferedImage imginv = new BufferedImage(ligne, colonne, BufferedImage.TYPE_BYTE_GRAY);
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
                pix = new Color(img.getRGB(i, j));
                int r = pix.getRed();
                int g = pix.getGreen();
                int b = pix.getBlue();
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;
                Color pix2 = new Color(r, g, b);
                int pixInt = pix2.getRGB();
                imginv.setRGB(i, j, pixInt);
            }

        }
        return imginv;
    }
/**
 * @param m l'amplitude du contraste a modifié
 * @param img l'image a contraster
 * @return l'image avec le contraste augmenter de m
 */
    public BufferedImage contraste(BufferedImage img, float m) {
        int ligne = img.getWidth();
        Color pix;
        int colonne = img.getHeight();
        BufferedImage imgDest = new BufferedImage(ligne, colonne, BufferedImage.TYPE_BYTE_GRAY);
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
                pix = new Color(img.getRGB(i, j));
                int r = pix.getRed();
                int g = pix.getGreen();
                int b = pix.getBlue();
                if (r > 127) {
                    r += m;
                    if (r > 255) { //on regarde si le pixel modifié ne depasse pas la limite autorisé (255)
                        r = 255;
                    }

                } else {//on regarde si le pixel modifié ne depasse pas la limite autorisé (0)
                    r = (int) (r - m);
                    if (r < 0) {
                        r = 0;

                    }

                }
              Color  pix2=new Color(r,r,r);
                int pixInt = pix2.getRGB();
               imgDest.setRGB(i, j, pixInt);
                

            }
        }
        return imgDest;
    }
/**
 * 
 * @param img image a eclairer ou assombrir
 * @param m l'amplitude de l'eclaississment
 * @return  l'image eclairer ou assombri
 */
    public BufferedImage eclairerAssombrir(BufferedImage img, float m) {
        int ligne = img.getWidth();
        int colonne = img.getHeight();

        BufferedImage imgDest = new BufferedImage(ligne, colonne, BufferedImage.TYPE_BYTE_GRAY);
        RescaleOp imgeclair = new RescaleOp(1, (float) (m * 2.56  - 128), null);
        imgeclair.filter(img, imgDest);
        return imgDest;
    }
/**
 * 
 * @param img l'image a sauvegarder
 * @param filePath  est le chemin ou on enregistre l'img. pensez à faire new File("chemin\\nomNouvelleImg ex: new File("src\\Cloud\\image\\img.jpg")
 */
    public void sauvegarderImg(BufferedImage img, String filePath) {
        try {
            ImageIO.write(img, "jpg", new File(filePath));
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }
/**
 * 
 * @param panneauImage l'image a modifier
 * @param racineFichier la racine du fichier
 * @param nomFichier le nom du fichier  a enregistrer
 * @throws IOException 
 */
    public void sauverJPanelDansFile(JPanel panneauImage, String racineFichier, String nomFichier)
            throws IOException {
        BufferedImage tamponSauvegarde = new BufferedImage(
                panneauImage.getPreferredSize().width,
                panneauImage.getPreferredSize().height,
                BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = tamponSauvegarde.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, panneauImage.getPreferredSize().width,
                panneauImage.getPreferredSize().height);
        panneauImage.paint(g);
        ImageIO.write(tamponSauvegarde, "JPG", new File(racineFichier + nomFichier));
    }
    
    /**
     * 
     * @param image a annoter
     * @param x ordonnee horizontal du lieu ou il faut annoter
     * @param y ordonnee verticaal du lieu ou il faut annoter
     * @param text texte a ecrire sur l'image
     * @return  l'image annotee
     */
    public BufferedImage annoterImg(BufferedImage image,int x, int y,  String text) {
        int ligne = image.getWidth();
        int colonne = image.getHeight();
        Color pix;

        BufferedImage imgDest =new BufferedImage(ligne, colonne, BufferedImage.TYPE_BYTE_GRAY);
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
        pix = new Color(image.getRGB(i, j));
                int r = pix.getRed();
                int g = pix.getGreen();
                int b = pix.getBlue();
                Color pix2 = new Color(r, g, b);
                int pixInt = pix2.getRGB();
                imgDest.setRGB(i, j, pixInt);
            }

        }
        Graphics2D gO = imgDest.createGraphics();

       
        gO.setColor(Color.WHITE);
        
        
        gO.setFont(new Font("SansSerif", Font.BOLD, 12));
        gO.drawString(text, 20, 20);
      
        
        return imgDest;

    }
    /**
     * 
     * @param image sur laquelle il faut dessiner un cercle
     * @param x ordonnee horizontal du lieu ou il faut dessiner un cercle
     * @param y ordonnee vertical du lieu ou il faut dessiner un cercle
     * @param rayon du cercle dessiner
     * @return l'image avec le cercle dessine
     */
    public BufferedImage dessinerCercle(BufferedImage image,int x, int y,int rayon) {
        int ligne = image.getWidth();
        int colonne = image.getHeight();
        Color pix;

        BufferedImage imgDest =new BufferedImage(ligne, colonne, BufferedImage.TYPE_BYTE_GRAY);
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
        pix = new Color(image.getRGB(i, j));
                int r = pix.getRed();
                int g = pix.getGreen();
                int b = pix.getBlue();
                Color pix2 = new Color(r, g, b);
                int pixInt = pix2.getRGB();
                imgDest.setRGB(i, j, pixInt);
            }

        }
        Graphics2D gO = imgDest.createGraphics();

       
        gO.setColor(Color.WHITE);
        
        
        gO.setFont(new Font("SansSerif", Font.BOLD, 12));
        gO.drawOval(x-rayon/2, y-rayon/2, rayon, rayon);
      
       
        return imgDest;

    }

}
