/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.fc;

import java.util.Random;

/**
 *
 * @author nicol
 */
public class random {
/**
 * constructeur qui permet d'utiliser la methode generer id
 */
   public random(){
       
   }
   /**
    * 
    * @param nbChiffre nombre de chiffre du nombre aleatoire generer
    * @return  un nombre aleatoire de nbChiffre chiffre
    */
   public String genererId(int nbChiffre){
        String idPatient="";
        for (int i = 0; i < nbChiffre; i++) {
            Random obj = new Random();
            int nbr = obj.nextInt(10);
                    
            idPatient+=nbr;
        }
        return idPatient;
       
    
}
}
