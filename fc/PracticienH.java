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
public class PracticienH extends PersonneH{
    private String nom;
    private String prenom;
    public PracticienH(String mdp, String id,String nom, String prenom){
         super(id,mdp);
            this.nom=nom; 
        this.prenom=prenom;
    }
}
