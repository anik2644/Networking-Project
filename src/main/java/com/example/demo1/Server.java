package com.example.demo1;

import java.net.*;
import java.io.*;

public class Server {
//    String user;
//    String password;
//    int balance;
//
//    Server(String user, String password, int balance) {
//        this.user = user;
//        this.password = password;
//        this.balance = balance;
//    }

//    public void setBalance(int newBalance) {
//        this.balance = newBalance;
//    }
//
//    public int getBalance() {
//        return this.balance;
//    }

//    public String checkBalance() {
//        return "Your current balance is: " + getBalance() + " taka";
//    }
//
//    public void credit(int value) {
//        setBalance(getBalance() + value);
//    }
//
//    public boolean debit(int value) {
//        if (getBalance() >= value) {
//            setBalance(getBalance() - value);
//            return true;
//        } else
//            return false;
//    }

    public static void main(String args[]) throws IOException {






//        User.users[0] = new User("Rahim", "1234", 50000);
//        User.users[1] = new User("Karim", "1234", 60000);
//        User.users[2] = new User("Rafiq", "1234", 40000);

        delay();

        System.out.println("Server started");

        delay();

        System.out.println("Waiting for Clients...");

        ServerSocket serverSocket = new ServerSocket(5000);
        Socket socket = serverSocket.accept();
        delay();
        System.out.println("Client Accepted");
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        try {

            int flag=0;
            int fl =0;

            while(flag==0)
            {
                Object cMsg1 = ois.readObject();
                Object cMsg2 = ois.readObject();

                String Name = (String) cMsg1;
                String Pass = (String) cMsg2;
                System.out.println("this is server");

                for (int i = 0; i < 3; i++) {
                    if (Name.equals(User.users[i].user) && Pass.equals(User.users[i].password))
                    {
                        oos.writeObject("true");
                        User.userNo = i;
                        flag =1;
                        fl=1;
                        break;
                    }
                    else
                    {
                     continue;
                    }

                }
                if(fl==0)
                {
                    oos.writeObject("false");
                }

                System.out.println("s5");
            }

            while (true) {
                Object cMsg3 = ois.readObject();
                String command = (String) cMsg3;
              //  System.out.println(command + "  user name");
//                System.out.println(userNo);
                if (User.userNo >= 0) {
                    if (command.equals("c")) {

                        System.out.println("deposit section");

                        Object cMsg4 = ois.readObject();
                        String amount = (String) cMsg4;
                        int requestedMoney = Integer.parseInt(amount);

                            System.out.println(requestedMoney);
                            oos.writeObject("tr");
                            delay();
                            oos.writeObject(requestedMoney);
                            System.out.print("new balance is ");
                            System.out.println(User.users[User.userNo].balance+requestedMoney);
                            System.out.println("Deposit done");

                    }

                    else if (command.equals("d")) {

                        //sendPackets();
                        System.out.println("d section");

                     //   oos.writeObject("Enter amount to be debited:\n");

                        Object cMsg4 = ois.readObject();
                        String amount = (String) cMsg4;
                        int requestedMoney = Integer.parseInt(amount);

                        System.out.println(requestedMoney);

                        if(requestedMoney>User.users[User.userNo].balance)
                        {
                            oos.writeObject("false");
                        }
                        else {

                            User.users[User.userNo].balance-=requestedMoney;
                            oos.writeObject("true");


                            System.out.print("new balance is ");
                            System.out.println(User.users[User.userNo].balance);
                            System.out.println("hi");
                        }
                         /*
                        if (requestedMoney == 1) {
                            Object cMsg5 = ois.readObject();
                            int value = (int) cMsg5;

                            sendPackets();

                            if (users[userNo].debit(value) == true)
                                oos.writeObject("Your account has been debited by " + value + " taka\n"
                                        + users[userNo].checkBalance());
                            else
                                oos.writeObject("Insufficient Balance\n" + users[userNo].checkBalance());

                        } else if (requestedMoney == 2) {
                            Object cMsg5 = ois.readObject();
                            int value = (int) cMsg5;

                            Object cMsg6 = ois.readObject();
                            int value1 = (int) cMsg6;

                            sendPackets();

                            if (users[userNo].debit(value) == true)
                                oos.writeObject("Your account has been debited by " + value + " taka\n"
                                        + users[userNo].checkBalance());
                            else
                                oos.writeObject("Insufficient Balance\n" + users[userNo].checkBalance());
                        }
                        */
                    }

                    else if (command.equals("cp")) {

                        System.out.println("change password section");

                        Object cMsg4 = ois.readObject();
                        String newPassword = (String) cMsg4;
                        System.out.print("Password to set: ");
                        System.out.println(newPassword);

                            //User.users[User.userNo].password = newPassword;
                        oos.writeObject("true");
                        delay();
                        oos.writeObject(newPassword);
                        System.out.println("Password set done");
                    }


                    else if (command.equals("q")) {

                        sendPackets();

                        oos.writeObject("Log Out Successful...\n");

                        delay();

                        System.out.println("System shutting down...\n");

                        break;
                    } else if (command.equals("b")) {

                        sendPackets();

                      //  oos.writeObject(users[userNo].checkBalance());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static boolean error() {

        int num = (int) Math.floor(Math.random() * (100));

        if (num < 70) {
            delay();
            System.out.println("\nData packets sent successfully to the Client...\n");
            return true;
        } else {
            delay();
            System.out.println("\nData packets not sent to the Client\nResending packets...\n");
            return false;
        }
    }

    static void sendPackets() {
        while (true) {
            if (error() == true)
                break;
        }
    }

    static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}