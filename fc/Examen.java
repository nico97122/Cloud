/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.fc;

import java.awt.Image;

/**
 *
 * @author nicol
 */
public class Examen {
    private Date2 date;
    private Patient p;
    private Image img;
    private CompteRendu cr;
    private TypeExam typeExamen;
    private PersonneH ph;
    public Examen(Date2 date, Patient p , Image img , CompteRendu cr,TypeExam typeExamen, PersonneH ph){
        this.date=date;
        this.cr=cr;
        this.p=p;
        this.typeExamen=typeExamen;
        this.ph=ph;
        this.img=img;
    }
}
