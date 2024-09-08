package level3.operation;

public interface Operation<T extends Number> {
    // 인터페이스로 추상화 로직
    T operate(T firstNumber, T secondNumber);
}
