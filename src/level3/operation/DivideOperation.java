package level3.operation;

import level3.exception.DivisionByZeroException;

public class DivideOperation implements Operation<Number>  {

    @Override
    public Number operate(final Number firstNumber, final Number secondNumber) {
        if (secondNumber.intValue() == 0) {
            throw new DivisionByZeroException();
        }

        if (firstNumber instanceof Double || secondNumber instanceof Double) {
            return firstNumber.doubleValue() / secondNumber.doubleValue();
        } else {
            return firstNumber.intValue() / secondNumber.intValue();
        }
    }
}
