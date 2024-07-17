package com.flipkart.client;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Main application class for FlipFit, which handles user login, registration,
 * and menu navigation for different roles (Customer, Gym Owner, Admin).
 */
public class FlipFitApplication {

    /**
     * Handles user login based on role (Customer, Gym Owner, Admin).
     */
    public static void login() {

        Scanner in = new Scanner(System.in);
        System.out.println("------- Login ------ ");
        System.out.println("Enter your email: ");
        String email = in.next();
        System.out.println("Enter your password: ");
        String password = in.next();
        System.out.println("Enter your role: \n1. Customer\n2. Gym owner\n3. Admin");
        int role = in.nextInt();
        if(role == 1) {
                FlipFitCustomerMenu.main(null);
        } else if(role == 2) {
                FlipFitOwnerMenu.main(null);
        } else if(role == 3) {
                FlipFitAdminMenu.main(null);
        }  else {
            System.out.println("Invalid role choice");
        }
    }

    public static void registerUser() {


        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the FlipFit. Please Register yourself Here");
        System.out.println("Enter your name: ");
        String userName = in.nextLine();
        System.out.println("Enter your phone number: ");
        String userPhoneNumber = in.next();
        System.out.println("Enter your email: ");
        String userEmail = in.next();
        System.out.println("Enter 1 to register as Gym Owner \nEnter 2 to register as Customer\n");
        int role = in.nextInt();
        if(role == 0){
            System.out.println("Enter your Aadhar NUmber : ");
            String ownerAadhaar = in.next();

        } else if(role == 1){
            System.out.println("Enter your address: ");
            String temp = in.nextLine();
            String address = in.nextLine();
        }
        System.out.println("Enter your password: ");
        String password = in.next();
        System.out.println("Enter your confirm password: ");
        String confirmUserPassword = in.next();
        if(password.equals(confirmUserPassword)) {
            System.out.println("Congratulations! You've successfully registered with us");
        }
        else{
            System.out.println("The Passwords did not match. Please check again");
        }
    }


    public static void main(String[] args){

        System.out.println("--------Welcome to FlipFit Application--------");
        System.out.println("Enter preferred choices: \n1. Login\n2. Register \n3. Change Password\n4. Exit");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch(choice) {
            case 1:
                login();
                break;
            case 2:
                registerUser();
                break;
            case 3:
                System.out.println("This is Change Password Function");
                break;
            case 4:
                System.out.println("Thank you for using FlipFit App");
                in.close();
                break;
            default:
                System.out.println("Invalid choice");
        }
        in.close();
    }
}