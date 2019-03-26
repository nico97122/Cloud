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
     /**
      *  constructeur utilisé pour ensuite utilisé la fonction recherche et tri
      */
   public Fonctionnalite(){
       
   }
   public ArrayList<String> recherche(String recherche,ArrayList<String> liste){
        ArrayList<String> listeElement = new ArrayList<>();
         ArrayList<String> listeLowerCase = liste;
         
       for (int i=0;i<liste.size();i++){
           if (listeLowerCase.get(i).toLowerCase().contains(recherche.toLowerCase())){
               listeElement.add(liste.get(i));
               
           }
          
           

       }

       
       return listeElement;
   }
   /**
    * 
    * @param liste , la liste a trier
    * @return la liste trie
    */
   public ArrayList<String> tri(ArrayList<String> liste){
      liste.sort(new ComparatorImpl());
        return liste;
    }
/**
 * classe qui definie la facon de comparer deux string
 */
    private static class ComparatorImpl implements Comparator<String> {

        
        public ComparatorImpl() {
        }

        @Override
        public int compare(String o1, String o2) {
            return  o1.compareToIgnoreCase(o2);
        }
    }
     public ArrayList<Date2> triDate(ArrayList<Date2> liste){
       liste.sort(new ComparatorImpl2());
        return liste;
    }

    private static class ComparatorImpl2 implements Comparator<Date2> {

        public ComparatorImpl2() {
        }

        @Override
        public int compare(Date2 o1, Date2 o2) {
            return  o1.comparerDateint(o1, o2);
        }
    }
    
}
