package by.bsuir.test.logic.impl;

import by.bsuir.test.entity.User;
import by.bsuir.test.logic.Searchable;
import by.bsuir.test.logic.impl.InputDataReader;

import java.io.IOException;


public class SearchUser implements Searchable {

    @Override
    public User toFindUser(String name, String surname) throws IOException {

        User user = null;
        for (User us : InputDataReader.getInstance().read()){
            if (us.getName().equals(name) && us.getSurname().equals(surname)){
                user = us;
            }else{
                System.out.println("No such employee in a list");
            }
        }
        return user;
    }
}
