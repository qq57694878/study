package com.ljl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

@SpringBootApplication
public class VjsptestApplication {

    public static void main(String[] args) {
        SpringApplication.run(VjsptestApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        FileFilter java = (File f) -> f.getName().endsWith("*.java");
        new Thread(() -> {
            System.out.println("111");
        }).start();
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
}
