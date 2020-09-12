package by.itechart.library.service.util;

public class UserValidationImpl implements UserValidation {
    private static final String FIRST_NAME_FORMAT_REGEX = ".{2,30}";
    private static final String LAST_NAME_FORMAT_REGEX = ".{2,30}";
    private static final String USERNAME_FORMAT_REGEX = "[A-Za-z0-9][A-Za-z0-9_-]{4,13}[A-Za-z0-9]";
    private static final String PASSWORD_NAME_FORMAT_REGEX = "^(?=.*[0-9]).{8,15}$";
    private static final String EMAIL_FORMAT_REGEX = "[a-z][[a-z][0-9][-][_]]{3,15}[@][a-z]{2,10}[.][a-z]{2,4}";
    private static final String PHONE_NUMBER_FORMAT_REGEX = ".{2,30}";

    @Override
    public boolean validateSignUp(String username, String password, String firstName, String lastName, String email, String phoneNumber) {
        return false;
    }
}
