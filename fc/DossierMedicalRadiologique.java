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
public class DossierMedicalRadiologique {
 
    private Patient p;
    private ArrayList<Examen> listeExam;
    private Date2 dateCreation;
    /**
     * 
     * @param p le patient associe a ce dossier medical radiologique
     * @param listeExam la liste d'exmaen du patient
     * @param dateCreation date a laquelle le patient a eu son dossier medical radiologique ouvert
     */
    public DossierMedicalRadiologique(Patient p, ArrayList<Examen> listeExam,Date2 dateCreation){
        this.listeExam=listeExam;
        this.dateCreation=dateCreation;
        this.p=p;
    }

    /**
     * @return the patient
     */
    public Patient getP() {
        return p;
    }

    /**
     * @return la liste d''examen
     */
    public ArrayList<Examen> getListeExam() {
        return listeExam;
    }

    /**
     * @return la date de creation
     */
    public Date2 getDateCreation() {
        return dateCreation;
    }
    
    /**
     * 
     * @param examen ,l'examen a ajoutee a la liste d'examen 
     */
    public void ajouterUnExam(Examen exam){
        listeExam.add(exam);
    }
}
