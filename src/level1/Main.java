package level1;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
        sc.close();
    }
}
