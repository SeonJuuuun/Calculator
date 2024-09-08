package level3.operation;

public class MultiplyOperation implements Operation<Number> {

    // 곱하는 로직
    @Override
    public Number operate(final Number firstNumber, final Number secondNumber) {
        if (firstNumber instanceof Double || secondNumber instanceof Double) {
            return firstNumber.doubleValue() * secondNumber.doubleValue();
        } else {
            return firstNumber.intValue() * secondNumber.intValue();
        }
    }
}
