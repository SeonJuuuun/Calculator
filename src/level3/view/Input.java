package level3.view;

import java.util.Scanner;
import level3.exception.InvalidNumberException;
import level3.exception.InvalidOperatorException;

public class Input {

    private static final Scanner scanner = new Scanner(System.in);

    private Input() {
    }

    public static String readFirstNumber() {
        final String input = scanner.next();
        isValidNumber(input);
        return input;
    }

    public static String readSecondNumber() {
        final String input = scanner.next();
        isValidNumber(input);
        return input;
    }

    public static String readOperator() {
        final String operator = scanner.next();
        isValidOperator(operator);
        return operator;
    }

    public static String readEnded() {
        return scanner.next();
    }

    private static void isValidNumber(final String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException(input);
        }
    }

    private static void isValidOperator(String operator) {
        if (!operator.matches("[+\\-*/]")) {
            throw new InvalidOperatorException(operator);
        }
    }
}
