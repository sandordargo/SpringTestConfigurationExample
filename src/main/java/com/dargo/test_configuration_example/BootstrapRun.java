package com.dargo.test_configuration_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.PrintStream;

@SpringBootApplication
@Configuration
public class BootstrapRun {

  @Bean
  public PrintStream getPrintStream() {
    return System.out;
  }

  public static void main(String[] args) {
    SpringApplication.run(BootstrapRun.class, args);
  }
}
