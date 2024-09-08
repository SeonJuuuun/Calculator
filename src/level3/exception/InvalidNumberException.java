package level3.exception;

public class InvalidNumberException extends AppException {
    // 첫 번째 숫자와 두 번째 숫자가 숫자 형식이 아니면 예외가 발생하는 로직
    public InvalidNumberException(final String input) {
        super(input + "은 숫자 형식이 아닙니다.");
    }
}
