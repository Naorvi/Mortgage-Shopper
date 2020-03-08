import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BankSQL {

    public static void insertBank(String name, double intRate){
        try{
            Connection con =connectToSQL();
            PreparedStatement insertData=con.prepareStatement(
                    "INSERT INTO banks (bankname,intrestrate) VALUES('"+name+"','"+intRate+"')"
            );
            insertData.executeUpdate();
        }
        catch(Exception e){System.out.println(e);}
        finally{System.out.println("insertBank("+ name+"); executed");}
    }

    public static void createTable() throws Exception{
        try{
            Connection con =connectToSQL();
            PreparedStatement createTable=con.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS banks(id int NOT NULL AUTO_INCREMENT, bankname varchar(255), intrestrate float(50,10), PRIMARY KEY(id))");
            createTable.executeUpdate();
        }
        catch(Exception e){System.out.println(e);}
        finally{System.out.println("createTable(); executed");}
    }

    public static Connection connectToSQL() throws Exception{
        try{
            String driver="com.mysql.cj.jdbc.Driver";
            String url="jdbc:mysql://testsql.copperramparts.com:3306/javasqltest";
            String username="test123copper";
            String password="k6@J6r4K7gb^";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("connected");
            return conn;
        }
        catch(Exception e){System.out.println(e);}
        return null;
    }
}
