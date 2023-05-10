package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MiniStatementController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label label;

    @FXML
    private Button ok;

    @FXML
    private Button print;

    @FXML
    void ok_check_clicked(ActionEvent event) {

    }

    @FXML
    void print_clicked(ActionEvent event) {

    }

    public void BackbuttonClicked(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 500,400);
        stage.setScene(scene);
        stage.show();

    }
}
