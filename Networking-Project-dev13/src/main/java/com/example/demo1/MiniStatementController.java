package com.example.demo1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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

    static int miniFlag=0;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label label;

    private StringProperty textParam = new SimpleStringProperty();
    public void initialize() {
        label.textProperty().bind(textParam);
    }
    public void setTextParam(String textParam) {
        this.textParam.set(textParam);
    }
    @FXML
    static String textPara;

    @FXML
    private Button ok;

    @FXML
    private Button print;

    @FXML
    void ok_check_clicked(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 500,400);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void print_clicked(ActionEvent event) {


        if(miniFlag == 1)
        {
            int balance =User.users[User.userNo].balance;
            String st= "New balance is: "+ balance;
             setTextParam(st);
        }
       else if(miniFlag == 4)
        {
            int balance =User.users[User.userNo].balance;
            String s= "Balance Transfer Successful \n to the Account:\n" +MoneyTransferController.toUser;
            String st= s+ "\nNew balance is: "+ balance;
            setTextParam(st);
        }
        else if(miniFlag == 0)
        {
            int balance =User.users[User.userNo].balance;
            String st= "Name: "+ User.users[User.userNo].user + "\n Address: Dhaka\n"+
                    "Balance: "+balance;
            setTextParam(st);
        }
        else if(miniFlag == 2)
        {
            int balance =User.users[User.userNo].balance;
            String name =User.users[User.userNo].user;
            String st= name + "  balance is: "+ balance;
            setTextParam(st);
        }
    }

    public void BackbuttonClicked(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 500,400);
        stage.setScene(scene);
        stage.show();

    }
}
