package by.bsuir.test.validator;

public class Validator implements Validational {

    private static Validator validator;

    private Validator(Validator validator) {
        this.validator = validator;
    }

    public Validator() {
    }

    public static Validator getIntance(){
        if (validator == null){
            return new Validator();
        }
        return validator;
    }

    @Override
    public boolean emailIsValid(String email) {
        if (email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            return true;
        } else {
            System.out.println("Invalid email. Try again");
            return false;
        }
    }

    @Override
    public boolean telephoneIsValid(String mobileTelephone) {

        if (mobileTelephone.matches("^375[0-9]{9}")) {
            System.out.println("Successful input");
            return true;
        } else {
            System.out.println("Invalid mobile phone. Try again");
            return false;
        }
    }
}
