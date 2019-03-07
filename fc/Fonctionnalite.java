/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.fc;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author nicol
 */
public class Fonctionnalite {
    
   public Fonctionnalite(){
       
   }
   public ArrayList<String> recherche(String recherche,ArrayList<String> liste){
        ArrayList<String> listeElement = new ArrayList<>();
       for (int i=0;i<liste.size();i++){
           if (liste.get(i).contains(recherche)){
               listeElement.add(liste.get(i));
           }
       }
       return listeElement;
   }
    public ArrayList<String> tri(ArrayList<String> liste){
        liste.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                  return  o1.compareTo(o2);
            }
        });
        return liste;
    }
}
