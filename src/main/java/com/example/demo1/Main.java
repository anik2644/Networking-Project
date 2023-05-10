package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


    static void hello()
    {

        System.out.println("hello");
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);
        stage.setTitle("CSEDU Bank Ltd.");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        Main.hello();
        System.out.println("anik");

        launch();
    }
}