package level3;

import static java.util.stream.Collectors.joining;

import java.util.List;
import java.util.Scanner;
import level3.calculator.ArithmeticCalculator;
import level3.operation.Operation;

public class CalculatorManager {
    private static final Scanner scanner = new Scanner(System.in);

    private final ArithmeticCalculator<Number> arithmeticCalculator = new ArithmeticCalculator<>();

    public void start() {
        while (true) {
            String firstNumberStr = inputFirstNumber();
            String secondNumberStr = inputSecondNumber();
            String operator = inputOperator();

            Number firstNumber = parseNumber(firstNumberStr);
            Number secondNumber = parseNumber(secondNumberStr);

            Operation<Number> operation = OperatorType.getOperation(operator);
            //TODO OperationType을 찾는 건 CalculatorManager가 할 역할은 아닌거 같다.

            Number answer = arithmeticCalculator.calculate(firstNumber, secondNumber, operation);

            System.out.println("-----------------");
            System.out.println("결과 : " + answer);

            List<Number> filteredResults = arithmeticCalculator.getResultsGreaterThanInputNumbers(firstNumber,
                    secondNumber);
            String result = filteredResults.stream()
                    .map(String::valueOf)
                    .collect(joining(", "));

            System.out.println("-----------------");
            System.out.println("입력한 숫자보다 큰 결과 : " + result);

            System.out.println("-----------------");
            List<Number> results = arithmeticCalculator.getResults();
            String totalResult = results.stream()
                    .map(String::valueOf)
                    .collect(joining(", "));

            System.out.println("총 결과값 저장 히스토리: " + totalResult);
            System.out.println("-----------------");

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String ended = scanner.next();
            if (ended.equalsIgnoreCase("exit")) {
                break;
            }
        }
    }

    private String inputFirstNumber() {
        System.out.println("첫 번째 숫자를 입력해주세요.");
        return scanner.next();
    }

    private String inputSecondNumber() {
        System.out.println("두 번째 숫자를 입력해주세요.");
        return scanner.next();
    }

    private String inputOperator() {
        System.out.println("연산자 (+, -, *, /)를 입력해주세요.");
        return scanner.next();
    }

    private Number parseNumber(final String numberStr) {
        if (numberStr.contains(".")) {
            return Double.parseDouble(numberStr);
        } else {
            return Integer.parseInt(numberStr);
        }
    }
}
