package com.patika.ticketplusservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.patika.ticketplusservice.model.enums.VehicleType;
import jakarta.persistence.*;
import lombok.*;

@ToString
@Builder
@Entity
@Getter
@Setter
@Table(name = "vehicle")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "vehicle"})
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "vehicle_type")
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Column(name = "capacity")
    private Integer capacity;
}
