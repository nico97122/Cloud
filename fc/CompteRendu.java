/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fc;

/**
 *
 * @author nicol
 */
public class CompteRendu {
    private Date2 date;
    private String contenu ;
    private Examen exam;
    private PracticienH ph;
    
    public CompteRendu(Date2 date, String contenu,Examen exam,PracticienH ph){
        this.contenu=contenu;
        this.date=date;
        this.exam=exam;
        this.ph=ph;
    }
    public String ajoutercontenu(String texte){ //permet au medecin d'ajouter sa note 
        this.contenu+= "\n"+texte+"realisé "+this.date.toString();
        return "votre texte a bien été ajouté";
    }
    public String modifierContenu(String texte){
         this.contenu= "\n"+texte+"\n realisé "+this.date.toString();
        return "votre texte a bien été modifiié";
    }
    
}
