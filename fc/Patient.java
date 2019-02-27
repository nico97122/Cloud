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
public class Patient {

    private String nom;
    private String prenom;
    private Date2 dateN;
    private String id;
    private Sexe sexe;
    private ArrayList<Examen> ListeExam=new ArrayList<>();
    
    
    public Patient(String nom,String prenom,Date2 dateN,String id,Sexe sexe,ArrayList<Examen> ListeExam){
        this.dateN=dateN;
        this.nom=nom;
        this.prenom=prenom;
        this.sexe=sexe;
        this.id=id;
        this.ListeExam=ListeExam;
    }
    
    /**
     * @return the ListeExam
     */
    public ArrayList<Examen> getListeExam() {
        return ListeExam;
    }

    /**
     * @param ListeExam the ListeExam to set
     */
    public void setListeExam(ArrayList<Examen> ListeExam) {
        this.ListeExam = ListeExam;
    }
      public void addExam(Examen Exam) {
        this.ListeExam.add(Exam);
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
}
