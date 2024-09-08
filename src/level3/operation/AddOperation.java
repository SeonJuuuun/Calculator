package level3.operation;

public class AddOperation implements Operation<Number> {

    // 더하는 로직
    @Override
    public Number operate(Number firstNumber, Number secondNumber) {
        if (firstNumber instanceof Double || secondNumber instanceof Double) {
            return firstNumber.doubleValue() + secondNumber.doubleValue();
        } else {
            return firstNumber.intValue() + secondNumber.intValue();
        }
    }
}
