package com.javastart.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Нужно написать приложение, которое будет создавать Account с параметрами пользователя
 * и счетом Bill
 *
 * Так же нужно будет уметь принимать платежи Payment и пополнение счета Adjustment
 *
 * И реализовать метод перевода денег с одного Account на другой (Transfer) в отдельном контроллере
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
