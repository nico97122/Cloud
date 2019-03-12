package Cloud.fc;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnexionPACS {
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet res = null;
    private ResultSetMetaData resMeta = null;
    private String query = null;

    String driverName = "com.mysql.jdbc.Driver";
   // String url = "jdbc:mysql://localhost:3306/PACS?useLegacyDatetimeCode=false&serverTimezone=UTC"; // BD locale
    String url = "jdbc:mysql://mysql-cloudbd.alwaysdata.net/cloudbd_pacs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String dbName = "PACS";
    String userName = "cloudbd";
    String password = "cloudSIR";


    public void saveImage(String path,String id,String numero){

        try{
            Class.forName(driverName);
            con = DriverManager.getConnection(url,userName,password);
            Statement st = con.createStatement();
            File imgfile = new File(path);

            FileInputStream fin = new FileInputStream(imgfile);

            PreparedStatement pre =
                    con.prepareStatement("insert into PACS values(?,?,?,?)");

            pre.setString(1,id);
            pre.setString(2,numero);
            pre.setInt(3,4);
            pre.setBinaryStream(4,(InputStream)fin,(int)imgfile.length());
            pre.executeUpdate();
            System.out.println("Successfully inserted the file into the database!");

            pre.close();
            con.close();
        }catch (Exception e1){
            System.out.println(e1.getMessage());
        }
    }

    public void retrieveImage(String numero,String path,String format){
        try{
            Class.forName(driverName);
            con = DriverManager.getConnection(url,userName,password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select image,id from PACS where numeroArchivage ="+numero+";" );
            int i = 0;
            while (rs.next()) {
                String id= rs.getString("id");
                InputStream in = rs.getBinaryStream(1);
                OutputStream f = new FileOutputStream(new File("src/Cloud/imageBD/"+id+"."+format));
                i++;
                int c = 0;
                while ((c = in.read()) > -1) {
                    f.write(c);
                }
                f.close();
                in.close();
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void retrieveImageId(int id,String path,String format){
        try{
            Class.forName(driverName);
            con = DriverManager.getConnection(url,userName,password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select image from PACS where id ="+id+";" );
            int i = 0;
            while (rs.next()) {
                InputStream in = rs.getBinaryStream(1);
                OutputStream f = new FileOutputStream(new File(path+id+"-"+i+"."+format));
                i++;
                int c = 0;
                while ((c = in.read()) > -1) {
                    f.write(c);
                }
                f.close();
                in.close();
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }


    public boolean existInPACS(String attribut, String table, String s)throws SQLException{

        ArrayList<ArrayList<String>> liste = new ArrayList<ArrayList<String>>();

        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, userName, password);
            Statement stmt = con.createStatement();
            //ResultSet rs = stmt.executeQuery("select image from PACS where "+attribut+" = " + s + ";");
            liste = requetePACS(attribut,table,"where "+attribut+"= "+s);


        }catch(Exception ex){};

        if(liste.get(0).isEmpty()){
            return false;
        }
        else{
            return true;
        }

    }


    public ArrayList<ArrayList<String>> requetePACS(String champs, String table, String condition)throws SQLException{ //gestion des resultats de requetes vides a implementer, tester avec éléments nulls

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

    public void connexion() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); //Chargement du pilote MySQL.
        } catch (ClassNotFoundException e) {System.out.println ("Problème au chargement"+e.toString());}//Gestion erreur de connexion
        try {
            Connection con = DriverManager.getConnection(url,userName,password);
            this.con=con;
            Statement stmt = con.createStatement();
            this.stmt=stmt;
        } catch (SQLException e) {
        }

        if(con!=null) {
            System.out.println("connecté");
        }else{
            System.out.println("pas connecté");}

    }
    
}
