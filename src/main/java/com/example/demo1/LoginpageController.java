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

public class LoginpageController {

    static int loginFlag =0;
    private Stage stage;
    private Scene scene;
    private Parent root;

    static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button backbutton;

    @FXML
    private Button ok;

    @FXML
    private TextField password_bar;

    @FXML
    private TextField username;

    @FXML
    void BackbuttonClicked(ActionEvent event) {

    }

    @FXML
    void ok_clicked(ActionEvent event) throws IOException, ClassNotFoundException {

        System.out.println(username.getText());
        System.out.println(password_bar.getText());

        Main.name = username.getText();
        Main.pass = password_bar.getText();
        delay();
        Main.sendPackets();
        Main.delay();
        if(loginFlag==1)
        {
            root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root, 500,400);
            stage.setScene(scene);
            stage.show();
        }


       // loginFlag =1;
    }

}
