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
    public static void main(String[] args) throws Exception {
        // TODO codeint  application logic here

        ArrayList<String> l = new ArrayList<>();
        l.add("ni");
        l.add("pi");
        l.add("zri");
        l.add("zi");
        l.add("ai");
        System.out.println(l.toString());
        Fonctionnalite f = new Fonctionnalite();
        System.out.println(f.tri(l).toString());
        System.out.println(f.recherche("z", l));

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

}
