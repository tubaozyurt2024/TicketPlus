package com.patika.ticketplusservice.request;

import com.patika.ticketplusservice.model.Expedition;
import com.patika.ticketplusservice.model.PassengerInformation;
import com.patika.ticketplusservice.model.User;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequest {

    private PassengerInformation passengerInformation;

    private Expedition expedition;

    private User user;

}