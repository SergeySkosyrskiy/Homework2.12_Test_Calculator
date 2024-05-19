package pro.sky.com.example.calculator.service;

public interface CalculatorService {
    int sum(Integer num1, Integer num2);

    int subtract(Integer num1, Integer num2);

    int multiply(Integer num1, Integer num2);

    int divide(Integer num1, Integer num2);

    String answerCalculator();
}
