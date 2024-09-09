package level3.view;

import java.util.List;
import java.util.stream.Collectors;

public class Output {

    /*
    클래스가 모든 메서드를 static으로 선언한 유틸리티 클래스이므로
    인스턴스를 생성할 필요가 없으므로 생성자를 private로 만들어 인스턴스를 만들 수 없게 하는 로직
    */
    private Output() {
    }

    // 첫 번째 숫자 입력 요구 메세지
    public static void printFirstNumber() {
        System.out.println("첫 번째 숫자를 입력해주세요.");
    }

    // 두 번째 숫자 입력 요구 메세지
    public static void printSecondNumber() {
        System.out.println("두 번째 숫자를 입력해주세요.");
    }

    // 연산자 입력 요구 메세지
    public static void printOperator() {
        System.out.println("연산자 (+, -, *, /)를 입력해주세요.");
    }

    // 더 계산할건지 물어보는 메서지
    public static void printEndedMessage() {
        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
    }

    // 계산 결과 출력 메세지
    public static void printCalculationResult(final Number answer) {
        System.out.println("-----------------");
        System.out.println("결과 : " + answer);
    }

    // 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값 들을 출력하는 메세지
    public static void printFilteredResults(final List<Number> filteredResults) {
        final String result = filteredResults.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("-----------------");
        System.out.println("입력한 숫자보다 큰 결과 : " + result);
    }

    // 총 결과 값 저장 히스토리 출력 메세지
    public static void printAllHistory(final List<Number> history) {
        final String totalResult = history.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("-----------------");
        System.out.println("총 결과값 저장 히스토리: " + totalResult);
        System.out.println("-----------------");
    }
}
