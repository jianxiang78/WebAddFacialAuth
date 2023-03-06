package com.auto17;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * Startup class
 */


@Configuration
@SpringBootApplication
@MapperScan("com.auto17.WebAddFacialAuth.mapper")
public class AppWeb {

    public static void main(String[] args) {
        SpringApplication.run(AppWeb.class, args);
        System.out.println("************************************************\n");
        System.out.println("**** Web Add Facial Auth Start Successfully ****\n");
        System.out.println("************************************************\n");
    }

}
