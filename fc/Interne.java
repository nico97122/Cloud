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
public class Interne extends PersonneH{
    private String nom;
    private String prenom; 
    public Interne(String nom, String prenom,String id,String mdp){
        super(id,mdp);
        this.nom=nom; 
        this.prenom=prenom;
        
    }
}
