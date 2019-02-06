/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.cloud_imagin;


import Cloud.fc.Date2;
import Cloud.fc.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import Cloud.ui.*;

/**
 *
 * @author nicol
 */
public class Cloud_Imagin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO codeint  application logic here
       
        
        Date2 d=new Date2(2007,10,25,13,51);
        Date2 d2=new Date2(2006,10,25,13,51);
        System.out.println(d.comparerDate(d2, d).toString());
        
        ImageLoader2 il=new ImageLoader2();
        BufferedImage img=il.loadImg("src\\Cloud\\image\\img.jpg");
        il.sauvegarderImg(img, "src\\Cloud\\image\\imagee.jpg");
      //  TraitementImg tr= new TraitementImg(new File("src\\Cloud\\image\\cor494-i43.jpg"));
     //  BufferedImage img=tr.getImg();
   //   int[]tab= tr.getHauteurLargeur(img);
    //  tr.sauvegarderImg(img,new File("src\\Cloud\\image\\img.jpg"));
        
      //  System.out.println(tab[1]);
    }
    
}
