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
public class ManipRadio extends PersonneH{
    private String nom;
    private String prenom;
        public ManipRadio(String nom, String prenom,String id , String mdp){
        super(id,mdp);
            this.nom=nom; 
        this.prenom=prenom;
    }
}
