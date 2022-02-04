package by.bsuir.test.logic.impl;

import by.bsuir.test.entity.Role;
import by.bsuir.test.entity.User;
import by.bsuir.test.exception.InvalidDataException;
import by.bsuir.test.validator.Validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CreateUser {

    private static CreateUser createUser;
    private static final int ID_UNIT = 1;
    static ArrayList<Role> roles = new ArrayList<>();
    static ArrayList<String> telephones = new ArrayList<>();

    private CreateUser() {
    }

    public static CreateUser getInstance() {
        if (createUser == null) {
            createUser = new CreateUser();
        }
        return createUser;
    }

    public User createUser() throws IOException, InvalidDataException {

        Random rand = new Random();
        int id = rand.nextInt(1000) + ID_UNIT;
        String name = null;
        String surname = null;
        String email = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("User creation. Please follow next steps:\n Enter name ");
        if (sc.hasNext()) {
            name = sc.nextLine();
            System.out.println("Enter surname");
            surname = sc.nextLine();
            System.out.println("Enter email");
            email = sc.nextLine();
            while (!Validator.getIntance().emailIsValid(email)) {
                email = sc.nextLine();
            }

            chooseRole();
            enterPhones();

        }
        User newUser = new User(id, name, surname, email, roles, telephones);

      //  InputOutputDataHandler.getInstance().write(newUser);


        return newUser;

    }


    static void chooseRole() {
        String firstRole;
        String secondRole;
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose your roles.\n " +
                "1 level: User or Customer\n" +
                "2 level: Admin or Provider\n" +
                "3 level: Super_admin\n" +
                "P.S. If you will choose Super Admin \n" +
                "selection of roles from other levels is prohibited");

        System.out.println("Enter first role: ");
        if (sc.hasNext()) {
            firstRole = sc.next();

            while (!(firstRole.equalsIgnoreCase(String.valueOf(Role.USER))
                    || firstRole.equalsIgnoreCase(String.valueOf(Role.CUSTOMER)) ||
                    firstRole.equalsIgnoreCase(String.valueOf(Role.SUPER_ADMIN))
                    || firstRole.equalsIgnoreCase(String.valueOf(Role.ADMIN)) ||
                    firstRole.equalsIgnoreCase(String.valueOf(Role.PROVIDER)))) {
                System.out.println("Invalid input. Try again \n");
                firstRole = sc.next();
            }
            roles.add(Role.of(firstRole));


            if (Role.of(firstRole).getLevel() < 3) {
                System.out.println("Enter second role: ");
                secondRole = sc.next();

                if (Role.of(firstRole).getLevel() == 1) {
                    while (!(secondRole.equalsIgnoreCase(String.valueOf(Role.ADMIN)) ||
                            secondRole.equalsIgnoreCase(String.valueOf(Role.PROVIDER)))) {
                        System.out.println("Invalid input.Try again \n");
                        secondRole = sc.next();

                    }
                }

                if (Role.of(firstRole).getLevel() == 2) {
                    while (!(secondRole.equalsIgnoreCase(String.valueOf(Role.USER)) ||
                            secondRole.equalsIgnoreCase(String.valueOf(Role.CUSTOMER)))) {
                        System.out.println("Invalid input.Try again \n");
                        secondRole = sc.next();

                    }
                }


                roles.add(Role.of(secondRole));

            }

        }

    }

    static void enterPhones() throws InvalidDataException {
        String firstPhone = null;
        String secondPhone = null;
        String theardPhone = null;
        int amount = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("How many phones do you want to enter?");


        if (sc.hasNextInt()) {
            amount = sc.nextInt();
            while (amount <= 0 || amount > 3) {
                amount = sc.nextInt();
            }
        }
        switch (amount) {
            case 1:
                System.out.println("Enter telephone: ");
                if (sc.hasNext()) {
                    firstPhone = sc.next();
                    while (!Validator.getIntance().telephoneIsValid(firstPhone)) {
                        firstPhone = sc.next();
                    }
                }
                telephones.add(firstPhone);
                break;

            case 2:
                System.out.println("Enter first telephone: ");
                if (sc.hasNext()) {
                    firstPhone = sc.next();
                    while (!Validator.getIntance().telephoneIsValid(firstPhone)) {
                        firstPhone = sc.next();
                    }
                    System.out.println("Enter second telephone: ");
                    secondPhone = sc.next();
                    while (!Validator.getIntance().telephoneIsValid(secondPhone)) {
                        secondPhone = sc.next();
                    }
                }
                telephones.add(firstPhone);
                telephones.add(secondPhone);
                break;
            case 3:
                System.out.println("Enter first telephone: ");
                if (sc.hasNext()) {
                    firstPhone = sc.next();
                    while (!Validator.getIntance().telephoneIsValid(firstPhone)) {
                        firstPhone = sc.next();
                    }
                    System.out.println("Enter second telephone: ");
                    secondPhone = sc.next();
                    while (!Validator.getIntance().telephoneIsValid(secondPhone)) {
                        secondPhone = sc.next();
                    }
                    System.out.println("Enter theard telephone: ");
                    theardPhone = sc.next();
                    while (!Validator.getIntance().telephoneIsValid(theardPhone)) {
                        theardPhone = sc.next();
                    }
                }
                telephones.add(firstPhone);
                telephones.add(secondPhone);
                telephones.add(theardPhone);
                break;

            default:

                throw new InvalidDataException("Something went wrong while entering telephone");

        }
    }


}
