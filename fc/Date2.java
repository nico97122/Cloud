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
import java.util.Arrays;
import java.util.Date;

public class Date2 {

    private int année;
    private int mois;
    private int jour;
    private int heure;
    private int minute;

    public Date2(int année, int mois, int jour) {
        this.année = année;
        this.mois = mois;
        this.jour = jour;
        this.heure = 0;
        this.minute = 0;

    }

    public Date2(String date) {
        if (date.contains("-")) {//traitement pour les dates venant de la BD;
            String[] dateTab = date.split("-");

            if (dateTab[2].contains(":")) {
                String[] TabJourHeure = dateTab[2].split(" ");
                this.jour = Integer.parseInt(TabJourHeure[0]);
                String[] TabHeure = TabJourHeure[1].split(":");
                this.heure = Integer.parseInt(TabHeure[0]);
                this.minute = Integer.parseInt(TabHeure[1]);
                this.année = Integer.parseInt(dateTab[0]);
                this.mois = Integer.parseInt(dateTab[1]);
            } else {
                this.jour = Integer.parseInt(dateTab[2]);
                this.mois = Integer.parseInt(dateTab[1]);
                this.année = Integer.parseInt(dateTab[0]);
                this.minute = 0;
                this.heure = 0;

            }
        }
        if (date.contains("/")) { /// traitement pour les dates venant du logiciel
            String[] dateTab = date.split("/");
            if (dateTab[2].contains(":")) {
                String[] TabAnneeHeure = dateTab[2].split(" ");
                this.année = Integer.parseInt(TabAnneeHeure[0]);
                String[] TabHeure = TabAnneeHeure[1].split(":");
                this.heure = Integer.parseInt(TabHeure[0]);
                this.minute = Integer.parseInt(TabHeure[1]);
                this.année = Integer.parseInt(dateTab[0]);
                this.mois = Integer.parseInt(dateTab[1]);
            } else {
                this.jour = Integer.parseInt(dateTab[0]);
                this.mois = Integer.parseInt(dateTab[1]);
                this.année = Integer.parseInt(dateTab[2]);
                this.minute = 0;
                this.heure = 0;

            }
        }

    }

    public Date2(int année, int mois, int jour, int heure, int minute) {
        this.année = année;
        this.mois = mois;
        this.jour = jour;
        this.heure = heure;
        this.minute = minute;

    }

    public Date2 comparerDate(Date2 d1, Date2 d2) {  // renvoie la date la plus récente
        Date da1 = new Date(d1.modifFormat(d1)[0], d1.modifFormat(d1)[1], d1.modifFormat(d1)[2], d1.modifFormat(d1)[3], d1.modifFormat(d1)[4]);
        Date da2 = new Date(d2.modifFormat(d2)[0], d2.modifFormat(d2)[1], d2.modifFormat(d2)[2], d2.modifFormat(d1)[3], d2.modifFormat(d2)[4]);
        int compare = da1.compareTo(da2);
        if (compare < 0) {
            return d2;
        } else {
            return d1;
        }

    }

    public int[] modifFormat(Date2 date) { //renvoie la date dans un tableau de 5 éléments
        int[] d = new int[5];
        d[0] = date.année;
        d[1] = date.mois;
        d[2] = date.jour;
        d[3] = date.heure;
        d[4] = date.minute;
        return d;
    }

    public String toStringDateNaissDB() { //renvoie la date sous forme de texte adapté a l'enregistrement dans la base de données
        return "" + this.année + "-" + this.mois + "-" + this.jour;
    }
}
