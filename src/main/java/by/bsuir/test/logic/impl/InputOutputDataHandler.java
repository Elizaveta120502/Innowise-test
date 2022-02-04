package by.bsuir.test.logic.impl;

import by.bsuir.test.entity.Role;
import by.bsuir.test.entity.User;
import by.bsuir.test.exception.InvalidDataException;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

public class InputOutputDataHandler {

    private static final String FILE_NAME = "C:/Users/ЛИЗАВЕТА/IdeaProjects/PomiLab2/src/main/resources/Users.txt";
    private static final String BUFER_FILE_NAME = "C:/Users/ЛИЗАВЕТА/IdeaProjects/PomiLab2/src/main/resources/Users.txt";
    private static File file = new File(FILE_NAME);
    private static File buferFile = new File(BUFER_FILE_NAME);
    private static InputOutputDataHandler inputOutputDataHandler;

    public InputOutputDataHandler(InputOutputDataHandler inputDataReader) {
        this.inputOutputDataHandler = inputDataReader;
    }

    private InputOutputDataHandler() {
    }

    public static InputOutputDataHandler getInstance() {
        if (inputOutputDataHandler == null) {
            inputOutputDataHandler = new InputOutputDataHandler();
        }
        return inputOutputDataHandler;
    }


    public static ArrayList<User> read() throws IOException {

        ArrayList<User> users = new ArrayList<>();

        if (file.exists() && file.canRead()) {

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
        }
        return users;
    }


    public boolean write(User user) throws IOException {
        int amountOfLinesBeforeWrite = read().size();

        if (file.exists() && file.canWrite()) {
            FileWriter writer = new FileWriter(file, true); //true - data is written to the end of the file
            BufferedWriter bw = new BufferedWriter(writer);

            if (user != null) {
                bw.write("\n");
                bw.write(String.valueOf(user.getId()));
                bw.write(" ");
                bw.write(user.getName());
                bw.write(" ");
                bw.write(user.getSurname());
                bw.write(" ");
                bw.write(user.getEmail());
                bw.write(" ");
                for (Role role : user.getRole()) {
                    bw.write(String.valueOf(role));
                    bw.write(" ");
                }

                for (String tel : user.getMobilePhone()) {
                    bw.write(tel);
                    bw.write(" ");
                }
            }
            bw.close();
            writer.close();
        }

        int amountOfLinesAfterWrite = read().size();

        if (amountOfLinesAfterWrite > amountOfLinesBeforeWrite) {
            return true;
        } else {
            return false;
        }

    }

    static void cleanFile() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(buferFile));

        reader.close();
        writer.close();
        file.delete();
        buferFile.renameTo(file);
    }
}



