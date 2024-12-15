package com.deepak.sharma;

import com.deepak.sharma.entities.User;
import com.deepak.sharma.services.UserBookingService;
import com.deepak.sharma.util.UserServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running Train Ticket Booking System");
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        UserBookingService userBookingService;
        try{
            userBookingService = new UserBookingService();

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        while(option != 7){
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Book Ticket");
            System.out.println("4. Cancel Ticket");
            System.out.println("5. Print Ticket");
            System.out.println("6. Print Ticket History");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");
            option = scanner.nextInt();
            switch (option){
                case 1:
                    System.out.println("Enter your name: ");
                    String name = scanner.next();
                    System.out.println("Enter your password: ");
                    String password = scanner.next();
                    User user = new User(UUID.randomUUID().toString(), name, password, UserServiceUtil.hashPassword(password), new ArrayList<>());
                    Boolean status = userBookingService.signUp(user);
                    if(status){
                        System.out.println("User registered successfully");
                    } else {
                        System.out.println("User registration failed");
                    }
                    break;
                case 2:
                    System.out.println("Enter your name: ");
                    String loginName = scanner.next();
                    System.out.println("Enter your password: ");
                    String loginPassword = scanner.next();
                    user = new User(UUID.randomUUID().toString(), loginName, loginPassword, UserServiceUtil.hashPassword(loginPassword), new ArrayList<>());
                    status = userBookingService.loginUser(user);
                    if(status){
                        System.out.println("User logged in successfully");
                    } else {
                        System.out.println("User login failed");
                    }

                    break;
                case 3:
                    System.out.println("Fetching your booking");
                    userBookingService.fetchBooking();
                    break;
                case 4:
                    System.out.println("Enter ticket id to cancel");
                    String ticketId = scanner.next();
                    status = userBookingService.cancelBooking(ticketId);
                    if (status){
                        System.out.println("Ticket cancelled successfully");
                    } else {
                        System.out.println("Ticket cancellation failed");
                    }
                    break;
                case 5:
                    userBookingService.printTicket();
                    break;
                case 6:
                    userBookingService.printTicketHistory();
                    break;
                case 7:
                    System.out.println("Exiting the system");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}