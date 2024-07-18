package com.flipkart.client;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.User;

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
        System.out.println("Enter your Email: ");
        String email = in.next();
        System.out.println("Enter your Password: ");
        String password = in.next();
        System.out.println("Enter your role: \n1. Customer\n2. Gym owner\n3. Admin");
        int role = in.nextInt();
        if(role == 1) {
                FlipFitCustomerMenu.login(email, password);
        } else if(role == 2) {
                FlipFitGymOwnerMenu.main(null);
        } else if(role == 3) {
                FlipFitAdminMenu.main(null);
        }  else {
            System.out.println("Invalid role choice");
        }
    }

    public static void registerUser() {

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the FlipFit. Please Register yourself Here");
        System.out.println("Enter your Email: ");
        String email = in.next();
        String password;
        boolean flag = true;
        do{
            System.out.println("Enter your password: ");
            password = in.next();
            System.out.println("Enter your confirm password: ");
            String confirmUserPassword = in.next();
            if(password.equals(confirmUserPassword)) {
                System.out.println("Password matched!");
                flag = false;
            }
            else{
                System.out.println("The Passwords did not match. Please check again");
            }
        }while(flag);
        System.out.println("Enter 1 to register as Gym Owner \nEnter 2 to register as Customer");
        int role = in.nextInt();
        if(role == 1){
            System.out.println("Enter your Name: ");
            String ownerName = in.next();
            System.out.println("Enter your Phone Number: ");
            String ownerPhone = in.next();
            System.out.println("Enter your Address: ");
            String ownerAddress = in.nextLine();
            System.out.println("Enter your GST Number: ");
            String ownerGstNum = in.next();
            System.out.println("Enter your PAN Number: ");
            String ownerPanNum = in.next();
            User user = new User(0, email, password, 2);
            FlipFitGymOwner owner = new FlipFitGymOwner(ownerName, ownerPhone, ownerAddress, ownerGstNum, ownerPanNum, "Waiting for approval", 0);;
        } else if(role == 2){
            System.out.println("Enter your Name: ");
            String customerName = in.next();
            System.out.println("Enter your Phone Number: ");
            String customerPhone = in.next();
            System.out.println("Enter your Age: ");
            int age = Integer.parseInt(in.next());
            System.out.println("Enter your Gender: ");
            String gender = in.next();
            System.out.println("Enter your Weight: ");
            int weight = Integer.parseInt(in.next());
            System.out.println("Enter your address: ");
            String customerAddress = in.next();
            User user = new User(0, email, password, 3);
            FlipFitCustomer customer = new FlipFitCustomer(weight, age, gender, customerName, customerPhone, customerAddress, 0);
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