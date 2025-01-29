package fourth;

import java.sql.*;
import java.util.ArrayList;

public class editiondb {
        ResultSet rs = null;
        String connectionUrl = "jdbc:postgresql://localhost:5432/java1";
        String username = "postgres";
        String password = "123d";
    public int add_new(String edition_name,String edition_author ,int edition_year, String departamentName) {
        String query_ = "INSERT INTO edition (edition_name, edition_author, edition_year, departament_id) VALUES (?, ?, ?, ?)";
        String get_libraryId_by_name = "SELECT id FROM departament WHERE genre_name = ?";

        try (Connection con = DriverManager.getConnection(connectionUrl, username, password)) {
            PreparedStatement getInt = con.prepareStatement(get_libraryId_by_name);
            getInt.setString(1, departamentName);
            try (ResultSet rs = getInt.executeQuery()) {
                if (rs.next()) {
                    int departamentId = rs.getInt("id");
                    PreparedStatement insertPstmt = con.prepareStatement(query_);
                    insertPstmt.setString(1, edition_name);
                    insertPstmt.setString(2, edition_author);
                    insertPstmt.setInt(3, edition_year);
                    insertPstmt.setInt(4, departamentId);
                    insertPstmt.executeUpdate();
                    return 1;
                } else {
                    System.out.println("departament: " + departamentName);
                    return 0;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }
        public int remove(String name) {
            String query_ = "DELETE FROM edition WHERE edition_name = ?";
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
        public String get_name_of_related_departament(String edition_name){
            String query_ = "SELECT * FROM edition WHERE edition_name = ?";
            try{
                Connection con = DriverManager.getConnection(connectionUrl, username, password);
                PreparedStatement pstmt = con.prepareStatement(query_);
                pstmt.setString(1, edition_name);
                rs = pstmt.executeQuery();

            }catch(SQLException e){
                System.out.println(e);

            }
            int id_of_departament = 0;
            try {
                while (rs.next()) {
                    id_of_departament = rs.getInt("departament_id");
                }
            }


            catch (SQLException e) {
                System.out.println(e);
            }

            String query_1 = "SELECT * FROM departament WHERE id = ?";

            try{
                Connection con = DriverManager.getConnection(connectionUrl, username, password);
                PreparedStatement pstmt = con.prepareStatement(query_1);
                pstmt.setInt(1, id_of_departament);
                rs = pstmt.executeQuery();
                try{
                    while(rs.next()){
                        String departament_name = rs.getString("genre_name");
                        return departament_name;
                    }
                }
                catch (SQLException e){
                    System.out.println(e);
                }


            }
            catch(Exception e){
                System.out.println(e);
            }
            return null;

        }
        public void update_departament(String departamentName, boolean Positive){
            String query_ = "SELECT number_of_editions FROM departament WHERE genre_name = ?";
            String query_1 = "UPDATE departament SET number_of_editions = ? WHERE genre_name = ?";
            try {
                int number_of_editions =0;
                Connection con = DriverManager.getConnection(connectionUrl, username, password);
                PreparedStatement pstmt = con.prepareStatement(query_);
                pstmt.setString(1, departamentName);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    number_of_editions = rs.getInt("number_of_editions");
                    if(Positive) {
                        number_of_editions++;
                    }
                    else if(!Positive){
                        number_of_editions--;
                    }
                }
                PreparedStatement insertPstmt = con.prepareStatement(query_1);
                insertPstmt.setInt(1, number_of_editions);
                insertPstmt.setString(2, departamentName);
                insertPstmt.executeUpdate();



            }
            catch (SQLException e) {
                System.out.println(e);

            }

        }

        public ResultSet getAll(){
            try{
                Connection con = DriverManager.getConnection(connectionUrl, username, password);
                String query = "SELECT * FROM edition";
                PreparedStatement pstmt = con.prepareStatement(query);
                rs = pstmt.executeQuery();
                return rs;
            }
            catch(Exception e){
                return null;

            }
        }
    public int getSpecific(String name){
        String query = "SELECT * FROM edition WHERE edition_name = ?";
        int number_ = 0;
        try{

            Connection con = DriverManager.getConnection(connectionUrl, username, password);
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            while(rs.next()){
                number_ = rs.getInt("edition_year");
            }
            return number_;
        }
        catch(Exception e){
            return number_;

        }

    }
    public String getSpecificAuthor(String name){
        String query = "SELECT * FROM edition WHERE edition_name = ?";
        String author_name="";
        try{

            Connection con = DriverManager.getConnection(connectionUrl, username, password);
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            while(rs.next()){
                author_name = rs.getString("edition_author");
            }
            return author_name;
        }
        catch(Exception e){
            return null;

        }

    }

    public ArrayList<String> year_return(int year){
        String query = "SELECT * FROM edition WHERE edition_year = ?";
        ArrayList<String> returning = new ArrayList<>();
        try{
            Connection con = DriverManager.getConnection(connectionUrl, username, password);
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, year);
            rs = pstmt.executeQuery();
            while(rs.next()){
                returning.add(rs.getString("edition_name"));
            }
            return returning;
        }
        catch(Exception e){
            return null;
        }
    }

    public String get_name_of_related_library(String edition_name){
        int related_library = 0;
        String query_ = "SELECT * FROM edition WHERE edition_name = ?";
        try{
            Connection con = DriverManager.getConnection(connectionUrl, username, password);
            PreparedStatement pstmt = con.prepareStatement(query_);
            pstmt.setString(1, edition_name);
            rs = pstmt.executeQuery();

        }catch(SQLException e){
            System.out.println(e);

        }
        int id_of_departament = 0;
        try {
            while (rs.next()) {
                id_of_departament = rs.getInt("departament_id");
            }
        }


        catch (SQLException e) {
            System.out.println(e);
        }

        String query_1 = "SELECT * FROM departament WHERE id = ?";

        try{
            Connection con = DriverManager.getConnection(connectionUrl, username, password);
            PreparedStatement pstmt = con.prepareStatement(query_1);
            pstmt.setInt(1, id_of_departament);
            rs = pstmt.executeQuery();
            while(rs.next()){
                related_library = rs.getInt("library_id");
            }


        }
        catch(Exception e){
            System.out.println(e);
        }
        String query_2 = "SELECT * FROM library WHERE id = ?";
        try{
            Connection con = DriverManager.getConnection(connectionUrl, username, password);
            PreparedStatement pstmt = con.prepareStatement(query_2);
            pstmt.setInt(1, related_library);
            rs = pstmt.executeQuery();
            while(rs.next()){
                String library_name = rs.getString("name");
                return library_name;
            }

        }
        catch(Exception e){
            System.out.println(e);

        }
        return null;

    }
}
