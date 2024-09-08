package level3;

import level3.calculator.ArithmeticCalculator;

public class App {
    public static void main(String[] args) {
        CalculatorMachine calculatorManager = new CalculatorMachine(new ArithmeticCalculator<>());
        calculatorManager.start();
    }
}
