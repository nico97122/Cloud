import java.sql.*;
import java.util.*;
import java.io.*;

public class ConnexionPACS {

    public String url;
    private String user;
    private String password;

    public void saveImage(String path,int id,String numero){

    public ConnexionPACS() { // constructeur par défaut
        this.url = "jdbc:mysql://localhost:3306/PACS?useLegacyDatetimeCode=false&serverTimezone=UTC";
        this.user = "cloudBD";
        this.password = "cloudSIR";

        //this.url = "jdbc:mysql://mysql-cloudbd.alwaysdata.net/cloudbd_sir?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        //this.user = "cloudbd";
        //this.password = "cloudSIR";
    }

            PreparedStatement pre =
                    con.prepareStatement("insert into PACS values(?,?,?,?)");

            pre.setInt(1,id);
            pre.setString(2,numero);
            pre.setInt(3,4);
            pre.setBinaryStream(4,(InputStream)fin,(int)imgfile.length());
            pre.executeUpdate();
            System.out.println("Successfully inserted the file into the database!");

    }

    public void deconnexion() throws Exception
    {
        if(con != null)
        {
            con.close();
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
                finally
                {
                    rs.close();
                }
            }
            finally
            {
                ps.close();
            }
        }
        finally
        {
            ostreamImage.close();
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
