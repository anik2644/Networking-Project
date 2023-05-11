package com.example.demo1;

public class User {

    static User[] users ={
            new User("Rahim", "1234", 50000),
            new User("Karim", "1234", 60000),
            new User("Rafiq", "1234", 40000)
};


    static void Deposit(int requestedMoney)
    {
        User.users[userNo].balance = User.users[User.userNo].balance + requestedMoney;
    }
    static void Withdraw(int withdrawMoney)
    {
        User.users[userNo].balance = User.users[User.userNo].balance - withdrawMoney;
    }
    static void ChangePassword(String newPassword)
    {
        User.users[userNo].password = newPassword;
    }
    //new User[3];
    static int userNo = 0;
    String user;
    String password;
    int balance;
    User(String user, String password, int balance) {
        this.user = user;
        this.password = password;
        this.balance = balance;
    }


}
