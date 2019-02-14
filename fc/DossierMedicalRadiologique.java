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
    public DossierMedicalRadiologique(Patient p, ArrayList<Examen> listeExam,Date2 dateCreation){
        this.listeExam=listeExam;
        this.dateCreation=dateCreation;
        this.p=p;
    }

    /**
     * @return the p
     */
    public Patient getP() {
        return p;
    }

    /**
     * @return the listeExam
     */
    public ArrayList<Examen> getListeExam() {
        return listeExam;
    }

    /**
     * @return the dateCreation
     */
    public Date2 getDateCreation() {
        return dateCreation;
    }
    public void ajouterUnExam(Examen exam){
        listeExam.add(exam);
    }
}
