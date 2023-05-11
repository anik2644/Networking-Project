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

public class DepositController {

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


        //  Main.name = username.getText();
        Main.pass = password_bar.getText();
        Main.delay();
        Main.depopsitValidation(amount_bar.getText(),password_bar.getText());
        Main.delay();

       // System.out.println("kk");
        System.out.print("new balance is ");
        System.out.println(User.users[User.userNo].balance);
        MiniStatementController.miniFlag=1;
      //  System.out.println("jj");


        root = FXMLLoader.load(getClass().getResource("MiniStatement.fxml"));

        //Scene scene = new Scene(fxmlLoader.load(), 500, 400);
       // stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        //FXMLLoader fxmlLoader = new FXMLLoader(MiniStatementController.class.getResource("MiniStatement.fxml"));
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MiniStatement.fxml"));
//
//        MiniStatementController controller = fxmlLoader.getController();
//        String textParam = "Hello, World!";
//        controller.setTextParam(textParam);
//
//


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MiniStatement.fxml"));
       // Parent miniStatementRoot = fxmlLoader.load();
        MiniStatementController controller = fxmlLoader.getController();
       // controller.setTextParam("Hello, World!");


        scene = new Scene(fxmlLoader.load(), 500, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      //  scene = new Scene(fxmlLoader.load(),root, 500,400);
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
