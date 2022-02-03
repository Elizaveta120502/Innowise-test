package by.bsuir.test.logic;

import by.bsuir.test.entity.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public interface Searchable {

    Optional<User> findUserByEmail(String email) throws IOException;


}
