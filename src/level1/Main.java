package level1;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    public static void main(String[] args) {
        boolean command = true;
        Scanner sc = new Scanner(System.in);

        while (command) {
            System.out.println("첫 번째 숫자를 입력해주세요.");
            final String firstNumber = sc.next();
            if (!Pattern.matches(NUMBER_REG, firstNumber)) {
                throw new IllegalArgumentException("양의 정수만 입력이 가능합니다.");
            }

            System.out.println("두 번째 숫자를 입력해주세요.");
            final String secondNumber = sc.next();
            if (!Pattern.matches(NUMBER_REG, secondNumber)) {
                throw new IllegalArgumentException("양의 정수만 입력이 가능합니다.");
            }

            System.out.println("사칙 연산을 입력해주세요.");
            final String operator = sc.next();
            if (!Pattern.matches(OPERATION_REG, operator)) {
                throw new IllegalArgumentException("사칙 연산중 하나만 입력해주세요.");
            }

            int answer = switch (operator) {
                case "+" -> Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
                case "-" -> Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber);
                case "*" -> Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber);
                case "/" -> {
                    if (Integer.parseInt(secondNumber) == 0) {
                        throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
                    }
                    yield Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber);
                }
                default -> 0;
            };

            System.out.println("결과 : " + answer);
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String ended = sc.next();
            if (ended.equalsIgnoreCase("exit")) {
                command = false;
            }
        }
        sc.close();
    }
}
