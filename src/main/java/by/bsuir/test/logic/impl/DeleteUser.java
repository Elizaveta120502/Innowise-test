package by.bsuir.test.logic.impl;

import by.bsuir.test.entity.User;
import by.bsuir.test.logic.Deletable;

import java.io.IOException;
import java.util.ArrayList;

public class DeleteUser implements Deletable {

    private static DeleteUser deleteUser;
    private static final int ID_UNIT = 1;

    private DeleteUser() {
    }

    public static DeleteUser getInstance() {
        if (deleteUser == null) {
            deleteUser = new DeleteUser();
        }
        return deleteUser;
    }

    @Override
    public void deleteById(int id) throws IOException {

        ArrayList<User> users = InputOutputDataHandler.getInstance().read();
        User userToDelete = new User();
        for (User us : users) {
             if (us.getId() == id){
                 userToDelete = us;
             }
        }
        if(userToDelete != null) {
            users.remove(userToDelete);
            System.out.println("Successful removal");
        }else{
            System.out.println("Error of delete");
        }

        InputOutputDataHandler.cleanFile();
        for (User u : users) {
            InputOutputDataHandler.getInstance().write(u);
        }
    }

}
