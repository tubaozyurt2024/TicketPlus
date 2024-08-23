package com.patika.ticketplusservice.response;

import com.patika.ticketplusservice.model.Location;
import com.patika.ticketplusservice.model.Vehicle;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpeditionResponse {

    private Integer id;

    private String company;

    private LocalDate departureDate;

    private Location from;

    private Location to;

    private Vehicle vehicle;

    private Integer numberOfTicketsRemaining;
}
