package by.bsuir.test.logic;

import by.bsuir.test.entity.User;

import java.io.IOException;
import java.util.ArrayList;

public interface Searchable {

    User toFindUser(String name, String surname) throws IOException;

}
