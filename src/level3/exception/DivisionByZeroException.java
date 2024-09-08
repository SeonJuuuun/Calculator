package level3.exception;

public class DivisionByZeroException extends AppException {
    // 나눗셈 계산을 할때 두 번째 숫자가 0이면 예외가 발생하는 로직
    public DivisionByZeroException() {
        super("0으로 나눌 수 없습니다.");
    }
}
