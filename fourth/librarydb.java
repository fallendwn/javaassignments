package fourth;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class librarydb {
    Connection con = null;
    ResultSet rs = null;
    Result res = null;
    String connectionUrl = "jdbc:postgresql://localhost:5432/java1";
    String username = "postgres";
    String password = "123d";
    public int add_new(String name) {
        String query_ = "INSERT INTO library(name) VALUES (?)";
        try {
            Connection con = DriverManager.getConnection(connectionUrl, username, password);
            PreparedStatement pstmt = con.prepareStatement(query_);
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            return 1;

        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }
    public int remove(String name) {
        String query_ = "DELETE FROM library WHERE name = ?";
        try  {
            Connection con = DriverManager.getConnection(connectionUrl, username, password);
            PreparedStatement pstmt = con.prepareStatement(query_);
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            return 1;

        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }
    public ArrayList<String>  getAll(){
        try{
            Connection con = DriverManager.getConnection(connectionUrl, username, password);
            String query = "SELECT * FROM library";
            PreparedStatement pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            ArrayList<String> list_of_names = new ArrayList<>();
            while(rs.next()){
                list_of_names.add(rs.getString("name"));
            }
            return list_of_names;

        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public ArrayList<String> getAllDepartaments(String name){
        try{
            Connection con = DriverManager.getConnection(connectionUrl,username,password);
            String query = "SELECT id FROM library WHERE name = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            int list_of_id = 0;
            while(rs.next()) {
                list_of_id = rs.getInt("id");
            }

            query = "SELECT * FROM departament WHERE library_id = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, list_of_id);
            rs = pstmt.executeQuery();
            ArrayList<String> list_of_names = new ArrayList<>();
            while(rs.next()) {
                list_of_names.add(rs.getString("genre_name"));
            }
            return list_of_names;

        }
        catch(Exception e){
            return null;
        }

    }
}
