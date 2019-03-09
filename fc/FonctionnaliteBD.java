/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.fc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicol
 */
public class FonctionnaliteBD {

    private ConnexionBD co = new ConnexionBD();

    public FonctionnaliteBD() throws Exception {

        co.connexion();
    }

    public ArrayList<Patient> ListePatientBD(ArrayList<Examen> listeExamen) throws SQLException {

        ArrayList<Patient> listePatient = new ArrayList<>();
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
                if (listePatient.get(i).getId().equals(listeExamen.get(k).getIdPat())) {
                    listePatient.get(i).addExam(listeExamen.get(k));

                }
            }
        }
        return listePatient;
    }
     public ArrayList<PersonneH> ListePersonnelBD() throws SQLException {
          ArrayList<PersonneH> listePersonnel = new ArrayList<>();
         
        return null;
     //A faire
         
     }

    public ArrayList<Examen> ListeExamenBD() throws SQLException {
        ArrayList<Examen> listeExamen = new ArrayList<>();
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
        return listeExamen;
    }
//    public ArrayList<Image> ListeImageBD( ArrayList<Examen> listeExamen ){
//        ArrayList<Image> listeImage=new ArrayList<>(); 
//        ConnexionPACS cop=new ConnexionPACS();
//        for(int i=0;i<listeExamen.size();i++){
//            
//            listeImage.add(new Image());
//        }
//    }

    public void decoBD() {
        try {
            co.deconnexion();
        } catch (Exception ex) {
            Logger.getLogger(FonctionnaliteBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
