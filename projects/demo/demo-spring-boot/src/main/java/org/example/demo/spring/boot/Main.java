package org.example.demo.spring.boot;

import lombok.extern.slf4j.Slf4j;
import org.example.acme.AcmeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        log.info(context.toString());
        context.getBean(AcmeService.class).logging();
    }
}
