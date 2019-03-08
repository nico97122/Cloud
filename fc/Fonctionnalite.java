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
           if (liste.get(i).toLowerCase().contains(recherche.toLowerCase())){
               listeElement.add(liste.get(i));
               
           }
           

       }
                  for (int j=0;j<listeElement.size();j++){
               String replace = listeElement.get(j).replace(listeElement.get(j).charAt(0), listeElement.get(j).toUpperCase().charAt(0));
               listeElement.set(j, replace);
               System.out.println(listeElement.get(j).replace(listeElement.get(j).charAt(0), listeElement.get(j).toUpperCase().charAt(0)));
           }
       System.out.println(listeElement.toString());
       return listeElement;
   }
    public ArrayList<String> tri(ArrayList<String> liste){
        liste.sort(new ComparatorImpl());
        return liste;
    }

    private static class ComparatorImpl implements Comparator<String> {

        public ComparatorImpl() {
        }

        @Override
        public int compare(String o1, String o2) {
            return  o1.compareTo(o2);
        }
    }
}
