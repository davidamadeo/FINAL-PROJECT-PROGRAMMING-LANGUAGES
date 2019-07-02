package finalproject;

import javafx.fxml.FXML;  //import all the necessary modules for java fx
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class EditPostHomeController extends DBConnect {
    public static Stage editStage;  //create a public static stage called the editStage

    @FXML
    TextField idInput;  //access the fx:id from the FXML

    public void editPost1() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("edit_post.fxml"));  //load the new page into
        //a variable called loader

        Parent root = loader.load();  //load the page
        EditPostController editPostController = loader.getController();
        ArrayList postData = getPost(Integer.parseInt(idInput.getText()));  //get the post from the id
        Post post = (Post) postData.get(1);

        editPostController.setAuthorText(post.getAuthor());  //set all the post details into the post
        editPostController.setTitleText(post.getTitle());
        editPostController.setBodyText(post.getBody());
        editPostController.setTag(post.getTag());
        editPostController.setId((int) postData.get(0));

        editStage = new Stage();  //create a new stage called editStage
        editStage.setTitle("BINUS ACTIVITY");  //set the title
        editStage.setScene(new Scene(root, 1280, 720));  //set the dimensions of the window
        editStage.setResizable(false);  //set so that the window cannot be resized
        editStage.show();  //show the stage
        AdminHomeController.editStage.close();  //close the stage
    }
}
