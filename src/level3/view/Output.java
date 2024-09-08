package level3.view;

import java.util.List;
import java.util.stream.Collectors;

public class Output {

    private Output() {
    }

    public static void printFirstNumber() {
        System.out.println("첫 번째 숫자를 입력해주세요.");
    }

    public static void printSecondNumber() {
        System.out.println("두 번째 숫자를 입력해주세요.");
    }

    public static void printOperator() {
        System.out.println("연산자 (+, -, *, /)를 입력해주세요.");
    }

    public static void printEndedMessage() {
        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
    }

    public static void printCalculationResult(final Number answer) {
        System.out.println("-----------------");
        System.out.println("결과 : " + answer);
        System.out.println("-----------------");
    }

    public static void printFilteredResults(final List<Number> filteredResults) {
        final String result = filteredResults.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("-----------------");
        System.out.println("입력한 숫자보다 큰 결과 : " + result);
    }

    public static void printAllHistory(final List<Number> history) {
        final String totalResult = history.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("-----------------");
        System.out.println("총 결과값 저장 히스토리: " + totalResult);
        System.out.println("-----------------");
    }
}
