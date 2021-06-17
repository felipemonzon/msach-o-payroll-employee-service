package com.rinku.payroll.employee.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MainRinkuPayRollApplication {

  public static void main(String[] args) {
    SpringApplication.run(MainRinkuPayRollApplication.class, args);
  }
}
