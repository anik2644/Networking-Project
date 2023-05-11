package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {


    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button balance_check;

    @FXML
    private Button balance_transfer;

    @FXML
    private Button cash_withdraw;

    @FXML
    private Button change_pin;

    @FXML
    private Button deposit;

    @FXML
    private Button mini_statement;

    @FXML
    void balance_check_clicked(ActionEvent event) throws IOException {

        MiniStatementController.miniFlag=2;
        root = FXMLLoader.load(getClass().getResource("MiniStatement.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 500,400);
        stage.setScene(scene);
        stage.show();


    }


    @FXML
    void LogOutClicked(ActionEvent event) throws IOException {

        MiniStatementController.miniFlag=2;
        root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 500,400);
        stage.setScene(scene);
        stage.show();


    }
    @FXML
    void balance_transfer_clicked(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("MoneyTransfer.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 500,400);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void cash_withdraw_clicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Withdrawal.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 500,400);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void change_pin_clicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Changepin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 500,400);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void deposit_clicked(ActionEvent event) throws IOException {

        Main.hello();

        root = FXMLLoader.load(getClass().getResource("Deposit.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 500,400);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void mini_statement_clicked(ActionEvent event) throws IOException {

        MiniStatementController.miniFlag=0;
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("MiniStatement.fxml"));
//        Parent root = loader.load();
//        Scene scene = new Scene(root);
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();

//        root= FXMLLoader.load(getClass().getResource("aboutus.fxml"));
//        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        scene= new Scene(root);
//        stage.setScene(scene);
//        stage.show();


        root = FXMLLoader.load(getClass().getResource("MiniStatement.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 500,400);
        stage.setScene(scene);
        stage.show();

    }

}
