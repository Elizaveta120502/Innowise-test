package by.bsuir.test.logic;

import by.bsuir.test.entity.User;
import by.bsuir.test.exception.InvalidDataException;

import java.io.IOException;

public interface Editable {

    void editTelephone(String email) throws IOException, InvalidDataException;

    void editRole(String email) throws IOException;

    void editUserData(String email) throws IOException, InvalidDataException;


}
