import java.sql.Connection;
import java.sql.DriverManager;

public class BankSQL {
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
