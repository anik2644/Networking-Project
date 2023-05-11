package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangePinController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField new_pin;

    @FXML
    private Button ok;

    @FXML
    private TextField password_bar;

    @FXML
    private TextField rewrite;

    @FXML
    void ok_clicked(ActionEvent event) throws IOException, ClassNotFoundException {

        String np= new_pin.getText();
        String rw= rewrite.getText();
        Main.delay();
        if(np.equals(rw))
        {
            Main.changePassword(new_pin.getText(),password_bar.getText());
        }
        else {
            System.out.println("enter similar password");
        }

        Main.delay();

    }

    public void BackbuttonClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 500,400);
        stage.setScene(scene);
        stage.show();

    }
}
