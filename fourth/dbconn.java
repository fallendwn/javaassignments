package fourth;
import java.sql.*;
public class dbconn {
    public static void main(String[] args) {
        String connectionUrl = "jdbc:postgresql://localhost:5432/java1";
        Connection con = null;
        try {
            con = DriverManager.getConnection(connectionUrl, "postgres", "123d");
        } catch (Exception e) {
            System.out.println(e);
        }
        finally {
            try{
                con.close();
            }
            catch(SQLException throwables){
                throwables.printStackTrace();
            }

        }
    }

    public class departament_db{
        public static void add_new(String name){}
    }
}

