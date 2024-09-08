package level3.exception;

public class InvalidOperatorException extends AppException {
    // 사칙연산이 아닌 다른 값이 들어가면 예외가 발생하는 로직
    public InvalidOperatorException(final String operator) {
        super(operator + " 는 지원되지 않는 연산자입니다.");
    }
}
