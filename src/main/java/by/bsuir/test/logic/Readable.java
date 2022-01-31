package by.bsuir.test.logic;

import by.bsuir.test.entity.User;

import java.io.IOException;
import java.util.ArrayList;

public interface Readable {

    ArrayList<User> read(User user) throws IOException;
}
