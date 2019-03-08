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
public class CompteRendu {
    private Date2 date;
    private String contenu ;
    private Examen exam;
    private String nomPH;
    
    public CompteRendu(Date2 date, String contenu,Examen exam,String nomPH){
        this.contenu=contenu;
        this.date=date;
        this.exam=exam;
        this.nomPH=nomPH;
    }
    
    
    public String ajoutercontenu(String texte){ //permet au medecin d'ajouter sa note 
        this.setContenu(this.getContenu() + "\n"+texte+"realisé " + this.getDate().toString());
        return "votre texte a bien été ajouté";
    }
    public String modifierContenu(String texte){
        this.setContenu("\n"+texte+"\n realisé " + this.getDate().toString());
        return "votre texte a bien été modifiié";
    }

    /**
     * @return the date
     */
    public Date2 getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date2 date) {
        this.date = date;
    }

    /**
     * @return the contenu
     */
    public String getContenu() {
        return contenu;
    }

    /**
     * @param contenu the contenu to set
     */
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    /**
     * @return the exam
     */
    public Examen getExam() {
        return exam;
    }

    /**
     * @param exam the exam to set
     */
    public void setExam(Examen exam) {
        this.exam = exam;
    }




    
}
