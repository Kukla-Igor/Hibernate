package lesson4.exception;

public class UserNotFoundException extends Exception   {
    public UserNotFoundException(String message) {
        super(message);
    }
}
