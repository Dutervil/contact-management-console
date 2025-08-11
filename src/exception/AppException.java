package exception;

public class AppException extends RuntimeException{

    public AppException(String message) {
        super(message);
    }

    public AppException() {
        super("Something went wrong. Please try again later");
    }
}
