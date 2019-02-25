/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.fc;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author nicol
 */
public class TraitementImg {
    private BufferedImage img;
    
    
    public BufferedImage getImg(){
        return img;
    }
    public TraitementImg(String pathFile){//constructeur si on a le chemin de l'img
        this.img=this.lireImg(pathFile);
} 
     public TraitementImg(BufferedImage img){//constructeur si on a deja une img
         this.img=img;
     }
// on lit l'image 
  public BufferedImage lireImg(String pathFile){ //penser a mettre en param pathFile=chemin du fichier
        try {//on fait des try and catch car l'addrsse de l'img peu changer et générer des bugs
            img=ImageIO.read(new File(pathFile));
        } catch (IOException ex) {
            System.out.println(ex);
            
        }
        return img;
  }
 
  public int[] getHauteurLargeur(BufferedImage img){
      int[] tab=new int[2];
      tab[0]=img.getHeight();
      tab[1]=img.getWidth();
      
      return tab;
  }
  public void sauvegarderImg(BufferedImage img,String filePath){//filePath est le chemin ou on enregistre l'img. pensez à faire new File("chemin\\nomNouvelleImg ex: new File("src\\Cloud\\image\\img.jpg")
      try {
            ImageIO.write(img,"jpg",new File(filePath));
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
  }

 
  
    
    
}
