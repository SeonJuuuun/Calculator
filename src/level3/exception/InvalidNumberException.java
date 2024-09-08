package level3.exception;

public class InvalidNumberException extends AppException {
    public InvalidNumberException(final String input) {
        super(input + "은 숫자 형식이 아닙니다.");
    }
}
