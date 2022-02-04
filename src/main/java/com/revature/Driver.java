package com.revature;

import com.revature.models.Reimbursement;
import com.revature.repositories.UserDAO;
import com.revature.models.User;
import com.revature.services.UserService;

import java.util.List;
import java.util.Scanner;

public class Driver {

    private static Scanner scanner = new Scanner(System.in);
    public static UserService userService = new UserService();
    private static UserDAO userDAO = new UserDAO();


    public static void main(String[] args) {
        List<User> users = userDAO.getAll();
        System.out.println(users);





    }
}
