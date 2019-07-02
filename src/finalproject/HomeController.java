package finalproject;

import javafx.fxml.FXML;  //import the necessary modules for java fx
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HomeController extends DBConnect {

    @FXML
    Text content;  //access the fx:id from the FXML

    @FXML
    TextField userNameInput;

    @FXML
    PasswordField passwordInput;

    @FXML
    Text validationText;

    public void tryLogin() {
        int counter = adminLogin(userNameInput.getText(), passwordInput.getText());  //enter the user inputs into the adminLogin()

        if (counter == 9) {  //if the user inputs the wrong username
            userNameInput.setText("");  //set the text fields as empty
            passwordInput.setText("");
            validationText.setText("WRONG USERNAME !");  //print out this message
        }

        else if (counter == 8) {  //if the user inputs the wrong password
            userNameInput.setText("");  //set the text fields as empty
            passwordInput.setText("");
            validationText.setText("WRONG PASSWORD !");  //print out this message
        }

        else if (counter == 7){  //if the user inputs the wrong password and username
            userNameInput.setText("");  //set the text fields as empty
            passwordInput.setText("");
            validationText.setText("WRONG LOGIN !");  //print out this message
        }
    }

    public void refresh(){  //create the function to refresh the page
        Post.postContent = "";  //initialize that the post is an empty string
        loadTableContent();  //load the table content
        content.setText(Post.postContent);  //insert each post into the empty string
    }

    public void getSeminar(){  //create a function to get the post of the same tag
        Post.postContent = "";  //initialize that the post is an empty string
        loadFilterAdmin("Seminar");  //filter and get all the post from the current tag
        content.setText(Post.postContent);  //insert the post into the empty string
    }

    public void getCampusEvent(){
        Post.postContent = "";
        loadFilter("Campus Event");
        content.setText(Post.postContent);
    }

    public void getEventCommittee(){
        Post.postContent = "";
        loadFilter("Event Committee");
        content.setText(Post.postContent);
    }

    public void getSocialHour(){
        Post.postContent = "";
        loadFilter("Social Hour");
        content.setText(Post.postContent);
    }

    public void getStudentCommittee(){
        Post.postContent = "";
        loadFilter("Student Committee");
        content.setText(Post.postContent);
    }

    public void getInfoSession(){
        Post.postContent = "";
        loadFilter("Info Session");
        content.setText(Post.postContent);
    }
}
