package pro.sky.com.example.calculator.service;

import org.springframework.stereotype.Service;
import pro.sky.com.example.calculator.exception.CheckingForNull;
import pro.sky.com.example.calculator.exception.DivisionByZeroException;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public int sum(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            throw new CheckingForNull();
        }
        return num1 + num2;
    }

    @Override
    public int subtract(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            throw new CheckingForNull();
        }
        return num1 - num2;
    }

    @Override
    public int multiply(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            throw new CheckingForNull();
        }
        return num1 * num2;
    }

    @Override
    public int divide(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            throw new CheckingForNull();
        }
        else if (num2 == 0) {
            throw new DivisionByZeroException();
        }
        return num1 / num2;
    }

    @Override
    public String answerCalculator() {
        return "<h1>Добро пожаловать в калькулятор. <h1>";
    }
}

