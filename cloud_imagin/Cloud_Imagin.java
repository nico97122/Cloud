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
    public static void main(String[] args) throws Exception{
        // TODO codeint  application logic here

//        ArrayList<String> l = new ArrayList<>();
//        l.add("ni");
//        l.add("pi");
//        l.add("zri");
//        l.add("zi");
//        l.add("ai");
//        System.out.println(l.toString());
      FonctionnaliteBD f = new FonctionnaliteBD();
      
      
        System.out.println(f.ListeImageBD(f.ListeExamenBD()).toString());
        System.out.println(f.ListeImageBD(f.ListeExamenBD()).get(0).getId());
        System.out.println(f.ListeImageBD(f.ListeExamenBD()).get(0).getImg().getHeight());
//        System.out.println(f.ListePatientBD(f.ListeExamenBD()).get(1).getSexe()+f.ListePatientBD(f.ListeExamenBD()).get(1).getNom());
         String locR="src/Cloud/imageBD/ ";
        String locRes = "src/ResultImages/";
        String loc = "src/jpg.png";
        String loc2 = "src/pic.png";
        String loc3 = "src/testpgm.pgm";
        ConnexionPACS con = new ConnexionPACS();
        //con.saveImage(loc,1234,"15022019");
        //con.saveImage(loc2,2345,"15022019");

      //  con.retrieveImage("15022019", locR, "png");
    }
        
       // String loc="src/Cloud/image/img.jpg";
       
        String idImg="99999";
        ConnexionPACS con=new ConnexionPACS();
       // con.saveImage(loc, 11110, "99999");
        
        // con.retrieveImage("15022019", locR, "png");
   

//                ListePatientBD listeP = new ListePatientBD(listeE.getListeExamen());
//                System.out.println(listeE.getListeExamen().toString());
//             System.out.println( listeP.getListePatient().get(0).getNom()+ listeP.getListePatient().get(0).getListeExam().size());
//               
        //  TraitementImg tr= new TraitementImg(new File("src\\Cloud\\image\\cor494-i43.jpg"));
        //  BufferedImage img=tr.getImg();
        //   int[]tab= tr.getHauteurLargeur(img);
        //  tr.sauvegarderImg(img,new File("src\\Cloud\\image\\img.jpg"));
        //  System.out.println(tab[1]);
    }


