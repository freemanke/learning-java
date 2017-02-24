package com;

import com.runners.PrintCurrentTimeRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) 24/02/2017
 */

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public PrintCurrentTimeRunner getPPrintCurrentTimeRunner() {
        return  new PrintCurrentTimeRunner();
    }
}
