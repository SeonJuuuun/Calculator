package level3.operation;

public class SubstractOperation implements Operation<Number> {

    @Override
    public Number operate(final Number firstNumber, final Number secondNumber) {
        if (firstNumber instanceof Double || secondNumber instanceof Double) {
            return firstNumber.doubleValue() - secondNumber.doubleValue();
        } else {
            return firstNumber.intValue() - secondNumber.intValue();
        }
    }
}
