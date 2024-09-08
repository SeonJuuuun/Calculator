package level3.view;

import java.util.Scanner;
import level3.exception.InvalidNumberException;
import level3.exception.InvalidOperatorException;

public class Input {

    private static final Scanner scanner = new Scanner(System.in);

    /*
    클래스가 모든 메서드를 static으로 선언한 유틸리티 클래스이므로
    인스턴스를 생성할 필요가 없으므로 생성자를 private로 만들어 인스턴스를 만들 수 없게 하는 로직
     */
    private Input() {
    }

    // 첫 번째 숫자를 입력 받는 로직
    public static String readFirstNumber() {
        final String input = scanner.next();
        // 숫자 형식인지 확인하는 메서드
        isValidNumber(input);
        return input;
    }

    // 두 번째 숫자를 입력 받는 로직
    public static String readSecondNumber() {
        final String input = scanner.next();
        // 숫자 형식인지 확인하는 메서드
        isValidNumber(input);
        return input;
    }


    // 연산자를 입력받는 로직
    public static String readOperator() {
        final String operator = scanner.next();
        // 올바른 연산자인지 확인하는 메서드
        isValidOperator(operator);
        return operator;
    }

    // 끝낼건지 계속할건지 입력받는 로직
    public static String readEnded() {
        return scanner.next();
    }

    // 숫자 형식인지 확인하는 메서드
    private static void isValidNumber(final String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException(input);
        }
    }

    // 올바른 연산자인지 확인하는 메서드
    private static void isValidOperator(String operator) {
        if (!operator.matches("[+\\-*/]")) {
            throw new InvalidOperatorException(operator);
        }
    }
}
