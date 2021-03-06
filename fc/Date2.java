/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.fc;

/**
 *
 * @author nicol
 */
import java.util.Date;

public class Date2 {

    private int annee;
    private int mois;
    private int jour;
    private int heure;
    private int minute;
    
    /**
     * 
     * 
     * constructeur de la date sans l'heure
     * @param annee
     * @param mois
     * @param jour 
     */
    public Date2(int annee, int mois, int jour) {
        this.annee = annee;
        this.mois = mois;
        this.jour = jour;
        this.heure = 0;
        this.minute = 0;

    }
//
    /**
     * 
     * 
     * constructeur de la date a partir d'un string 
     * @param date 
     */
    public Date2(String date) {
        if (date.contains("-")) {//traitement pour les dates venant de la BD;
            String[] dateTab = date.split("-");

            if (dateTab[2].contains(":")) {
                String[] TabJourHeure = dateTab[2].split(" ");
                this.jour = Integer.parseInt(TabJourHeure[0]);
                String[] TabHeure = TabJourHeure[1].split(":");
                this.heure = Integer.parseInt(TabHeure[0]);
                this.minute = Integer.parseInt(TabHeure[1]);
                this.annee = Integer.parseInt(dateTab[0]);
                this.mois = Integer.parseInt(dateTab[1]);
            } else {
                this.jour = Integer.parseInt(dateTab[2]);
                this.mois = Integer.parseInt(dateTab[1]);
                this.annee = Integer.parseInt(dateTab[0]);
                this.minute = 0;
                this.heure = 0;

            }
        }
        if (date.contains("/")) { // traitement pour les dates venant du logiciel jj/mm/aaaa hh:mm
            String[] dateTab = date.split("/");
            if (dateTab[2].contains(":")) {
                String[] TabAnneeHeure = dateTab[2].split(" ");
                this.annee = Integer.parseInt(TabAnneeHeure[0]);
                String[] TabHeure = TabAnneeHeure[1].split(":");
                this.heure = Integer.parseInt(TabHeure[0]);
                this.minute = Integer.parseInt(TabHeure[1]);

                this.mois = Integer.parseInt(dateTab[1]);
                this.jour = Integer.parseInt(dateTab[0]);
            } else {
                this.jour = Integer.parseInt(dateTab[0]);
                this.mois = Integer.parseInt(dateTab[1]);
                this.annee = Integer.parseInt(dateTab[2]);
                this.minute = 0;
                this.heure = 0;

            }
        }

    }
/**
 * constructeur de la date avec heure
 * @param annee
 * @param mois
 * @param jour
 * @param heure
 * @param minute 
 */
 

    public Date2(int annee, int mois, int jour, int heure, int minute) {
        this.annee = annee;
        this.mois = mois;
        this.jour = jour;
        this.heure = heure;
        this.minute = minute;

    }

    /**
     * return l'heure dans le format hh:mm
     * @return  l'heure
     */
    public String getheure() {
        String s = "";
        if (heure < 10) {
            s += "0" + heure + ":";
        } else {
            s += heure + ":";
        }
        if (minute < 10) {
            s += "0" + minute;
        } else {
            s += minute;
        }

        return s;
    }

    /**
     * 
     * @param d1
     * @param d2
     * @return la date la plus récente par rapport aux 2 dates entrée en paramètre
     */
    public Date2 comparerDate(Date2 d1, Date2 d2) {  
        Date da1 = new Date(d1.modifFormat(d1)[0], d1.modifFormat(d1)[1], d1.modifFormat(d1)[2], d1.modifFormat(d1)[3], d1.modifFormat(d1)[4]);
        Date da2 = new Date(d2.modifFormat(d2)[0], d2.modifFormat(d2)[1], d2.modifFormat(d2)[2], d2.modifFormat(d1)[3], d2.modifFormat(d2)[4]);
        int compare = da1.compareTo(da2);
        if (compare < 0) {
            return d2;
        } else {
            return d1;
        }

    }
    
    /**
     * 
     * @param d1
     * @param d2
     * @return un int négatif si d1 est plus récente que D2, 0 si d1=d2, et un int positif si d2 est plus récente que d1
     * 
     */
     public int comparerDateint(Date2 d1, Date2 d2) {  
        Date da1 = new Date(d1.modifFormat(d1)[0], d1.modifFormat(d1)[1], d1.modifFormat(d1)[2], d1.modifFormat(d1)[3], d1.modifFormat(d1)[4]);
        Date da2 = new Date(d2.modifFormat(d2)[0], d2.modifFormat(d2)[1], d2.modifFormat(d2)[2], d2.modifFormat(d1)[3], d2.modifFormat(d2)[4]);
        return da1.compareTo(da2);
        

    }

     /**
      * 
      * @return uniquement la date (sans l'heure)
      */
    public String toString() {
        String s = "";
        if (jour < 10) {
            s += "0" + jour + "/";
        } else {
            s += jour + "/";
        }

        if (mois < 10) {
            s += "0" + mois + "/";
        } else {
            s += mois + "/";
        }
        s += annee;
        return s;
    }
// renvoie la date avec l'heure sous forme de string
    
    
   /**
    * 
    * @return la date avec l'heure sous la forme d'un string du type jj/mm/aaaa hh:mm
    */
    public String toStringDateHeure() {
        String s = "";
        if (jour < 10) {
            s += "0" + jour + "/";
        } else {
            s += jour + "/";
        }

        if (mois < 10) {
            s += "0" + mois + "/";
        } else {
            s += mois + "/";
        }
        s += annee+" ";
        if (heure < 10) {
            s += "0" + heure + ":";
        } else {
            s += heure + ":";
        }
        if (minute < 10) {
            s += "0" + minute;

        } else {
            s += minute;
        }

        return (s);
    }

    /**
     * 
     * @param date
     * @return  la date dans un tableau de 5 elements(annee,mois,jour,heure,minute)
     */
    public int[] modifFormat(Date2 date) { 
        int[] d = new int[5];
        d[0] = date.annee;
        d[1] = date.mois;
        d[2] = date.jour;
        d[3] = date.heure;
        d[4] = date.minute;
        return d;
    }
//renvoie la date sous forme de texte adapté a l'enregistrement dans la base de donnees
    /**
     * 
     * @return la date sous forme de texte adapté a l'enregistrement dans la base de donnees
     */
    public String toStringDateNaissDB() { 
        return "" + this.annee + "-" + this.mois + "-" + this.jour + " " + this.heure + ":" + this.minute;
    }
}
