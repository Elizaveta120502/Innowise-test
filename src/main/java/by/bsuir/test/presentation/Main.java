package by.bsuir.test.presentation;


import by.bsuir.test.entity.User;
import by.bsuir.test.exception.InvalidDataException;
import by.bsuir.test.logic.impl.*;
import by.bsuir.test.validator.Validator;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int firstNumber = 0;
        int secondNumber = 0;
        int temp = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("You are logged into the user account program." +
                "\n" +
                "To get started you need to select the option that you want to use" +
                "\n");

        while (firstNumber != 6) {
            System.out.println(
                    "1.Create user." +
                    "\n" +
                    "(it is possible to specify from 1 to 3 phones)" +
                    "\n" +
                    "2.Delete user" +
                    "\n" +
                    "(you will need to specify name and surname of user)" +
                    "\n" +
                    "3.Edit user information" +
                    "\n" +
                    "(you can edit all data and separately phones or roles " +
                    "\n" +
                    "4.View all users" +
                    "\n" +
                    "5.Find user" +
                    "\n" +
                    "(you will need to specify email of desired user" +
                     "\n" +
                    "6.Exit");

            if (sc.hasNextInt()) {
                firstNumber = sc.nextInt();
                while (firstNumber > 6 || firstNumber < 1) {
                    System.out.println("Invalid input.Try again");
                    firstNumber = sc.nextInt();
                }
            }

            switch (firstNumber) {
                case 1:
                    try {
                        InputOutputDataHandler.getInstance().write(CreateUser.getInstance().createUser());

                    } catch (IOException e) {
                        System.out.println("Something wrong with input or output");
                    } catch (InvalidDataException e) {
                        e.getMessage();
                    }
                    break;
                case 2:
                    System.out.println("To delete user enter user's id. " +
                            "To find user's id you can choose number 4");
                    int id = 0;
                    if (sc.hasNextInt()) {
                        id = sc.nextInt();
                    }
                    try {
                        DeleteUser.getInstance().deleteById(id);
                    } catch (IOException e) {
                        System.out.println("Something wrong with input or output");
                    }
                    break;
                case 3:
                    System.out.println("Choose one point." +
                            "\n" +
                            "1.Edit telephone" +
                            "\n" +
                            "2.Edit role" +
                            "\n" +
                            "3.Edit whole user data");
                    if (sc.hasNextInt()) {
                        secondNumber = sc.nextInt();
                        while (secondNumber > 3 || secondNumber < 1) {
                            secondNumber = sc.nextInt();
                        }
                    }
                    System.out.println("Enter email of editable user");
                    String email = specifyEmail();

                    switch (secondNumber) {
                        case 1:
                            try {
                                EditUser.getInstance().editTelephone(email);
                            } catch (IOException e) {
                                System.out.println("Something wrong with input or output");
                            } catch (InvalidDataException e) {
                                e.getMessage();
                            }
                            break;
                        case 2:
                            try {
                                EditUser.getInstance().editRole(email);
                            } catch (IOException e) {
                                System.out.println("Something wrong with input or output");
                            }
                            break;
                        case 3:
                            try {
                                EditUser.getInstance().editUserData(email);
                            } catch (IOException e) {
                                System.out.println("Something wrong with input or output");
                            } catch (InvalidDataException e) {
                                e.getMessage();
                            }
                            break;
                        default:
                            System.out.println("Something wrong with data edit");

                    }
                    break;
                case 4:
                    try {
                        System.out.println("Users list: \n");
                        for (User user : InputOutputDataHandler.read()) {
                            System.out.println(user);
                        }
                    } catch (IOException e) {
                        System.out.println("Something wrong with input or output");
                    }
                    break;
                case 5:
                    System.out.println("To find user enter user's email");
                    String searchEmail = specifyEmail();
                    try {
                        System.out.println(SearchUser.getInstance().findUserByEmail(searchEmail));
                    } catch (IOException e) {
                        System.out.println("Something wrong with input or output");
                    }
                    break;
                case 6:
                    System.out.println("End of program");
                    System.exit(0);
                default:
                    System.out.println("Something went wrong.");

            }
        }


    }

    public static String specifyEmail() {
        Scanner sc = new Scanner(System.in);
        String email = "";
        if (sc.hasNext()) {
            email = sc.next();
            while (!Validator.getIntance().emailIsValid(email)) {
                System.out.println("Invalid format of email.Try again");
                email = sc.next();
            }
        }
        return email;
    }


}


