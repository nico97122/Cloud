/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.fc;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 *
 * @author nicol
 */
public class LectureImg {
    private int largeur;
    private int longueur;
   private Image img ; // Quand on instancie img on fait img=ImageIO.read(new File("chemin de l'image"));
    public LectureImg(int largeur, int longueur,Image img){
        this.longueur=longueur;
        this.largeur=largeur;
    }
   
    public void afficherImage(){
        
    }
    public void lectureImage(){
        
    }
    public void transfoImg(){
        
    }
            
}
