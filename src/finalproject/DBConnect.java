package finalproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.sql.*;
import java.util.ArrayList;

public class DBConnect {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    DBConnect() {
        try {  //in-capsulate the function into a try and catch

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://zefryuuko.ga/final", "david", "Password123");
            st = con.createStatement();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList getPost(int id)
    {
        String query = "select * from posts where id = " + id;
        System.out.println(query);
        ArrayList result = new ArrayList();
        result.add(id);
        try {  //in-capsulate the function into a try and catch
            rs = st.executeQuery(query);
            while (rs.next()) {
                String ID = rs.getString("id");
                String title = rs.getString("Title");
                String body = rs.getString("Body");
                String author = rs.getString("Author");
                String tag = rs.getString("Tag");
                String date = rs.getString("Date");

                Post post = new Post(title, body, author, tag, date);
                result.add(post);
                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("null");
        return null;
    }

    void deleteDataPosts(int x) {
        String sql = String.format("delete from posts where id = %d", x);  //from the table posts database sql, delete
        //a specific id
        try {  //in-capsulate the function into a try and catch
            st = con.createStatement();  //create the statement of deletion
            st.executeUpdate(sql);  //execute the deletion
            System.out.println("Row Deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void updateBody(String body, int id) {
        String query = String.format("update posts set Body = '%s' where id = %d", body, id);  //from the table posts
        //database sql, update the body at a specific id
        try {  //in-capsulate the function in a try and catch
            st = con.createStatement();  //create the update statement
            st.executeUpdate(query);  //execute the update

            System.out.println("Database Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void updateTitle(String title, int id) {
        String query = String.format("update posts set Title = '%s' where id = %d", title, id);  //from the table posts
        //database sql, update the title at a specific id
        try {  //in-capsulate the function into a try and catch
            st = con.createStatement();  //create the update statement
            System.out.println(query);
            st.executeUpdate(query);  //execute the update

            System.out.println("Database Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void updateTag(String tag, int id) {
        String query = String.format("update posts set Tag = '%s' where id = %d", tag, id);  //from the table posts
        //database sql, update the tag at a specific id
        try {  //in-capsulate the function into a try and catch
            st = con.createStatement();  //create the update statement
            st.executeUpdate(query);  //execute the update

            System.out.println("Database Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void updateAuthor(String author, int id) {
        String query = String.format("update posts set Author = '%s' where id = %d", author, id);  //from the table posts
        //database sql, update the author at a specific id
        try {  //in-capsulate the function into a try and catch
            st = con.createStatement();  //create the update statement
            st.executeUpdate(query);  //execute the update

            System.out.println("Database Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int adminLogin(String username, String password) {
        int counter = 0;
        String query = "select * from users where id = 1";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            rs = statement.executeQuery();

            // PRINTING DATA
            while (rs.next()) {

                if (rs.getString("username").equals(username) && rs.getString("password").equals(password)) {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_home_page.fxml"));
                    Parent root = loader.load();
                    AdminHomeController adminHomeController = loader.getController();
                    adminHomeController.refresh();
                    Main.primaryStage.setTitle("BINUS ACTIVITY");
                    Main.primaryStage.setScene(new Scene(root, 1280, 720));
                    Main.primaryStage.setResizable(false);
                    Main.primaryStage.show();
                    counter = 10;
                }
                else if (!rs.getString("username").equals(username) && rs.getString("password").equals(password)){
                    counter=  9;
                }
                else if (!rs.getString("password").equals(password) && rs.getString("username").equals(username)){
                    counter = 8;
                }
                else if (!(rs.getString("username").equals(username) && rs.getString("password").equals(password))){
                    counter = 7;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return counter;
    }

    public void insertToTable(String title , String body , String author , String tag, String date){
        String sql = String.format("insert into posts(title, body, author, tag , date) VALUES('%s', '%s', '%s', '%s', '%s')",
                title, body, author, tag, date);  //inserting the details of the posts into the table posts database sql

        try {  //in-capsulate the function into a try and catch
            st = con.createStatement();  //create the statement
            st.executeUpdate(sql);  //execute the statement
            System.out.println("Data Inserted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadTableContent(){
        String query = "select * from posts order by `id` DESC";  //select from table posts in database sql
        try {  //in-capsulate into try and catch
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            // PRINTING DATA
            while (rs.next()) {
                String title = rs.getString("title");  //get the string of each of the post details and assign
                String body = rs.getString("body");    //a variable to each of them
                String author = rs.getString("author");
                String tag = rs.getString("tag");
                String date = rs.getString("date");

                String postString = String.format("\n%-40s%n%255s%n%-20s%n%n%-20s%n%n%-20s%n%n%n", title, date, author, body, tag);
                //print out in format on the window, the details of the post without the id
                Post.postContent += postString;  //add the details postString into the empty string postContent
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadTableContentAdmin(){  //similar to the loadTableContent function but this function prints out the id
        //just for the admin page so that they know which they'd like to delete or edit
        String query = "select * from posts order by `id` DESC";
        try {
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            // PRINTING DATA
            while (rs.next()) {
                String ID = rs.getString("id");
                String title = rs.getString("title");
                String body = rs.getString("body");
                String author = rs.getString("author");
                String tag = rs.getString("tag");
                String date = rs.getString("date");

                String postString = String.format("\n%s%n%-40s%n%255s%n%-20s%n%n%-20s%n%n%-20s%n%n%n", ID, title, date, author, body, tag);
                Post.postContent += postString;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void loadFilter(String tag){  //this function enables users to see all the post of the same tag
        String query = String.format("select * from posts where tag = '%s' " , tag);  //select posts from table posts database
        //in sql where there is a specific tag
        try {  //in-capsulate function into a try and catch
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            while (rs.next()) {
                String title = rs.getString("title");  //get the string of each of the post details and assign
                String body = rs.getString("body");    //a variable to each of them
                String author = rs.getString("author");
                String tag1 = rs.getString("tag");
                String date = rs.getString("date");

                String postString = String.format("\n%-40s%n%255s%n%-20s%n%n%-20s%n%n %-20s%n%n%n", title, date, author, body, tag);
                //print out in format on the window, the details of the post without the id
                Post.postContent += postString;  //add the details postString into the empty string postContent
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadFilterAdmin(String tag){  //similar to the loadFilter function but this function prints out the id
        //just for the admin page so that they know which they'd like to delete or edit
        String query = String.format("select * from posts where tag = '%s' " , tag);
        try {
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            // PRINTING DATA
            while (rs.next()) {
                String ID = rs.getString("id");
                String title = rs.getString("title");
                String body = rs.getString("body");
                String author = rs.getString("author");
                String tag1 = rs.getString("tag");
                String date = rs.getString("date");

                String postString = String.format("\n%s%n %-40s%n%255s%n%-20s%n%n%-20s%n%n%-20s%n%n%n", ID, title, date, author, body, tag);
                Post.postContent += postString;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}