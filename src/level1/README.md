## 🔔사칙 연산 계산기 프로그램

### 프로젝트 개요
이 프로젝트는 Java로 구현된 기본 계산기 프로그램입니다. 두 개의 양의 정수와 사칙연산 기호(덧셈, 뺄셈, 곱셈, 나눗셈)를 입력받아 계산을 수행하며, 사용자가 "exit"을 입력할 때까지 반복적으로 계산을 수행합니다.

### 주요 기능
#### 입력 처리:

두 개의 양의 정수(0 포함)를 입력받습니다.
사칙연산 기호(+, -, *, /)를 입력받습니다.
정규식을 사용하여 입력을 유효성 검사하고, 잘못된 입력에 대해 오류 메시지를 출력합니다.
#### 사칙연산 수행:

덧셈, 뺄셈, 곱셈, 나눗셈을 수행합니다.
나눗셈에서 0으로 나누는 경우, 예외 처리로 오류 메시지를 제공합니다.
#### 사용자 상호작용:

사용자가 "exit"을 입력하기 전까지 계속해서 계산을 반복할 수 있습니다.
연산 후 결과를 출력하고, 잘못된 입력이나 계산 오류가 발생하면 해당 오류 메시지를 출력합니다.




### ⚙️요구 사항 정리
  - [x] 양의 정수(0 포함)를 2개 입력받기
    - [x] 정수형이 아니면 예외가 발생하고 그 부분부터 다시 입력을 한다.
  - [x] 사칙연산 기호(+, -, *, /)를 입력받기
    - [x] 사칙연산을 제외하고 다른 문자가 들어오면 예외가 발생하고 다시 그 부분부터 입력을 받는다.
  - [x] 위에서 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한다.
    - [x] 나눗셈 연산에서 분모(두번째 정수)에 0이 입력되면 예외가 발생하고 처음부터 다시 시작을 한다.
  - [x] 결과값을 출력한다.
  - [x] "exit" 문자열이 입력되기 전까지 무한으로 계산을 진행한다.
        
### 클래스 설명
#### App 클래스
이 클래스는 프로그램의 진입점으로, 계산기의 전체 흐름을 제어합니다. 주요 메서드는 다음과 같습니다:

#### main 메서드:

프로그램의 루프를 통해 사용자로부터 숫자와 연산자를 입력받습니다.
각 입력값은 유효성 검사를 거친 후, 사칙연산을 수행합니다.
사용자가 exit을 입력할 때까지 반복됩니다.
#### getValidNumber 메서드:

사용자로부터 입력받은 값이 양의 정수인지 확인합니다.
정수 외의 값이 입력되면 오류 메시지를 출력하고 다시 입력을 요구합니다.
#### getValidOperator 메서드:

사칙연산 기호(+, -, *, /)를 입력받아 유효성을 검사합니다.
유효하지 않은 연산자가 입력되면 오류 메시지를 출력하고 다시 입력을 요구합니다.
#### calculate 메서드:

사칙연산을 수행합니다.
나눗셈에서 0으로 나누는 경우 IllegalArgumentException을 발생시켜 오류 메시지를 출력합니다.
