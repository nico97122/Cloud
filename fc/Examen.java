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
public class Examen {
    private Date2 date;
    private String  IdPat;
    private String numArchiv;
    private String cr;
    private TypeExam typeExamen;
    private String idMed;
    private String idExamen;
    /**
     * 
     * @param date
     * @param IdPat
     * @param numArchiv
     * @param cr
     * @param typeExamen
     * @param idMed
     * @param idExamen 
     * cree un examen a partir de Date2 date, String IdPat, String numArchiv , String cr,TypeExam typeExamen, String idMed et String idExamen
     */
    public Examen(Date2 date, String IdPat, String numArchiv , String cr,TypeExam typeExamen, String idMed, String idExamen){
        this.date=date;
        this.cr=cr;
        this.IdPat=IdPat;
        this.typeExamen=typeExamen;
        this.idMed=idMed;
        this.numArchiv=numArchiv;
        this.idExamen=idExamen;
    }
  

    /**
     * @return the date
     */
    public Date2 getDate() {
        return date;
    }
     /**
      * 
      * @return l'id de l'examen 
      */
    public String getidExamen() {
        return idExamen;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date2 date) {
        this.date = date;
    }

    /**
     * @return the IdPat
     */
    public String getIdPat() {
        return IdPat;
    }

    /**
     * @param IdPat the IdPat to set
     */
    public void setIdPat(String IdPat) {
        this.IdPat = IdPat;
    }

    /**
     * @return the numArchiv
     */
    public String getNumArchiv() {
        return numArchiv;
    }

    /**
     * @param numArchiv the numArchiv to set
     */
    public void setNumArchiv(String numArchiv) {
        this.numArchiv = numArchiv;
    }

    /**
     * @return the cr
     */
    public String getCr() {
        return cr;
    }

    /**
     * @param cr the cr to set
     */
    public void setCr(String cr) {
        this.cr = cr;
    }

    /**
     * @return the typeExamen
     */
    public TypeExam getTypeExamen() {
        return typeExamen;
    }

    /**
     * @param typeExamen the typeExamen to set
     */
    public void setTypeExamen(TypeExam typeExamen) {
        this.typeExamen = typeExamen;
    }

    /**
     * @return the idMed
     */
    public String getIdMed() {
        return idMed;
    }

    /**
     * @param idMed the idMed to set
     */
    public void setIdMed(String idMed) {
        this.idMed = idMed;
    }
}
