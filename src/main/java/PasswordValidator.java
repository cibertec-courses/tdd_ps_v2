public class PasswordValidator {

    public PasswordValidator() {
    }

    public boolean isValid(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = password.chars().anyMatch(x -> Character.isUpperCase(x));
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);

        return hasDigit && hasUpperCase;
    }

}
