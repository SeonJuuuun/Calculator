package level3;

import java.util.Arrays;
import level3.operation.AddOperation;
import level3.operation.DivideOperation;
import level3.operation.MultiplyOperation;
import level3.operation.Operation;
import level3.operation.SubstractOperation;

public enum OperatorType {
    ADD("+", new AddOperation()),
    SUBTRACT("-", new SubstractOperation()),
    MULTIPLY("*", new MultiplyOperation()),
    DIVIDE("/", new DivideOperation());

    private final String operator;
    private final Operation<Number> operation;

    OperatorType(String operator, Operation<Number> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public Operation<Number> getOperation() {
        return operation;
    }

    public static Operation<Number> getOperation(final String operator) {
        return Arrays.stream(OperatorType.values())
                .filter(v -> v.operator.equals(operator))
                .findAny()
                .map(OperatorType::getOperation)
                .orElseThrow(() -> new IllegalArgumentException("올바른 연산자를 입력해 주세요."));
    }
}
