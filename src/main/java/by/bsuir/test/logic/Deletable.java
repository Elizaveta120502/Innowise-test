package by.bsuir.test.logic;

import java.io.IOException;

public interface Deletable {

    void deleteById(int id) throws IOException;

    void deleteByNameSurname(String name,String surname) throws IOException;
}
