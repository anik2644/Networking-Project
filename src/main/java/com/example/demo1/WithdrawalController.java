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

public class WithdrawalController {
    static int withdrawSuccessfullFlag=0;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField amount_bar;

    @FXML
    private Button ok;

    @FXML
    private TextField password_bar;

    @FXML
    void ok_clicked(ActionEvent event) throws IOException, ClassNotFoundException {


       // System.out.println(amount_bar.getText());
       // System.out.println(password_bar.getText());

      //  Main.name = username.getText();
        Main.pass = password_bar.getText();
        Main.delay();
        Main.wirhDrawValidation(amount_bar.getText(),password_bar.getText());
        Main.delay();



        root = FXMLLoader.load(getClass().getResource("MiniStatement.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 500,400);
        stage.setScene(scene);
        stage.show();
    }

    public void BackbuttonClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 500,400);
        stage.setScene(scene);
        stage.show();

    }
}
