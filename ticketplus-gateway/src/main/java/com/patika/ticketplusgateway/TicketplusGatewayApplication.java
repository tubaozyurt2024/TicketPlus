package com.patika.ticketplusgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TicketplusGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketplusGatewayApplication.class, args);
    }

}
