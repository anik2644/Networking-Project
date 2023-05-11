package com.example.demo1;

public class User {

    static User[] users ={
            new User("Rahim", "1234", 50000),
            new User("Karim", "1234", 60000),
            new User("Anik", "11556", 10000),
//            new User("Nafisa", "2645", 420),
//            new User("Mahmud", "15865", 7000)
};


    static void Deposit(int requestedMoney)
    {
        User.users[userNo].balance = User.users[User.userNo].balance + requestedMoney;
    }
    static void Withdraw(int withdrawMoney)
    {
        User.users[userNo].balance = User.users[User.userNo].balance - withdrawMoney;
    }

    static void transfer(int requestedMoney,String account) {

        int toUser=2;
        String name;
        int flag =0;
        User.users[userNo].balance = User.users[User.userNo].balance - requestedMoney;
        for (int i = 0; i < 3; i++) {
            name= User.users[i].user;
            if (name.equals(account))
            {
                toUser = i;
                flag=1;
                break;
            }
        }
        if (flag==0)
        {
            System.out.println("your account no is wrong");
        }
        else {
            User.users[toUser].balance = User.users[toUser].balance + requestedMoney;
            System.out.println(toUser);
        }
    }
    static void ChangePassword(String newPassword)
    {
        User.users[userNo].password = newPassword;
    }
    //new User[3];
    static int userNo;
    String user;
    String password;
    int balance;
    User(String user, String password, int balance) {
        this.user = user;
        this.password = password;
        this.balance = balance;
    }



}
