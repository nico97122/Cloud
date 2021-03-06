/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.fc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author nicol
 * defini la classe 
 */
public class Image {

    private BufferedImage img;
    private String id;
    private String NumArchivage;
    private String path;
    public Image(BufferedImage img, String id, String NumArchivage,String path) {
        this.id=id;
        this.img=img;
        this.NumArchivage=NumArchivage;
        this.path=path;
    }
    
    public Image(String pathIm, String id, String NumArchivage) {
        this.id=id;
        try {
            
            this.img=ImageIO.read(new File(pathIm));
        } catch (IOException ex) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.NumArchivage=NumArchivage;
        this.path=pathIm;
    }

    /**
     * @return the img
     */
    public BufferedImage getImg() {
        return img;
    }
    public String getPath() {
        return path;
    }

    /**
     * @param img the img to set
     */
    public void setImg(BufferedImage img) {
        this.img = img;
    }
    /**
     * 
     * @param path de l'image a set 
     */
public void setImg(String path) {
        try {
            this.img = ImageIO.read(new File(path));
        } catch (IOException ex) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the Numero Archivage
     */
    public String getNumArchivage() {
        return NumArchivage;
    }

    /**
     * @param NumArchivage the Numerop Archivage to set
     */
    public void setNumArchivage(String NumArchivage) {
        this.NumArchivage = NumArchivage;
    }
}
