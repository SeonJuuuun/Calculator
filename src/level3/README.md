### **프로젝트 개요**

이 프로젝트는 Java로 구현된 계산기 프로그램으로, 사용자가 두 개의 양의 정수와 사칙연산 기호를 입력하여 계산을 수행할 수 있습니다. 이 계산기는 여러 기능을 제공하며, 사용자가 프로그램을 종료할 때까지 반복적으로 사용할 수 있습니다.

### **주요 기능**

1. **입력 처리**:
    - **정수 입력**: 두 개의 양의 정수를 입력받습니다.
    - **연산자 입력**: 사칙연산 기호(`+`, ``, ``,`*`, `/`)를 입력받습니다.
    - **입력 검증**: 입력값이 유효한 숫자와 연산자인지 검사하고, 잘못된 입력에 대해 오류 메시지를 출력합니다.
2. **사칙연산 수행 및 결과 저장**:
    - **연산 수행**: 덧셈, 뺄셈, 곱셈, 나눗셈을 수행합니다.
    - **결과 저장**: 계산 결과를 리스트에 저장합니다.
    - **예외 처리**: 나눗셈에서 0으로 나누는 경우 예외를 발생시켜 오류 메시지를 출력합니다.
3. **결과 관리**:
    - **필터링**: 입력받은 두 수 중 큰 값보다 큰 결과값을 필터링하여 출력합니다.
    - **결과 출력**: 저장된 모든 결과를 출력합니다.
4. **사용자 상호작용**:
    - **계속 진행**: 사용자가 "exit"을 입력하기 전까지 계속해서 계산을 반복할 수 있습니다.
  

## **클래스 정리**

### **1. ArithmeticCalculator 클래스**

- **설명**: 제네릭을 활용하여 다양한 숫자 타입을 처리할 수 있는 사칙연산 계산기 클래스입니다. 결과를 저장하고, 저장된 결과 중 특정 조건을 만족하는 결과를 필터링합니다.
- **주요 메서드**:
    - `public T calculate(final T firstNumber, final T secondNumber, final String operatorStr)`: 두 숫자와 연산자를 받아서 계산을 수행하고 결과를 저장합니다.
    - `public List<T> getResultsGreaterThanInputNumbers(final T firstNumber, final T secondNumber)`: 입력받은 두 숫자 중 큰 값보다 큰 저장된 결과를 필터링하여 반환합니다.
    - `public List<T> getHistory()`: 저장된 모든 계산 결과를 반환합니다.

### **2. CalculatorMachine 클래스**

- **설명**: 사용자와의 상호작용을 관리하며 계산 요청을 처리하는 메인 클래스입니다. 사용자 입력을 받고, `ArithmeticCalculator`를 사용하여 계산을 수행합니다.
- **주요 메서드**:
    - `public void start()`: 계산을 반복적으로 수행하며 사용자 입력을 처리합니다.
    - `private String inputFirstNumber()`, `private String inputSecondNumber()`, `private String inputOperator()`, `private String inputEnded()`: 각각 첫 번째 숫자, 두 번째 숫자, 연산자, 종료 여부를 입력받습니다.
    - `private Number parseNumber(final String numberStr)`: 문자열을 숫자로 변환합니다.
    - `private <T> T repeat(Supplier<T> inputReader)`: 입력 중 예외가 발생할 경우 재시도합니다.

### **3. App 클래스**

- **설명**: 애플리케이션의 진입점으로, `CalculatorMachine`을 인스턴스화하고 계산기를 실행합니다.
- **주요 메서드**:
    - `public static void main(String[] args)`: `CalculatorMachine` 인스턴스를 생성하고 `start()` 메서드를 호출하여 프로그램을 시작합니다.

### **4. Input 클래스**

