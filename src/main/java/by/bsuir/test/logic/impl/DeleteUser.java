package by.bsuir.test.logic.impl;

import by.bsuir.test.entity.User;
import by.bsuir.test.logic.Deletable;

import java.io.IOException;
import java.util.ArrayList;

public class DeleteUser implements Deletable {
    @Override
    public void deleteById(int id) throws IOException {
        ArrayList<User> users = InputOutputDataHandler.getInstance().read();
        for (User us: users){
            if (us.getId() == id){
                users.remove(us);
            }
        }
    }

    @Override
    public void deleteByNameSurname(String name, String surname) throws IOException {
        ArrayList<User> users = InputOutputDataHandler.getInstance().read();
        for (User us: users){
            if (us.getName().equals(name) && us.getSurname().equals(surname)){
                users.remove(us);
            }
        }

    }
}
