package Cloud.fc;
import java.sql.*;
import java.util.*;
import java.io.*;

public class ConnexionPACS {

    String driverName = "com.mysql.cj.jdbc.Driver";
    //String url = "jdbc:mysql://localhost:3306/PACS?useLegacyDatetimeCode=false&serverTimezone=UTC"; // BD locale
    String url = "jdbc:mysql://mysql-cloudbd.alwaysdata.net/cloudbd_pacs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String dbName = "PACS";
    String userName = "cloudBD";
    String password = "cloudSIR";
    Connection con = null;

    public void saveImage(String path,int id,String numero){

        try{
            Class.forName(driverName);
            con = DriverManager.getConnection(url,userName,password);
            Statement st = con.createStatement();
            File imgfile = new File(path);

            FileInputStream fin = new FileInputStream(imgfile);

            PreparedStatement pre =
                    con.prepareStatement("insert into PACS values(?,?,?,?)");

            pre.setInt(1,id);
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

    public void retrieveImage(String numero,String path){
        try{
            Class.forName(driverName);
            con = DriverManager.getConnection(url,userName,password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select image from PACS where numeroArchivage ="+numero+";" );
            int i = 0;
            while (rs.next()) {
                InputStream in = rs.getBinaryStream(1);
                OutputStream f = new FileOutputStream(new File("src/"+numero+"-"+i+".pgm"));
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

    public void retrieveImageId(int id,String path){
        try{
            Class.forName(driverName);
            con = DriverManager.getConnection(url,userName,password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select image from PACS where id ="+id+";" );
            int i = 0;
            while (rs.next()) {
                InputStream in = rs.getBinaryStream(1);
                OutputStream f = new FileOutputStream(new File(path+id+"-"+i+".pgm"));
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
}
