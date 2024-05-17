package com.trade.demo;

import com.github.javafaker.Faker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

//@EnableAutoConfiguration
@SpringBootApplication
//@ComponentScan
@Configuration
@MapperScan("com.trade.demo.mapper")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("你好~");
        Faker faker = new Faker(Locale.CHINA);

        for (int i = 1; i <= 30; i++) {
            String medicineName = faker.medical().medicineName();
            String nationalDrugCode =  faker.number().digits(8);
            String supplierName = faker.company().name();
            String customerName = faker.name().fullName();
             String team          =      faker.team().name();
            System.out.println("药品 " + i);
            System.out.println("药名: " + medicineName);
            System.out.println("国药准字: " + nationalDrugCode);
            System.out.println("供应商名字: " + supplierName);
            System.out.println("客户名字: " + customerName);
            System.out.println("team: " + team);

            System.out.println("----------------------------------");
        }
    }

}
