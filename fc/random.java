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

   public random(){
       
   }
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
