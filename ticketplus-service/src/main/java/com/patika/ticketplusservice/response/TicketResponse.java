package com.patika.ticketplusservice.response;

import com.patika.ticketplusservice.model.Expedition;
import com.patika.ticketplusservice.model.PassengerInformation;
import com.patika.ticketplusservice.model.User;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponse {

    private Integer id;

    private Double price;

    private PassengerInformation passengerInformation;

    private Expedition expedition;

    private User user;

    private Boolean isEnable;
}
