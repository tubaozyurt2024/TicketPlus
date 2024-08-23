package com.patika.ticketpluseurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TicketplusEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketplusEurekaServerApplication.class, args);
    }

}
