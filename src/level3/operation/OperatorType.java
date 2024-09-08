package level3.operation;

import java.util.Arrays;
import level3.exception.InvalidOperatorException;

public enum OperatorType {
    ADD("+", new AddOperation()),
    SUBTRACT("-", new SubstractOperation()),
    MULTIPLY("*", new MultiplyOperation()),
    DIVIDE("/", new DivideOperation());

    private final String operator;
    private final Operation<Number> operation;

    OperatorType(final String operator, final Operation<Number> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    // String 형태로 연산자가 들어오면 어떤 Operation인지 찾는 로직
    public static Operation<Number> from(final String operator) {
        return Arrays.stream(OperatorType.values())
                .filter(v -> v.operator.equals(operator))
                .findAny()
                .map(OperatorType::getOperation)
                .orElseThrow(() -> new InvalidOperatorException(operator));
    }

    // 어떤 Operation정보를 가져오는 로직 (getter)
    public Operation<Number> getOperation() {
        return operation;
    }
}
