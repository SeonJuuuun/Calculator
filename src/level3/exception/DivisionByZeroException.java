package level3.exception;

public class DivisionByZeroException extends AppException {
    public DivisionByZeroException() {
        super("0으로 나눌 수 없습니다.");
    }
}
