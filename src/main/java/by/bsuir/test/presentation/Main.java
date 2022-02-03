package by.bsuir.test.presentation;

import by.bsuir.test.entity.User;
import by.bsuir.test.exception.InvalidDataException;
import by.bsuir.test.logic.impl.CreateUser;
import by.bsuir.test.logic.impl.EditUser;
import by.bsuir.test.logic.impl.InputOutputDataHandler;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users;

        try {
            EditUser.getInstance().editRole("ggg.w@gmail.com");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {

//            users = InputDataReader.getInstance().read();

//            for (User u : users){
//                System.out.println(u);
//            }


//            InputOutputDataHandler.getInstance().write(CreateUser.getInstance().createUser());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InvalidDataException e) {
//            e.printStackTrace();
//        }
//
//
//        }
    }
    }


