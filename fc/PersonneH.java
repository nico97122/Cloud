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
public class PersonneH {
    private String id;
    private String mdp;
    private TypePersonnel tp;
    private String nom;
    private String prenom;
    private String idcon;
    
    
    /**
     * 
     * @param nom du personnel
     * @param prenom du personnel
     * @param mdp du personnel
     * @param idcon du personnel
     * @param tp proffession du personnel
     * @param id  du personnel
     */
    public PersonneH(String nom,String prenom,String mdp, String idcon,TypePersonnel tp,String id){
        this.id=id;
        this.mdp=mdp;
        this.tp=tp;   
        this.idcon=idcon;
        this.prenom=prenom;
        this.nom=nom;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the mdp
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * @param mdp the mdp to set
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    /**
     * @return the tp
     */
    public TypePersonnel getTp() {
        return tp;
    }

    /**
     * @param tp the tp to set
     */
    public void setTp(TypePersonnel tp) {
        this.tp = tp;
    }

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
     * @return the idcon
     */
    public String getIdcon() {
        return idcon;
    }

    /**
     * @param idcon the idcon to set
     */
    public void setIdcon(String idcon) {
        this.idcon = idcon;
    }
   
}
