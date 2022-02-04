package by.bsuir.test.logic.impl;

import by.bsuir.test.entity.User;
import by.bsuir.test.logic.Searchable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;


public class SearchUser implements Searchable {
    private static SearchUser searchUser;

    private SearchUser() {
    }

    public static SearchUser getInstance(){
        if (searchUser == null){
            searchUser = new SearchUser();
        }
        return searchUser;
    }

    @Override
    public Optional<User> findUserByEmail(String email) throws IOException {

        User user = new User();
        ArrayList<User> users = InputOutputDataHandler.getInstance().read();
        for (User us : users){
            if (us.getEmail().equals(email)) {
                user = us;
            }
        }
        return Optional.of(user);
    }





}
