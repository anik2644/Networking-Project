package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
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
    private Text lbl;

    @FXML
    private Button ok;

    @FXML
    private TextField password_bar;

    @FXML
    private TextField username;

    @FXML
    void BackbuttonClicked(ActionEvent event) {

    }

    static int count =0;
    @FXML
    void ok_clicked(ActionEvent event) throws IOException, ClassNotFoundException {

        count++;
        System.out.println(username.getText());
        System.out.println(password_bar.getText());

        Main.name = username.getText();
        Main.pass = password_bar.getText();


        int fl=0 ;
        int fla =0;

        if(count<6) {
            for (int j = 0; j < 5; j++) {
                if (Main.name.equals(User.users[j].user) && Main.pass.equals(User.users[j].password)) {
                    fl = 1;
                    break;
                }
            }
            if (fl == 1) {

                fla = 1;

                delay();
                Main.sendPackets();
                Main.delay();
                if (loginFlag == 1) {
                    count = 0;
                    root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root, 500, 400);
                    stage.setScene(scene);
                    stage.show();
                }
            } else {

                lbl.setText("Wrong Password");
                System.out.println("Wrong password ...Try again");
                System.out.print("you have ");
                System.out.print(5 - count);
                System.out.print("more time left");

            }
        }

        if(count >= 5)
        {
            System.out.println("Out of Service for Access Denied");
        }



       // loginFlag =1;
    }

}
