package finalproject;

import javafx.fxml.FXML;  //import necessary modules for java fx
import javafx.scene.control.TextArea;
import java.time.format.DateTimeFormatter;  //import modules for current date
import java.time.LocalDate;

public class AddPostController extends DBConnect {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  //create the pattern for the current local date
    LocalDate localDate = LocalDate.now();  //specify that it is the current date

    String tag = "";
    String date = dtf.format(localDate);  //create a variable to assign the local date

    @FXML
    TextArea authorText;  //access the the fx:id from the FXML
    @FXML
    TextArea titleText;
    @FXML
    TextArea bodyText;

    public void addPost(){  //create the add post function
        insertToTable(titleText.getText() , bodyText.getText() , authorText.getText() , tag, date);  //insert the details of the post
        //into the database
        AdminHomeController.postStage.close();  //close the stage
    }

    public void getSeminar(){
        tag = "Seminar";
    }  //create function to get each and every tag from the posts

    public void getCampusEvent(){
        tag = "Campus Event";
    }

    public void getEventCommittee(){
        tag = "Event Committee";
    }

    public void getSocialHour(){
        tag = "Social Hour";
    }

    public void getStudentCommittee(){
        tag = "Student Committee";
    }

    public void getInfoSession(){
        tag = "Info Session";
    }
}
