package level3.exception;

public class InvalidOperatorException extends AppException {
    public InvalidOperatorException(final String operator) {
        super(operator + " 는 지원되지 않는 연산자입니다.");
    }
}
