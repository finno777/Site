package ru.digdes.site.MyUI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Yaroslavtsev.I on 25.05.2017.
 */
@SpringBootApplication
@ComponentScan("ru.digdes.site")
public class App {
    public static void main(String[] args) {
            SpringApplication.run(App.class, args);
    }
}
