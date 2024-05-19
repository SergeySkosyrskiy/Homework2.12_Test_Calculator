package pro.sky.com.example.calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CheckingForNull extends IllegalArgumentException {
        public CheckingForNull(){
        super("<h1>Ошибка!!! Введены не все данные!!!</h1>");
}
}