/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.ui;

/**
 *
 * @author nicol
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelIm extends JPanel {

    private BufferedImage image;
    private BufferedImage imgIni;

    /**
     * Creates new form PanelIm
     */
    public PanelIm() {

        super();

    }

    public PanelIm(BufferedImage image) {
        super();

        setStartImage(image);
    }

    public PanelIm(String path) throws IOException {
        super();

        setStartImage(path);

    }

    public void setStartImage(String path) throws IOException {//set img avec path
        try {
            this.imgIni = ImageIO.read(new File(path));
            this.image = ImageIO.read(new File(path));
            repaint();
        } catch (IOException e) {
            throw new IOException(path + " introuvable", e);
        }
    }

    public void setStartImage(BufferedImage image) { //set img avec img
        this.image = image;
        this.imgIni = image;
        repaint();
    }

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

    ;
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

    public BufferedImage rotation90D(BufferedImage img) {
        int pix;
        int ligne = img.getWidth();
        int colonne = img.getHeight();
        BufferedImage imgr = new BufferedImage(ligne, colonne, BufferedImage.TYPE_BYTE_GRAY);

        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
                pix = img.getRGB(i, j);
                imgr.setRGB(ligne - j - 1, i, pix);

            }

        }
        return imgr;
    }

    public BufferedImage rotation90G(BufferedImage img) {
        int pix;
        int ligne = img.getWidth();
        int colonne = img.getHeight();
        BufferedImage imgr = new BufferedImage(ligne, colonne, BufferedImage.TYPE_BYTE_GRAY);

        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
                pix = img.getRGB(i, j);
                imgr.setRGB(j, colonne - 1 - i, pix);

            }

        }
        return imgr;
    }

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

    public BufferedImage eclairerAssombrir(BufferedImage img, float m) {
        int ligne = img.getWidth();
        int colonne = img.getHeight();

        BufferedImage imgDest = new BufferedImage(ligne, colonne, BufferedImage.TYPE_BYTE_GRAY);
        RescaleOp imgeclair = new RescaleOp(m, 0, null);
        imgeclair.filter(img, imgDest);
        return imgDest;
    }


    public void sauvegarderImg(BufferedImage img, String filePath) {//filePath est le chemin ou on enregistre l'img. pensez à faire new File("chemin\\nomNouvelleImg ex: new File("src\\Cloud\\image\\img.jpg")
        try {
            ImageIO.write(img, "jpg", new File(filePath));
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

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

}
