package by.bsuir.test.presentation;

import by.bsuir.test.entity.User;
import by.bsuir.test.logic.InputDataReader;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users;


        try {
            users = InputDataReader.getInstance().read();
            for (User u : users ){
                System.out.println(u);
            }

        } catch (IOException e) {
            e.getMessage();
        }





    }
}
