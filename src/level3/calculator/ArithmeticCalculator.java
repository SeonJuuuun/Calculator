package level3.calculator;

import java.util.ArrayList;
import java.util.List;
import level3.exception.AppException;
import level3.operation.Operation;
import level3.operation.OperatorType;

public class ArithmeticCalculator<T extends Number> {

    // 결과 값 저장 필드
    private final List<T> results = new ArrayList<>();

    // 입력 값들을 받고 계산하는 로직
    public T calculate(final T firstNumber, final T secondNumber, final String operatorStr) throws AppException {
        final Operation<Number> operation = OperatorType.from(operatorStr);
        final T answer = (T) operation.operate(firstNumber, secondNumber);
        results.add(answer);
        return answer;
    }

    // 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값 들을 찾는 로직
    public List<T> getResultsGreaterThanInputNumbers(final T firstNumber, final T secondNumber) {
        final double max = Math.max(firstNumber.doubleValue(), secondNumber.doubleValue());
        return results.stream()
                .filter(result -> result.doubleValue() > max)
                .toList();
    }

    // 지금까지 계산 한것 출력 로직
    public List<T> getHistory() {
        return results;
    }
}