- **설명**: 사용자로부터 입력을 받는 유틸리티 클래스입니다. 입력 값의 유효성을 검사합니다.
- **주요 메서드**:
    - `public static String readFirstNumber()`: 첫 번째 숫자를 입력받고 검증합니다.
    - `public static String readSecondNumber()`: 두 번째 숫자를 입력받고 검증합니다.
    - `public static String readOperator()`: 연산자를 입력받고 검증합니다.
    - `public static String readEnded()`: 종료 여부를 입력받습니다.
    - `private static void isValidNumber(final String input)`: 입력 값이 숫자인지 확인합니다.
    - `private static void isValidOperator(final String operator)`: 입력 값이 유효한 연산자인지 확인합니다.

### **5. Output 클래스**

- **설명**: 사용자에게 메시지를 출력하는 유틸리티 클래스입니다.
- **주요 메서드**:
    - `public static void printFirstNumber()`, `public static void printSecondNumber()`, `public static void printOperator()`, `public static void printEndedMessage()`: 사용자에게 입력을 요구하는 메시지를 출력합니다.
    - `public static void printCalculationResult(final Number answer)`: 계산 결과를 출력합니다.
    - `public static void printFilteredResults(final List<Number> filteredResults)`: 필터링된 결과를 출력합니다.
    - `public static void printAllHistory(final List<Number> history)`: 모든 계산 결과 히스토리를 출력합니다.

### **6. Exception 패키지**

- **설명**: 사용자 정의 예외 클래스입니다.
- **주요 클래스**:
    - `AppException`: 기본 사용자 정의 예외 클래스.
    - `DivisionByZeroException`: 나눗셈에서 0으로 나눌 때 발생하는 예외.
    - `InvalidNumberException`: 숫자가 아닌 입력에 대해 발생하는 예외.
    - `InvalidOperatorException`: 유효하지 않은 연산자에 대해 발생하는 예외.

### **7. Operation 인터페이스 및 구현체**

- **설명**: 연산을 수행하기 위한 인터페이스와 그 구현체들입니다.
- **주요 인터페이스**:
    - `Operation<T extends Number>`: 제네릭 연산 인터페이스로 두 숫자를 받아 연산을 수행합니다.
- **주요 구현체**:
    - `AddOperation`: 덧셈 연산을 수행합니다.
    - `SubtractOperation`: 뺄셈 연산을 수행합니다.
    - `MultiplyOperation`: 곱셈 연산을 수행합니다.
    - `DivideOperation`: 나눗셈 연산을 수행하며, 0으로 나누는 경우 예외를 처리합니다.

### **8. OperatorType Enum**

- **설명**: 연산자와 그에 따른 연산 구현체를 매핑하는 열거형입니다.
- **주요 메서드**:
    - `public static Operation<Number> from(final String operator)`: 문자열 연산자를 받아서 해당 연산자에 맞는 `Operation` 객체를 반환합니다.
    - `public Operation<Number> getOperation()`: 연산자에 해당하는 `Operation` 객체를 반환합니다.



### 요구사항 정리
- [x] Enum 타입을 활용하여 연산자 정보를 관리한다.
- [x] Enum 타입을 ArithmeticCalculator 클래스에 활용한다.
- [x] 실수, 즉 double 타입의 값을 전달 받아도 연산이 수행하도록 만들기.
- [x] 피연산자를 여러 타입으로 받을 수 있도록 기능을 확장
- [x] ArithmeticCalculator 클래스 수정 (제네릭)
- [x] 저장된 연산 결과들 중 Scanner로 입력받은 값보다 더 큰 결과값 들을 출력
  - [x] ArithmeticCalculator 클래스에 위 요구사항을 만족하는 조회 메서드를 구현한다. (Lambda & Stream)
- [x] 꼼꼼한 예외처리 하기
  - [x] 나눗셈을 할 때 분모가 0이면 DivisionByZeroException 예외가 발생한다.
  - [x] 첫 번째 숫자와 두 번째 숫자가 숫자 형식이 아니면 InvalidNumberException 예외가 발생한다.
  - [x] 연산자를 입력할 때 올바르지 않은 연산자를 입력하면 InvalidOperatorException 예외가 발생한다.
