package level3.calculator;

import java.util.ArrayList;
import java.util.List;
import level3.operation.Operation;
import level3.operation.OperatorType;

public class ArithmeticCalculator<T extends Number> {

    private final List<T> results = new ArrayList<>();

    public T calculate(final T firstNumber, final T secondNumber, final String operatorStr) {
        final Operation<Number> operation = OperatorType.getOperation(operatorStr);
        final T answer = (T) operation.operate(firstNumber, secondNumber);
        results.add(answer);
        return answer;
    }

    public List<T> getResultsGreaterThanInputNumbers(final T firstNumber, final T secondNumber) {
        final double max = Math.max(firstNumber.doubleValue(), secondNumber.doubleValue());
        return results.stream()
                .filter(result -> result.doubleValue() > max)
                .toList();
    }

    public List<T> getResults() {
        return results;
    }
}
