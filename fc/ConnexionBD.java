/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cloud.fc;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;
/**
 *
 * @author nicol
 */
public class ConnexionBD {
    public String url;
    private String user;
    private String password;

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet res = null;
    private ResultSetMetaData resMeta = null;
    private String query = null;

    public ConnexionBD() { // constructeur par défaut
        //this.url = "jdbc:mysql://localhost:3306/dbSIR?useLegacyDatetimeCode=false&serverTimezone=UTC"; // BD locale
       this.url = "jdbc:mysql://mysql-cloudbd.alwaysdata.net/cloudbd_sir?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        this.user = "cloudbd";
        this.password = "cloudSIR";

    }

    public ConnexionBD(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void connexion() throws Exception {
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); //Chargement du pilote MySQL.
        } catch (ClassNotFoundException e) {System.out.println ("Problème au chargement"+e.toString());}//Gestion erreur de connexion
        try {
            Connection con = DriverManager.getConnection(url,user,password);
            this.con=con;
            Statement stmt = con.createStatement();
            this.stmt=stmt;
        } catch (SQLException e) {
        }

    }

    public ResultSet result(String query){
        this.query = query;
        try {
            
        
            res = stmt.executeQuery(query);
          
            this.res=res;
            
            resMeta = res.getMetaData();
            
            this.resMeta = resMeta;
            
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    public ArrayList<ArrayList<String>> requete(String champs, String table, String condition)throws SQLException{ //gestion des resultats de requetes vides a implementer, tester avec éléments nulls

        String stringToSplit = new String(champs);
        String[] tempArray;
        String delimiter = ",";
        String compositionRequete = "";
        ResultSet resultatRequete;
        int nbChamps = 0;
        tempArray = stringToSplit.split(delimiter);// les champs sont séparés et stocké dans un Array
        nbChamps = tempArray.length;
        
        compositionRequete = "SELECT "+ champs +" FROM "+ table +" "+ condition + ";" ; //élaboration de la requete à partir des paramètres
        System.out.println(compositionRequete);
        resultatRequete = result(compositionRequete);

        ArrayList<ArrayList<String>> listResultat = new ArrayList<ArrayList<String>>(nbChamps);

        for(int i = 0; i<nbChamps; i++){
            listResultat.add(new ArrayList<String>());
        }

        try{

            while(resultatRequete.next()){
              
                for(int i = 0; i<nbChamps; i++){

                    listResultat.get(i).add(resultatRequete.getString(tempArray[i]));

                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listResultat;
    }

    public int insererBD(String table,String attributs,String valeursAttributs ) {
        int i = 0;
        String s;
        s="INSERT INTO "+table+" ("+attributs+") "+"VALUES ("+valeursAttributs+" );" ; //élaboration de la requete
        try {
            i = stmt.executeUpdate(s);
           
        } catch (SQLException ex) {
            return i;
        }
        System.out.println(i +" lignes ajoutées");
        return i;
    }

    public void deconnexion() throws Exception
    {
        if(con != null)
        {
            con.close();
        }
    }
public int insert(String table,String attributs, String attributsValeurs) {
        int i = 0;
        String requete = "INSERT INTO "+table+"("+attributs+")VALUES("+attributsValeurs+");";
        //System.out.println(requete);
        try {
            i = stmt.executeUpdate(requete);
        } catch (SQLException ex) {
            return i;
        }
        System.out.println(i +" lignes ajoutées");
        
        return i;
    }
    // ajouter patient ajouter exam a faire
}
