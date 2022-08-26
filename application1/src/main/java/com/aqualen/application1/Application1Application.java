package com.aqualen.application1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class Application1Application {

  public static void main(String[] args) {
    SpringApplication.run(Application1Application.class, args);
  }

}
