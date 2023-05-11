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

public class MoneyTransferController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField account_no;

    @FXML
    private TextField amount_bar;

    @FXML
    private Button ok;

    @FXML
    private TextField password_bar;

    @FXML
    void ok_clicked(ActionEvent event) throws IOException, ClassNotFoundException {




        Main.pass = password_bar.getText();
        Main.delay();
        Main.moneyTransfer(account_no.getText(),amount_bar.getText(),password_bar.getText());
        Main.delay();

        System.out.print("new balance is ");
        System.out.println(User.users[User.userNo].balance);

        MiniStatementController.miniFlag=1;

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
