package level3.exception;

public class AppException extends Exception{
    public AppException(final String message) {
        super("[ERROR] " + message);
    }
}
