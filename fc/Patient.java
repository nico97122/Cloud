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

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the dateN
     */
    public Date2 getDateN() {
        return dateN;
    }

    /**
     * @param dateN the dateN to set
     */
    public void setDateN(Date2 dateN) {
        this.dateN = dateN;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the sexe
     */
    public Sexe getSexe() {
        return sexe;
    }

    /**
     * @param sexe the sexe to set
     */
    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    private String nom;
    private String prenom;
    private Date2 dateN;
    private String id;
    private Sexe sexe;
    private ArrayList<Examen> ListeExam=new ArrayList<>();
    
     public Patient(){
         
     }
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
          this.getListeExam().add(Exam);
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
}
