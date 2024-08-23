package com.patika.ticketplusservice.request;

import com.patika.ticketplusservice.model.Location;
import com.patika.ticketplusservice.model.Vehicle;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpeditionRequest {

    private String company;

    private LocalDate departureDate;

    private Location from;

    private Location to;

    private Vehicle vehicle;
}
