package fourth;

import java.sql.*;
import java.util.ArrayList;
public class departamentdb {
    ResultSet rs = null;
    String connectionUrl = "jdbc:postgresql://localhost:5432/java1";
    String username = "postgres";
    String password = "123d";
    public int add_new(String genreName, int numberOfEditions, String libraryName) {
        String query_ = "INSERT INTO departament (genre_name, number_of_editions, library_id) VALUES (?, ?, ?)";
        String get_libraryId_by_name = "SELECT id FROM library WHERE name = ?";
        try (Connection con = DriverManager.getConnection(connectionUrl, username, password)) {
            PreparedStatement getInt = con.prepareStatement(get_libraryId_by_name);
            getInt.setString(1, libraryName);
            rs = getInt.executeQuery();

            if (rs.next()) {
                int libraryId = rs.getInt("id");
                PreparedStatement insertPstmt = con.prepareStatement(query_);
                insertPstmt.setString(1, genreName);
                insertPstmt.setInt(2, numberOfEditions);
                insertPstmt.setInt(3, libraryId);
                insertPstmt.executeUpdate();
                return 1;
            } else {
                System.out.println("library: " + libraryName);
                return 0;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }
    public int remove(String name) {
        String query_ = "DELETE FROM departament WHERE genre_name = ?";
        try{
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
    public ResultSet getAll() {
        try {
            Connection con = DriverManager.getConnection(connectionUrl, username, password);
            String query = "SELECT * FROM departament";
            PreparedStatement pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            return rs;

        } catch (SQLException e) {

            return null;

        }
    }
    public int getSpecific(String name){
        String query = "SELECT * FROM departament WHERE genre_name = ?";
        int number_ = 0;
        try{

            Connection con = DriverManager.getConnection(connectionUrl, username, password);
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            while(rs.next()){
                number_ = rs.getInt("number_of_editions");
            }
            return number_;
        }
        catch(Exception e){
            return number_;

        }

    }
    public ArrayList<String> get_all_editions(String departament_name) {
        String query = "SELECT * FROM departament WHERE genre_name = ?";
        String query_1 = "SELECT * FROM edition WHERE departament_id = ?";
        try{
            Connection con = DriverManager.getConnection(connectionUrl, username, password);
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, departament_name);
            rs = pstmt.executeQuery();
            int id = 0;
            while(rs.next()){
                id = rs.getInt("id");
            }
            ArrayList<String> name_array = new ArrayList<>();
            PreparedStatement pstmt1 = con.prepareStatement(query_1);
            pstmt1.setInt(1, id);
            rs = pstmt1.executeQuery();
            while(rs.next()){
                name_array.add(rs.getString("edition_name"));
            }
            return name_array;


        }
        catch(Exception e){
            return null;
        }
    }
}
