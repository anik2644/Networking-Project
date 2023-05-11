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
    static String currentPassword;

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

    static void changePassword(String newPpassord, String password) throws IOException, ClassNotFoundException {

        //Socket socket = new Socket("localhost", 5000);
        delay();
        System.out.println("change pin...");
        delay();

        if(password.equals(User.users[User.userNo].password))
        {
            objectOutputStream.writeObject("cp");
            objectOutputStream.writeObject(newPpassord);
            Object fromServer1 = objectInputStream.readObject();
            String check = (String) fromServer1;

            if (check.equals("true")) {

                Object rm = objectInputStream.readObject();
                String  newPassword = (String) rm;
                User.ChangePassword(newPassword);
                System.out.println("\nChange Password done ...");

            }
            else {
                WithdrawalController.withdrawSuccessfullFlag =0;
                System.out.println("Operation not successsful! Try again...");
            }
        }
        else {
            System.out.println("Wrong password");
        }
    }
    static void depopsitValidation(String amount, String password) throws IOException, ClassNotFoundException {

        System.out.println("Deposit validation check...");
        delay();

        if(password.equals(User.users[User.userNo].password))
        {

            System.out.print("deposit request for amount: ");
            System.out.println(amount);


            objectOutputStream.writeObject("c");
            objectOutputStream.writeObject(amount);

            Object fromServer1 = objectInputStream.readObject();
            String check = (String) fromServer1;

            if (check.equals("tr")) {

                WithdrawalController.withdrawSuccessfullFlag =1;

                Object rm = objectInputStream.readObject();
                int requestedMoney = (int) rm;
                User.Deposit(requestedMoney);
                System.out.println("\nMoney depost done...");
            }
            else if (check.equals("false")) {
                WithdrawalController.withdrawSuccessfullFlag =0;
                System.out.println("Not valid! Try againn...");
            }


        }
        else {
            System.out.println("Wrong password");
        }


    }

    static void wirhDrawValidation(String amount, String password) throws IOException, ClassNotFoundException {

        System.out.println("Withdraw validation...");
        delay();

        if(password.equals(User.users[User.userNo].password))
        {

            objectOutputStream.writeObject("withdraw");

            objectOutputStream.writeObject(amount);


            Object fromServer1 = objectInputStream.readObject();
            String check = (String) fromServer1;

            if (check.equals("true")) {

                Object rm = objectInputStream.readObject();
                int requestedMoney = (int) rm;
                User.Withdraw(requestedMoney);
                WithdrawalController.withdrawSuccessfullFlag =1;
                System.out.println("\nMoney withdraw done...");

            }
            else if (check.equals("false"))
            {
                System.out.println("You don't have sufficient money...");
            }
            else {
                // delay();
                WithdrawalController.withdrawSuccessfullFlag =0;
                System.out.println("Not valid! Try again...");
                //System.exit(0);
            }


        }
        else {
            System.out.println("Wrong password");
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
        String fs = (String) fromServer1;

        if (fs.equals("true") ) {
           // delay();
            System.out.println("\nLogin Successful...");
            LoginpageController.loginFlag=1;
            currentPassword= pass;
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
        MiniStatementController.textPara ="hello world";

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