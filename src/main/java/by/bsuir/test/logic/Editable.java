package by.bsuir.test.logic;

import by.bsuir.test.entity.User;
import by.bsuir.test.exception.InvalidDataException;

import java.io.IOException;

public interface Editable {

    void editTelephone(String email) throws IOException, InvalidDataException;

    User editRole(String name, String surname);

    User editUserData(String name, String surname);


}
