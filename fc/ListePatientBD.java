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
public class ListePatientBD {

    private ArrayList<Patient> listePatient = new ArrayList<>();

    public ListePatientBD(ArrayList<Examen> listeExamen) throws Exception {
        ConnexionBD co = new ConnexionBD();
        co.connexion();
        ArrayList<ArrayList<String>> listeDonneesDesPatients = co.requete("datenaissance,nom,prenom,sexe,idpatient,adresse", "patient", "");
        Sexe s;

        for (int j = 0; j < listeDonneesDesPatients.get(0).size(); j++) {

            if (listeDonneesDesPatients.get(3).get(j).equals(0)) {
                s = Sexe.Femme;
            } else {
                s = Sexe.Homme;
            }

            listePatient.add(new Patient(listeDonneesDesPatients.get(1).get(j), listeDonneesDesPatients.get(2).get(j), new Date2(listeDonneesDesPatients.get(0).get(j)), listeDonneesDesPatients.get(4).get(j), s, new ArrayList<>()));
        }// Patient(String nom,String prenom,Date2 dateN,String id,Sexe sexe,ArrayList<Examen> ListeExam)
        for (int i = 0; i < listePatient.size(); i++) {
            for (int k = 0; k < listeExamen.size(); k++) {
                if (listePatient.get(i).getId().equals(listeExamen.get(k).getIdPat())){
                listePatient.get(i).addExam(listeExamen.get(k)); 
                
            }
            }
        }
        co.deconnexion();

    }

    /**
     * @return the listePatient
     */
    public ArrayList<Patient> getListePatient() {
        return listePatient;
    }
}
