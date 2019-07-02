package finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DeletePostController extends DBConnect {

    @FXML
    TextField idInput;  //access the fx:id from the FXML

    public void deletePost(){  //create the function to delete post
        int idInt = Integer.parseInt(idInput.getText());  //create the idInput from string to integer
        deleteDataPosts(idInt);  //delete the post of that ID
        AdminHomeController.deleteStage.close();  //close the stage
    }
}
