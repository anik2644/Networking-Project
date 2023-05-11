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

    static int count=0;
    @FXML
    void ok_clicked(ActionEvent event) throws IOException, ClassNotFoundException {




        int fl=0 ;
        int fla =0;
        count++;

        if(count<10) {
            for (int j = 0; j < 5; j++) {
                if ( password_bar.getText().equals(User.users[User.userNo].password)) {
                    fl = 1;
                    break;
                }
            }
            if (fl == 1) {

                fla = 1;


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



                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MiniStatement.fxml"));
                // Parent miniStatementRoot = fxmlLoader.load();
                MiniStatementController controller = fxmlLoader.getController();
                // controller.setTextParam("Hello, World!");


                scene = new Scene(fxmlLoader.load(), 500, 400);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } else {

                //lbl.setText("Wrong Password");
                System.out.println("Wrong password ...Try again");
                System.out.print("you have ");
                System.out.print(10 - count);
                System.out.print("more time left");

            }
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
