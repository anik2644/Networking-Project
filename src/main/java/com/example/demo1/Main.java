package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main extends Application {

    static String name ;//= "Rahim";
    static String pass ;// ="1234";

    public Main() throws IOException {
    }


    static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    static int req_error() {
        return (int) Math.floor(Math.random() * (2)) + 1;
    }

    static boolean error() {

        int num = (int) Math.floor(Math.random() * (100));

        if (num < 70) {
            delay();
            System.out.println("\nData packets sent successfully to the Server...\n");
            return true;
        } else {
            delay();
            System.out.println("\nData packets not sent to the server\nResending packets...\n");
            return false;
        }
    }

    static Socket socket;

    static {
        try {
            socket = new Socket("localhost", 5000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

   static ObjectOutputStream objectOutputStream;

    static {
        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static ObjectInputStream objectInputStream;

    static {
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    static void sendPackets() throws IOException, ClassNotFoundException {

        //Socket socket = new Socket("localhost", 5000);
        delay();
        System.out.println("Client Connected...");

        delay();
        System.out.println("c0");



        objectOutputStream.writeObject(name);
        objectOutputStream.writeObject(pass);

        System.out.println("c1");
        Object fromServer1 = objectInputStream.readObject();

        System.out.println("c2");

        if ((boolean) fromServer1 == true) {
           // delay();
            System.out.println("\nLogin Successful...");
            LoginpageController.loginFlag=1;
        }
        else {
           // delay();
            System.out.println("Login Failed! Try again...");
            //System.exit(0);
        }



        /*
        while (true) {
            if (error() == true)
                break;
        }
        */
    }


    static void hello()
    {

        System.out.println("hello");
    }

    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {

        System.out.println("Client Started...");

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);
        stage.setTitle("CSEDU Bank Ltd.");
        stage.setScene(scene);
        stage.show();

        System.out.println("Nice done");


        }

    public static void main(String[] args) throws IOException, ClassNotFoundException {


//        delay();
//        System.out.println("Client Started...");
//        // Socket socket = new Socket("10.33.2.75", 5000);
//
//      //  Socket socket = new Socket("localhost", 5000);
//
//        Scanner scanner = new Scanner(System.in);
//        delay();
//        System.out.println("Client Connected...");
//        delay();


        Main.hello();
        System.out.println("anik");

        launch();

        System.out.println("Nice done");


    }
}