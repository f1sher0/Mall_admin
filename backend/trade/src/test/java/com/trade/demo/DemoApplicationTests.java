package com.trade.demo;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        Faker faker = new Faker();

        for (int i = 1; i <= 30; i++) {
            String medicineName = faker.medical().medicineName();
            String nationalDrugCode = faker.number().digits(10);
            String supplierName = faker.company().name();
            String customerName = faker.name().fullName();

            System.out.println("药品 " + i);
            System.out.println("药名: " + medicineName);
            System.out.println("国药准字: " + nationalDrugCode);
            System.out.println("供应商名字: " + supplierName);
            System.out.println("客户名字: " + customerName);
            System.out.println("----------------------------------");
        }
    }

}
