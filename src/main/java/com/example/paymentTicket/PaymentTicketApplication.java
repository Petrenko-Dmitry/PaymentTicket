package com.example.paymentTicket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PaymentTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentTicketApplication.class, args);
    }
}
