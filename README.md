#TicketPlus - Ticket Management System
## 📖 Overview
TicketPlus is a modern ticket management system built using microservices architecture. It allows users to efficiently manage ticket booking for various travel options. Leveraging Spring Boot, RabbitMQ, Redis, and PostgreSQL and and JWT (JSON Web Tokens), TicketPlus provides a robust and scalable solution for ticket management.

## 🚀 Features
- **Microservices Architecture**: Each component of the system operates independently, enhancing scalability and maintainability.
- **Service Discovery**: Utilizes Eureka for dynamic service registration and discovery.
- **API Gateway**: A centralized entry point for client requests, facilitating load balancing and routing.
- **Asynchronous Messaging**: RabbitMQ for efficient communication between microservices.
- **Data Persistence**: PostgreSQL as the primary relational database for managing ticket data.
- **JWT Authentication**: Secure user authentication and authorization using JWT, ensuring safe access to resources.
- **API Documentation**: Swagger UI for easy access to API endpoints and testing.

## 🏗️ Architecture
The TicketPlus system is composed of the following microservices:

1. **TicketPlus Service**

- Handles ticket-related operations.
- Port: 8080

2. **TicketPlus Payment Service**

- Manages payment transactions.
- Port: 8082

3. **TicketPlus Notification Service**

- Sends notifications for ticket bookings.
- Port: 9090

4. **TicketPlus Gateway**

- Acts as the API gateway.
- Port: 9090

5. **Eureka Server**

- Facilitates service registration and discovery.
- Port: 8761
  
## ⚙️ Getting Started
## Prerequisites
- Java 17 or higher
- PostgreSQL
- RabbitMQ
- Redis

## Installation
1. **Clone the repository**:
```bash
git clone https://github.com/yourusername/ticketplus.git
cd ticketplus
```
2. **Set up PostgreSQL databases**: Create the following databases:

- ticketplus-main
- ticketplus
- ticketplusnotification

3. **Configure application properties**: Update the ```bash application.properties ``` files in each microservice with the necessary database credentials,RabbitMQ settings and JWT configurations (such as secret key, issuer, and token expiration)..

4. **Run the services**: Start the services in the following order:
- **Eureka Server**:
```bash
cd ticketplus-eureka-server
mvn spring-boot:run
```
- **TicketPlus Services**:
```bash
cd ticketplus-service
mvn spring-boot:run

cd ../ticketplus-payment-service
mvn spring-boot:run

cd ../ticketplus-notification
mvn spring-boot:run

cd ../ticketplus-gateway
mvn spring-boot:run
```

## Usage
## Access Swagger UI:
- **TicketPlus Service**: http://localhost:8080/ticketplus-service
- **TicketPlus Payment Service**: http://localhost:8082/ticketplus-payment-service
- **TicketPlus Notification Service**: http://localhost:9090/ticketplus-notification
- **API Gateway**: http://localhost:9090/swagger-ui.html
