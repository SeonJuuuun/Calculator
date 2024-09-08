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

    public static Operation<Number> from(final String operator) {
        return Arrays.stream(OperatorType.values())
                .filter(v -> v.operator.equals(operator))
                .findAny()
                .map(OperatorType::getOperation)
                .orElseThrow(() -> new InvalidOperatorException(operator));
    }

    public Operation<Number> getOperation() {
        return operation;
    }
}
