package by.bsuir.test.presentation;

import by.bsuir.test.entity.User;
import by.bsuir.test.logic.impl.InputDataReader;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        InputDataReader inputDataReader = new InputDataReader();

        try {
            users = inputDataReader.read(new User());
            for (User u : users ){
                System.out.println(u);
            }

        } catch (IOException e) {
            e.getMessage();
        }





    }
}
