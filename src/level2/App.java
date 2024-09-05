package level2;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]+$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final Calculator calculator = new Calculator();

        while (true) {
            System.out.println("첫 번째 숫자를 입력해주세요 !!!");
            final String firstNumber = getValidNumber(scanner);

            System.out.println("두 번째 숫자를 입력해주세요 !!!");
            final String secondNumber = getValidNumber(scanner);

            System.out.println("사칙 연산을 입력해주세요.");
            final String operator = getValidOperator(scanner);

            try {
                final int answer = calculator.calculate(Integer.parseInt(firstNumber), Integer.parseInt(secondNumber),
                        operator);
                System.out.println("결과 : " + answer);
            } catch (IllegalArgumentException e) {
                System.out.println("에러: " + e.getMessage());
                continue;
            }

            System.out.println("지금까지의 결과 값의 맨 첫 번째를 삭제 하시겠습니까? (YES, NO)");
            final String command = scanner.next();
            if (command.equalsIgnoreCase("YES")) {
                calculator.removeResult();
            }

            System.out.println("총 연산 결과");
            final List<Integer> result = calculator.getResult();
            for (Integer idx : result) {
                System.out.println(idx);
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            final String ended = scanner.next();
            if (ended.equalsIgnoreCase("exit")) {
                break;
            }
        }
        scanner.close();
    }

    private static String getValidNumber(final Scanner scanner) {
        while (true) {
            try {
                String input = scanner.next();
                if (!Pattern.matches(NUMBER_REG, input)) {
                    throw new IllegalArgumentException("양의 정수만 입력이 가능합니다.");
                }
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String getValidOperator(final Scanner scanner) {
        while (true) {
            try {
                final String operator = scanner.next();
                if (!Pattern.matches(OPERATION_REG, operator)) {
                    throw new IllegalArgumentException("유효한 연산자를 입력해주세요. (+, -, *, /)");
                }
                return operator;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
