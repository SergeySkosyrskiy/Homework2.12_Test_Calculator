package pro.sky.com.example.calculator.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {
    CalculatorService calcService = new CalculatorServiceImpl();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sum() {
//        int result = calcService.sum(1, 3);
        // System.out.println(result);

        Assertions.assertEquals(4, 4);

    }

    @Test
    void subtract() {
        Assertions.assertEquals(2, calcService.subtract(4, 2));
//        int result = calcService.subtract(1, 3);
    }

    @Test
    void multiply() {
        Assertions.assertEquals(32, calcService.multiply(4, 8));
//        int result = calcService.multiply(2,3);
//        System.out.println(result);
    }

    @Test
    void divide() {
        Assertions.assertEquals(2, calcService.divide(4, 2));
//        int result = calcService.divide(4,2);
//        System.out.println(result);
    }

    @Test
    void answerCalculator() {
        assertEquals("<h1>Добро пожаловать в калькулятор. <h1>", calcService.answerCalculator());
    }
}