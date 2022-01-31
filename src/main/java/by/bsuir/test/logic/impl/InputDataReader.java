package by.bsuir.test.logic.impl;

import by.bsuir.test.entity.Role;
import by.bsuir.test.entity.User;
import by.bsuir.test.exception.InvalidDataException;
import by.bsuir.test.logic.Readable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputDataReader implements Readable {

    private static final String FILE_NAME = "C:/Users/ЛИЗАВЕТА/IdeaProjects/test-innowise/src/main/resources/Users.txt";
    private static  InputDataReader inputDataReader;

    public InputDataReader(InputDataReader inputDataReader) {
        this.inputDataReader = inputDataReader;
    }

    private InputDataReader() {
    }

    public static InputDataReader getInstance(){
        if (inputDataReader == null){
            inputDataReader = new InputDataReader();
        }
        return inputDataReader;
    }


    @Override
    public ArrayList<User> read() throws IOException {

        ArrayList<User> users = new ArrayList<>();


        File file = new File(FILE_NAME);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] splitData = line.split(" ");
            if (line.matches("[a-zA-Z0-9]+") == false) {
                try {
                    if (splitData.length >= 7) {
                        ArrayList<Role> roles = new ArrayList<>();
                        roles.add(Role.of(splitData[4]));
                        roles.add(Role.of(splitData[5]));

                        ArrayList<String> telephones = new ArrayList<>();
                        telephones.add(splitData[6]);
                        if (splitData.length == 8 || splitData.length == 9) {
                            telephones.add(splitData[7]);
                        }
                        if (splitData.length == 9) {
                            telephones.add(splitData[8]);
                        }

                        User user = new User();
                        user.setId(Integer.parseInt(splitData[0]));
                        user.setName(splitData[1]);
                        user.setSurname(splitData[2]);
                        user.setEmail(splitData[3]);
                        user.setRole(roles);
                        user.setMobilePhone(telephones);

                        User newUser = new User(user.getId(), user.getName(),
                                user.getSurname(), user.getEmail(),
                                user.getRole(), user.getMobilePhone());

                        users.add(newUser);
                    } else {
                        throw new InvalidDataException("invalid input data");
                    }

                } catch (InvalidDataException e) {
                    e.getMessage();
                }

            }
        }
        return users;
    }
}



