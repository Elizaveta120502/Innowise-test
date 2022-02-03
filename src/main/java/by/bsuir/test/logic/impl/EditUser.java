package by.bsuir.test.logic.impl;

import by.bsuir.test.entity.User;
import by.bsuir.test.exception.InvalidDataException;
import by.bsuir.test.logic.Editable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

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
                ArrayList<User> newUsersList = InputOutputDataHandler.read();
                for (User us: newUsersList){
                    if (us.getEmail().equals(editableUser.getEmail())){
                        us.setMobilePhone(newPhones);
                    }
                }
                InputOutputDataHandler.cleanFile(editableUser);
                 for (User u: newUsersList) {
                     InputOutputDataHandler.getInstance().write(u);
                 }
                break;

            case 2:
                firstTelephone = CreateUser.telephones.get(0);
                secondTelephone = CreateUser.telephones.get(1);
                newPhones.add(firstTelephone);
                newPhones.add(secondTelephone);
                editableUser.setMobilePhone(newPhones);
                InputOutputDataHandler.cleanFile(editableUser);
                InputOutputDataHandler.getInstance().write(editableUser);
                break;
            case 3:
                firstTelephone = CreateUser.telephones.get(0);
                secondTelephone = CreateUser.telephones.get(1);
                theardTelephone = CreateUser.telephones.get(2);
                newPhones.add(firstTelephone);
                newPhones.add(secondTelephone);
                newPhones.add(theardTelephone);
                editableUser.setMobilePhone(newPhones);
                InputOutputDataHandler.cleanFile(editableUser);
                InputOutputDataHandler.getInstance().write(editableUser);
                break;
            default:
                throw new InvalidDataException("Something went wrong with changing telephones");
        }


    }

    @Override
    public User editRole(String name, String surname) {
        return null;
    }

    @Override
    public User editUserData(String name, String surname) {
        return null;
    }
}
