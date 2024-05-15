package pro.sky.com.example.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.com.example.calculator.service.CalculatorServiceImpl;

@RestController
@RequestMapping//("/calculator")

public class CalculatorController {
    private final CalculatorServiceImpl calcService;

    public CalculatorController(CalculatorServiceImpl calcService) {
        this.calcService = calcService;
    }
    @GetMapping("/calculator")
    public String answerCalculator() {
        return "<h1>Добро пожаловать в калькулятор. <h1>";
    }

    private String message(int num1, int num2, char action, int result) {
        return String.format("<h1>%d %c %d = %d </h1>", num1, action, num2, result);
    }


    //    @GetMapping("/plus")
    @GetMapping("/calculator/plus")
    public String answerPlusCalculator(@RequestParam Integer num1, @RequestParam Integer num2) {
        if (num1 == null || num2 == null) {
            return "<h1>Ошибка!!! Введены не все данные!!!</h1>";
        } else {
            int result = calcService.sum(num1, num2);
            return message(num1, num2, '+', result);
        }
    }

    //    @GetMapping("/minus")
    @GetMapping("/calculator/minus")
    public String answerMinusCalculator(@RequestParam Integer num1, @RequestParam Integer num2) {
        if (num1 == null || num2 == null) {

            return "<h1>Ошибка!!! Введены не все данные!!!</h1>";
        } else {
            int result = calcService.subtract(num1, num2);
            return message(num1, num2, '-', result);
        }
    }


    //    @GetMapping("/multiply")
    @GetMapping("/calculator/multiply")
    public String answerMultiplyCalculator(@RequestParam Integer num1, @RequestParam Integer num2) {
        if (num1 == null || num2 == null) {
            return "<h1>Ошибка!!! Введены не все данные!!!</h1>";
        } else {
            int result = calcService.multiply(num1, num2);
            return message(num1, num2, '*', result);
        }
    }


    //    @GetMapping("/divide")
    @GetMapping("/calculator/divide")
    public String answerDividelyCalculator(@RequestParam Integer num1, @RequestParam Integer num2) {
        if (num1 == null || num2 == null) {
            return "<h1>Ошибка!!! Введены не все данные!!!</h1>";
        } else if (num2 == 0) {
            return "<h1>ОШИБКА!!! на 0 делить нельзя!!!</h1>";
        } else {
            int result = calcService.divide(num1, num2);
            return message(num1, num2, '/', result);
        }
    }
}
