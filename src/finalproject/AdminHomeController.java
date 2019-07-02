package finalproject;

import javafx.fxml.FXML;  //import necessary modules for java fx
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminHomeController extends DBConnect {  //the class extends from the class DBConnect
    public static Stage postStage;  //create a public static stage for the other pages
    public static Stage deleteStage;
    public static Stage editStage;

    @FXML
    Text content;  //accessing the fx:id from the fxml

    //create the various functions that the admin can do such as: adding, deleting, editing a post and logging out
    public void goToPost() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("add_post.fxml"));  //load the new page
        postStage = new Stage();  //create the new stage
        postStage.setTitle("BINUS ACTIVITY");  //set the title
        postStage.setScene(new Scene(root, 1280, 720));  //set the dimensions of the page
        postStage.setResizable(false);  //set the page to be not resizable
        postStage.show();  //show the stage
    }

    public void deletePost() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("delete_post.fxml"));
        deleteStage = new Stage();
        deleteStage.setTitle("BINUS ACTIVITY");
        deleteStage.setScene(new Scene(root, 1280, 720));
        deleteStage.setResizable(false);
        deleteStage.show();
    }

    public void editPost() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("edit_post_home.fxml"));
        editStage = new Stage();
        editStage.setTitle("BINUS ACTIVITY");
        editStage.setScene(new Scene(root, 1280, 720));
        editStage.setResizable(false);
        editStage.show();
    }

    public void logout() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home_page.fxml"));
        Parent root = loader.load();
        HomeController homeController = loader.getController();
        homeController.refresh();
        Main.primaryStage.setTitle("BINUS ACTIVITY");
        Main.primaryStage.setScene(new Scene(root, 1280, 720));
        Main.primaryStage.setResizable(false);
        Main.primaryStage.show();
    }

    public void refresh(){  //create the function to refresh the page
        Post.postContent = "";  //initialize that the post is an empty string
        loadTableContentAdmin();  //load the table content for admin
        content.setText(Post.postContent);  //insert each post into the empty string
    }


    public void getSeminar(){  //create a function to get the post of the same tag
        Post.postContent = "";  //initialize that the post is an empty string
        loadFilterAdmin("Seminar");  //filter and get all the post from the current tag
        content.setText(Post.postContent);  //insert the post into the empty string
    }

    public void getCampusEvent(){
        Post.postContent = "";
        loadFilterAdmin("Campus Event");
        content.setText(Post.postContent);
    }

    public void getEventCommittee(){
        Post.postContent = "";
        loadFilterAdmin("Event Committee");
        content.setText(Post.postContent);
    }

    public void getSocialHour(){
        Post.postContent = "";
        loadFilterAdmin("Social Hour");
        content.setText(Post.postContent);
    }

    public void getStudentCommittee(){
        Post.postContent = "";
        loadFilterAdmin("Student Committee");
        content.setText(Post.postContent);
    }

    public void getInfoSession(){
        Post.postContent = "";
        loadFilterAdmin("Info Session");
        content.setText(Post.postContent);
    }
}
