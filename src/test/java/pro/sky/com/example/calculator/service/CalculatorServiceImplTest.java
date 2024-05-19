package pro.sky.com.example.calculator.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.com.example.calculator.exception.CheckingForNull;
import pro.sky.com.example.calculator.exception.DivisionByZeroException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {
    CalculatorService calcService = new CalculatorServiceImpl();


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForCalculatorTest")
    public void shouldReturnCorrectResults(int num1, int num2) {
        assertEquals(num1 + num2, calcService.sum(num1, num2));
        assertEquals(num1 - num2, calcService.subtract(num1, num2));
        assertEquals(num1 * num2, calcService.multiply(num1, num2));
//        assertEquals(num1 / num2, calcService.divide(num1, num2));
//        assertThrows(DivisionByZeroException.class, () -> calcService.divide(num1, num2));
//        System.out.print(calcService.sum(num1,num2));
//        System.out.print(calcService.subtract(num1,num2));
//        System.out.print(calcService.multiply(num1,num2));

    }

    public static Stream<Arguments> provideArgumentsForCalculatorTest() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(-1, 1),
                Arguments.of(0, 1),
                Arguments.of(1, 0),
                Arguments.of(0, 0),
                Arguments.of(-1, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForCalculatorTestForDivide")
    public void shouldReturnCorrectResults1(int num1, int num2) {
        assertEquals(num1 / num2, calcService.divide(num1, num2));
//        assertThrows(DivisionByZeroException.class, () -> calcService.divide(num1, num2));
//        System.out.print(calcService.divide(num1, num2));
    }

    public static Stream<Arguments> provideArgumentsForCalculatorTestForDivide() {
        return Stream.of(
                Arguments.of(10, 2),
                Arguments.of(6, 3)
        );
    }


    @Test
    void exceptionForDivide() {
       Assertions.assertThrows(DivisionByZeroException.class, () -> calcService.divide(1, 0));
    }

    @Test
    void exceptionForNullArguments() {
        assertThrows(CheckingForNull.class, () -> calcService.sum(null, null));
        assertThrows(CheckingForNull.class, () -> calcService.subtract(null, null));
        assertThrows(CheckingForNull.class, () -> calcService.multiply(null, null));
        assertThrows(CheckingForNull.class, () -> calcService.divide(null, null));

    }

//    @Test
//    void sum() {
//        Assertions.assertEquals(4, calcService.sum(1, 3));
//    }
//
//
//    @Test
//    void subtract() {
//        Assertions.assertEquals(2, calcService.subtract(4, 2));
//    }
//
//    @Test
//    void multiply() {
//        Assertions.assertEquals(32, calcService.multiply(4, 8));
//    }
//    @Test
//    void divide() {
//        Assertions.assertEquals(2, calcService.divide(4, 2));
//    }

    @Test
    void answerCalculator() {
        assertEquals("<h1>Добро пожаловать в калькулятор. <h1>", calcService.answerCalculator());
    }
}