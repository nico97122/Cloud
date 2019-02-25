/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.fc;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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
    
    public Examen(Date2 date, String IdPat, String numArchiv , String cr,TypeExam typeExamen, String idMed){
        this.date=date;
        this.cr=cr;
        this.IdPat=IdPat;
        this.typeExamen=typeExamen;
        this.idMed=idMed;
        this.numArchiv=numArchiv;
    }
     public Examen(){
         
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
