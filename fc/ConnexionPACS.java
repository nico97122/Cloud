import java.sql.*;
import java.util.*;
import java.io.*;

public class ConnexionPACS {

    public String url;
    private String user;
    private String password;

    private Connection con = null;
    private Statement stmt = null;

    public ConnexionPACS() { // constructeur par défaut
        this.url = "jdbc:mysql://localhost:3306/PACS?useLegacyDatetimeCode=false&serverTimezone=UTC";
        this.user = "cloudBD";
        this.password = "cloudSIR";

        //this.url = "jdbc:mysql://mysql-cloudbd.alwaysdata.net/cloudbd_sir?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        //this.user = "cloudbd";
        //this.password = "cloudSIR";
    }

    public ConnexionPACS(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void connexion() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); //Chargement du pilote MySQL.
        } catch (ClassNotFoundException e) {System.out.println ("Problème au chargement"+e.toString());}//Gestion erreur de connexion
        try {
            Connection con = DriverManager.getConnection(url,user,password);
            this.con=con;
            Statement stmt = con.createStatement();
            this.stmt=stmt;
        } catch (SQLException e) {
        }

    }

    public void deconnexion() throws Exception
    {
        if(con != null)
        {
            con.close();
        }
    }

    public void sauveIMG(String location, int id, String numero) throws Exception
    {
        File monImage = new File(location);
        FileInputStream istreamImage = new FileInputStream(monImage);
        try
        {
            PreparedStatement ps = con.prepareStatement("insert into PACS values (?,?,?,?)");
            try
            {
                ps.setInt(1, id);
                ps.setString(2, numero);
                ps.setInt(3,4);
                ps.setBinaryStream(4, (InputStream)istreamImage, (int) monImage.length());
                ps.executeUpdate();
            }
            finally
            {
                ps.close();
                con.close();
            }
        }
        finally
        {
            istreamImage.close();
        }
    }

    public void chargeIMG(String numero, String location) throws Exception
    {
        File monImage = new File(location);
        FileOutputStream ostreamImage = new FileOutputStream(monImage);

        try
        {
            PreparedStatement ps = con.prepareStatement("select image from PACS where numeroArchivage=?");

            try
            {
                ps.setString(1,numero);
                ResultSet rs = ps.executeQuery();

                try
                {
                    if(rs.next())
                    {
                        InputStream istreamImage = rs.getBinaryStream("image");

                        byte[] buffer = new byte[1024];
                        int length = 0;

                        while((length = istreamImage.read(buffer)) != -1)
                        {
                            ostreamImage.write(buffer, 0, length);
                        }
                    }
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


    public void chargeIMGunique(String name, String location) throws Exception
    {
        File monImage = new File(location);
        FileOutputStream ostreamImage = new FileOutputStream(monImage);

        try
        {
            PreparedStatement ps = con.prepareStatement("select image from PACS where id=?");

            try
            {
                ps.setString(1,name);
                ResultSet rs = ps.executeQuery();

                try
                {
                    if(rs.next())
                    {
                        InputStream istreamImage = rs.getBinaryStream("image");

                        byte[] buffer = new byte[1024];
                        int length = 0;

                        while((length = istreamImage.read(buffer)) != -1)
                        {
                            ostreamImage.write(buffer, 0, length);
                        }
                    }
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

}
