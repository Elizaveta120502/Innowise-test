package by.bsuir.test.logic.impl;

import by.bsuir.test.entity.Role;
import by.bsuir.test.entity.User;
import by.bsuir.test.exception.InvalidDataException;
import by.bsuir.test.logic.Editable;

import java.io.IOException;
import java.util.ArrayList;


public class EditUser implements Editable {

    private static EditUser editUser;

    private EditUser() {
    }

    public static EditUser getInstance(){
        if (editUser == null){
            editUser = new EditUser();
        }
        return editUser;
    }



    @Override
    public void editTelephone(String email) throws IOException, InvalidDataException {


        String firstTelephone;
        String secondTelephone;
        String theardTelephone;
        ArrayList<String> newPhones = new ArrayList<>();

        User editableUser = SearchUser.getInstance().findUserByEmail(email).get();

        CreateUser.enterPhones();

        switch (CreateUser.telephones.size()) {
            case 1:
                firstTelephone = CreateUser.telephones.get(0);
                newPhones.add(firstTelephone);
                break;

            case 2:
                firstTelephone = CreateUser.telephones.get(0);
                secondTelephone = CreateUser.telephones.get(1);
                newPhones.add(firstTelephone);
                newPhones.add(secondTelephone);

                break;
            case 3:
                firstTelephone = CreateUser.telephones.get(0);
                secondTelephone = CreateUser.telephones.get(1);
                theardTelephone = CreateUser.telephones.get(2);
                newPhones.add(firstTelephone);
                newPhones.add(secondTelephone);
                newPhones.add(theardTelephone);
                break;
            default:
                throw new InvalidDataException("Something went wrong with changing telephones");
        }

        ArrayList<User> newUsersList = InputOutputDataHandler.read();
        for (User us: newUsersList){
            if (us.getEmail().equals(editableUser.getEmail())){
                us.setMobilePhone(newPhones);
            }
        }
        InputOutputDataHandler.cleanFile();
        for (User u: newUsersList) {
            InputOutputDataHandler.getInstance().write(u);
        }


    }

    @Override
    public void editRole(String email) throws IOException {
        CreateUser.chooseRole();
        ArrayList<User> changedUserDataList = InputOutputDataHandler.read();
        for (User us: changedUserDataList){
            if (us.getEmail().equals(email)){
                us.setRole(CreateUser.roles);

            }
        }
        InputOutputDataHandler.cleanFile();
        for (User u: changedUserDataList) {
            InputOutputDataHandler.getInstance().write(u);
        }
    }

    @Override
    public void editUserData(String email) throws IOException, InvalidDataException {


        User newDataUser = CreateUser.getInstance().createUser();

        ArrayList<User> newUsersList = InputOutputDataHandler.read();
        for (User us: newUsersList){
            if (us.getEmail().equals(email)){
                us.setName(newDataUser.getName());
                us.setSurname(newDataUser.getSurname());
                us.setEmail(newDataUser.getEmail());
                us.setRole(newDataUser.getRole());
                us.setMobilePhone(newDataUser.getMobilePhone());

            }
        }
        InputOutputDataHandler.cleanFile();
        for (User u: newUsersList) {
            InputOutputDataHandler.getInstance().write(u);
        }


    }
}
