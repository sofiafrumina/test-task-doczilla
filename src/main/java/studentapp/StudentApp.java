package studentapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Эта аннотация говорит Spring Boot, что этот класс является точкой входа в приложение
public class StudentApp {

    public static void main(String[] args) {
        SpringApplication.run(StudentApp.class, args); // Здесь происходит запуск приложения
    }
}
