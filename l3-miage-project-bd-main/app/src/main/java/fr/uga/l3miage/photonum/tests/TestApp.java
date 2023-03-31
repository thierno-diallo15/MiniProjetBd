package fr.uga.l3miage.photonum.tests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApp {
    public static void main(String[] args) {
        SpringApplication.run(TestApp.class, args);
        System.out.println("-------PHOTONUM - BACK END STARTED------");
    }
}
