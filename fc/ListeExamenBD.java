/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.fc;

import java.util.ArrayList;

/**
 *
 * @author nicol
 */
public class ListeExamenBD {
     private ArrayList<Examen> listeExamen = new ArrayList<>();
    
     public ListeExamenBD() throws Exception{
         ConnexionBD co = new ConnexionBD();
         co.connexion();
          ArrayList<ArrayList<String>> listeDonneesExamens = co.requete("dateexam,idpatient,numeroarchivage,compterendu,typeexam,idpersonnel", "examen join personnel on iddbpersonnel=iddbmedecin", "");
         for (int k = 0; k < listeDonneesExamens.get(1).size(); k++) {
            Date2 dateExam = new Date2(listeDonneesExamens.get(0).get(k));
            String IdPat = listeDonneesExamens.get(1).get(k);
            String numArchiv = listeDonneesExamens.get(2).get(k);
            String cr = listeDonneesExamens.get(3).get(k);
            TypeExam e = TypeExam.valueOf(listeDonneesExamens.get(4).get(k).toLowerCase());
            String IdMed = listeDonneesExamens.get(5).get(k);

            Examen exam;
            exam = new Examen(dateExam, IdPat, numArchiv, cr, e, IdMed);

            listeExamen.add(exam);

           
        }
co.deconnexion();
    }

    /**
     * @return the listeExamen
     */
    public ArrayList<Examen> getListeExamen() {
        return listeExamen;
    }

    /**
     * @param listeExamen the listeExamen to set
     */
    public void setListeExamen(ArrayList<Examen> listeExamen) {
        this.listeExamen = listeExamen;
    }
}
