package com.mammadli.user_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.mammadli.user_crud.mapper"})
public class UserCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCrudApplication.class, args);
    }

}
