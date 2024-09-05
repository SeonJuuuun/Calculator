package level2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Integer> result = new ArrayList<>();

    public int calculate(final int firstNumber, final int secondNumber, final String operator) {
        int answer = 0;
        switch (operator) {
            case "+" -> answer = firstNumber + secondNumber;
            case "-" -> answer = firstNumber - secondNumber;
            case "*" -> answer = firstNumber * secondNumber;
            case "/" -> {
                if (secondNumber == 0) {
                    throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
                }
                answer = firstNumber / secondNumber;
            }
        }
        result.add(answer);
        return answer;
    }
}
