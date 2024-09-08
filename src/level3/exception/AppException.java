package level3.exception;

public class AppException extends RuntimeException{
    public AppException(final String message) {
        super("[ERROR] " + message);
    }
}
