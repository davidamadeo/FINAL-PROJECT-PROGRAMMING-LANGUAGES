package finalproject;

import javafx.fxml.FXML;  //import all the necessary modules for java fx
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;

public class EditPostController extends DBConnect {

    @FXML
    TextArea authorText;  //access all the fx:id from the FXML

    @FXML
    TextArea titleText;

    @FXML
    TextArea bodyText;

    @FXML
    MenuButton tagSelect;


    String tag = "";  //initialize the tag string to be an empty string
    int id;

    public void getSeminar(){  //create the function to get each of the tag
        tag = "Seminar";  //name of the tag
    }

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

    public void editPost() {  //create the function to edit the post
        updateTitle(titleText.getText(), id);  //update each of the post details with the specific id
        updateTag(tag, id);
        updateAuthor(authorText.getText(), id);
        updateBody(bodyText.getText(), id);
        EditPostHomeController.editStage.close();  //close the stage
    }

    public void setAuthorText(String authorText)  //create the function to set the details of the post
    {
        this.authorText.setText(authorText);  //set the text as the new text filled
    }

    public void setTitleText(String titleText) {
        this.titleText.setText(titleText);
    }

    public void setBodyText(String bodyText) {
        this.bodyText.setText(bodyText);
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setId(int id) {
        this.id = id;
    }
}
