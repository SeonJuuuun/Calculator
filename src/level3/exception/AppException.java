package level3.exception;

public class AppException extends RuntimeException {
    // RuntimeException을 상속받는 커스텀 예외 선언
    public AppException(final String message) {
        super("[ERROR] " + message);
    }
}
