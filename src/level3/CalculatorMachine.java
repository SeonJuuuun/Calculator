package level3;


import java.util.List;
import java.util.function.Supplier;
import level3.calculator.ArithmeticCalculator;
import level3.exception.AppException;
import level3.view.Input;
import level3.view.Output;

public class CalculatorMachine {

    private final ArithmeticCalculator<Number> arithmeticCalculator;

    public CalculatorMachine(ArithmeticCalculator<Number> arithmeticCalculator) {
        this.arithmeticCalculator = arithmeticCalculator;
    }

    public void start(){
        while (true) {
            final String firstNumberStr = repeat(this::inputFirstNumber);
            final String secondNumberStr = repeat(this::inputSecondNumber);
            final String operatorStr = repeat(this::inputOperator);

            final Number firstNumber = parseNumber(firstNumberStr);
            final Number secondNumber = parseNumber(secondNumberStr);

            final Number answer = arithmeticCalculator.calculate(firstNumber, secondNumber, operatorStr);
            Output.printCalculationResult(answer);

            final List<Number> filteredResults = arithmeticCalculator.getResultsGreaterThanInputNumbers(firstNumber,
                    secondNumber);
            Output.printFilteredResults(filteredResults);

            final List<Number> history = arithmeticCalculator.getResults();
            Output.printAllHistory(history);

            final String ended = inputEnded();
            if (ended.equalsIgnoreCase("exit")) {
                break;
            }
        }
    }

    private String inputFirstNumber() {
        Output.printFirstNumber();
        return Input.readFirstNumber();
    }

    private String inputSecondNumber() {
        Output.printSecondNumber();
        return Input.readSecondNumber();
    }

    private String inputOperator()  {
        Output.printOperator();
        return Input.readOperator();
    }

    private String inputEnded() {
        Output.printEndedMessage();
        return Input.readEnded();
    }

    private Number parseNumber(final String numberStr) {
        if (numberStr.contains(".")) {
            return Double.parseDouble(numberStr);
        } else {
            return Integer.parseInt(numberStr);
        }
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (AppException e) {
            System.out.println(e.getMessage());
            return repeat(inputReader);
        }
    }
}
