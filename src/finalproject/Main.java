package finalproject;

import javafx.application.Application;  //import all the necessary modules for java fx
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage primaryStage;  //create a public static stage called primaryStage as the main stage

    @Override
    public void start(Stage primaryStage) {  //create a start function that will override the start function from
        //the class Application in the package javafx.application
        this.primaryStage = primaryStage;
        try{                                 //in-capsulate the start function inside a try and catch
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home_page.fxml"));  //load the new page into
            //a variable called loader
            Parent root = loader.load();  //load the page
            HomeController homeController = loader.getController();
            homeController.refresh();
            primaryStage.setTitle("BINUS ACTIVITY");  //set the title
            primaryStage.setScene(new Scene(root, 1280, 720));  //set the window dimensions
            primaryStage.setResizable(false);  //set the page so it cannot be resized
            primaryStage.show();  //show the page
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);  //launch the argument that was stated in the beginning
    }

}
