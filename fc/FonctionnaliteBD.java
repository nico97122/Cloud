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
/**
 * constructeur utilise pour aller chercher soit les listes soit de patients , soit d'images, soit de personnels, soit d'examens
 * @throws Exception 
 */
    public FonctionnaliteBD() throws Exception {

    }
/**
 * 
 * @param listeExamen la liste d'examen de la base de donnees
 * @return la liste de patient de la base de donnees
 * @throws SQLException 
 */
    public ArrayList<Patient> ListePatientBD(ArrayList<Examen> listeExamen) throws SQLException {
        try {
            co.connexion();
        } catch (Exception ex) {
            Logger.getLogger(FonctionnaliteBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Patient> listePatient = new ArrayList<>();
        ArrayList<ArrayList<String>> listeDonneesDesPatients = co.requete("datenaissance,nom,prenom,sexe,idpatient,adresse", "patient", "");
        Sexe s;

        for (int j = 0; j < listeDonneesDesPatients.get(0).size(); j++) {

            if (listeDonneesDesPatients.get(3).get(j).equals("0")) {
                s = Sexe.Femme;
            } else {
                s = Sexe.Homme;
            }

            listePatient.add(new Patient(listeDonneesDesPatients.get(1).get(j), listeDonneesDesPatients.get(2).get(j), new Date2(listeDonneesDesPatients.get(0).get(j)), listeDonneesDesPatients.get(4).get(j), s, new ArrayList<Examen>()));
        }
        for (int i = 0; i < listePatient.size(); i++) {
            for (int k = 0; k < listeExamen.size(); k++) {
                if (listePatient.get(i).getId().equals(listeExamen.get(k).getIdPat())) {
                    listePatient.get(i).addExam(listeExamen.get(k));

                }
            }
        }
        try {
            co.deconnexion();
        } catch (Exception ex) {
            Logger.getLogger(FonctionnaliteBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listePatient;
    }
/**
 * 
 * @return la liste de personnel de la base de donnees
 * @throws SQLException 
 */
    public ArrayList<PersonneH> ListePersonnelBD() throws SQLException {
        try {
            co.connexion();
        } catch (Exception ex) {
            Logger.getLogger(FonctionnaliteBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<PersonneH> listePersonnel = new ArrayList<>();
        ArrayList<ArrayList<String>> listeDonneesPersonnel = co.requete("iddbpersonnel,nom,prenom,typepersonnel,iddbpersonnel,idpersonnel,mdp", " personnel ", "");
        for (int k = 0; k < listeDonneesPersonnel.get(1).size(); k++) {
            listePersonnel.add(new PersonneH(listeDonneesPersonnel.get(1).get(k), listeDonneesPersonnel.get(2).get(k), listeDonneesPersonnel.get(6).get(k), listeDonneesPersonnel.get(5).get(k), TypePersonnel.valueOf(listeDonneesPersonnel.get(3).get(k)), listeDonneesPersonnel.get(0).get(k)));
            //  PersonneH(String nom,String prenom,String mdp, String idcon,TypePersonnel tp,String id
        }
        try {
            co.deconnexion();
        } catch (Exception ex) {
            Logger.getLogger(FonctionnaliteBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listePersonnel;
        //A faire

    }
/**
 * 
 * @return la liste d'examen de la base de donnees
 * @throws SQLException 
 */
    public ArrayList<Examen> ListeExamenBD() throws SQLException {
        try {
            co.connexion();
        } catch (Exception ex) {
            Logger.getLogger(FonctionnaliteBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Examen> listeExamen = new ArrayList<>();
        ArrayList<ArrayList<String>> listeDonneesExamens = co.requete("dateexam,idpatient,numeroarchivage,compterendu,typeexam,idpersonnel,iddbpersonnel,iddbexamen", "examen join personnel on iddbpersonnel=iddbmedecin", "");
        for (int k = 0; k < listeDonneesExamens.get(1).size(); k++) {
            Date2 dateExam = new Date2(listeDonneesExamens.get(0).get(k));
            
            
    
            
            String IdPat = listeDonneesExamens.get(1).get(k);
            String numArchiv = listeDonneesExamens.get(2).get(k);
            String cr = listeDonneesExamens.get(3).get(k);
            TypeExam e = TypeExam.valueOf(listeDonneesExamens.get(4).get(k).toLowerCase());
            String IdMed = listeDonneesExamens.get(6).get(k);
            String idExam=listeDonneesExamens.get(7).get(k);
            Examen exam;
            exam = new Examen(dateExam, IdPat, numArchiv, cr, e, IdMed, idExam);

            listeExamen.add(exam);

        }
        try {
            co.deconnexion();
        } catch (Exception ex) {
            Logger.getLogger(FonctionnaliteBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeExamen;
    }
/**
 * 
 * @param listeExamen de la base de donnees
 * @return la listes d'Images de la base de donnee
 * @throws SQLException
 * @throws Exception 
 */
    public ArrayList<Image> ListeImageBD(ArrayList<Examen> listeExamen) throws SQLException, Exception {
        ArrayList<Image> listeImage = new ArrayList<>();
        ConnexionPACS cop = new ConnexionPACS();
        cop.connexion();
        ArrayList<String> listeNumArchiv = new ArrayList<>();
        for (int j = 0; j < listeExamen.size(); j++) {
            if (!listeNumArchiv.contains(listeExamen.get(j).getNumArchiv())) {
                listeNumArchiv.add(listeExamen.get(j).getNumArchiv());
            }
        }
        for (int i = 0; i < listeNumArchiv.size(); i++) {
          cop.retrieveImage(listeNumArchiv.get(i),"src/Cloud/imageBD/","png");
            ArrayList<String> listeIdImg=cop.requetePACS("id", "PACS", "where numeroArchivage="+"'"+listeNumArchiv.get(i)+"'").get(0);
            for (int x=0;x<listeIdImg.size();x++){
                
                listeImage.add(new Image("src/Cloud/imageBD/"+listeIdImg.get(x)+".png",listeIdImg.get(x),listeNumArchiv.get(i)));
            }
            cop.deconnexion();
        } //Image(String pathIm, String id, String NumArchivage)
       return listeImage;
    }/**
     * pour se connecter a la base de donnees
     */
    public void connexion() {
        try {
            co.connexion();
        } catch (Exception ex) {
            Logger.getLogger(FonctionnaliteBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * pour se deconnecter de la base de donnees
     */
    public void decoBD() {
        try {
            co.deconnexion();
        } catch (Exception ex) {
            Logger.getLogger(FonctionnaliteBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
