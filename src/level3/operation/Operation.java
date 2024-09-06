package level3.operation;

public interface Operation<T extends Number> {
    T operate(T firstNumber, T secondNumber);
}
