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

    public void start() {
        while (true) {
            // 첫 번째 숫자와 두 번째 숫자 및 연산자 입력 받는 로직
            final String firstNumberStr = repeat(this::inputFirstNumber);
            final String secondNumberStr = repeat(this::inputSecondNumber);
            final String operatorStr = repeat(this::inputOperator);

            // Number 형태로 변환시켜주는 로직
            final Number firstNumber = parseNumber(firstNumberStr);
            final Number secondNumber = parseNumber(secondNumberStr);

            // 입력 값들을 받고 계산하는 로직
            final Number answer = arithmeticCalculator.calculate(firstNumber, secondNumber, operatorStr);
            Output.printCalculationResult(answer);

            // 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값 들을 출력 하는 로직
            final List<Number> filteredResults = arithmeticCalculator.getResultsGreaterThanInputNumbers(firstNumber,
                    secondNumber);
            Output.printFilteredResults(filteredResults);

            // 총 계산 결과를 출력하는 로직
            final List<Number> history = arithmeticCalculator.getHistory();
            Output.printAllHistory(history);

            // 다시 계산할건지 물어보는 로직
            final String ended = inputEnded();
            if (ended.equalsIgnoreCase("exit")) {
                break;
            }
        }
    }

    // 첫 번째 숫자를 입력받는 로직
    private String inputFirstNumber() {
        Output.printFirstNumber();
        return Input.readFirstNumber();
    }

    // 두 번째 숫자를 입력받는 로직
    private String inputSecondNumber() {
        Output.printSecondNumber();
        return Input.readSecondNumber();
    }

    // 연산자를 입력받는 로직
    private String inputOperator() {
        Output.printOperator();
        return Input.readOperator();
    }

    // 다시 계산할건지 물어보는 로직
    private String inputEnded() {
        Output.printEndedMessage();
        return Input.readEnded();
    }

    // Number 형태로 바꾸는 로직
    private Number parseNumber(final String numberStr) {
        if (numberStr.contains(".")) {
            return Double.parseDouble(numberStr);
        } else {
            return Integer.parseInt(numberStr);
        }
    }

    // 예외가 발생했을 때 그 부분부터 다시 하는 로직
    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (AppException e) {
            System.out.println(e.getMessage());
            return repeat(inputReader);
        }
    }
}
