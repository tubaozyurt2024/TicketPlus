package com.patika.ticketplusservice.converter;

import com.patika.ticketplusservice.model.Ticket;
import com.patika.ticketplusservice.request.TicketRequest;
import com.patika.ticketplusservice.response.TicketResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketConverter {

    public TicketResponse convert(Ticket ticket) {
        return TicketResponse.builder()
                .id(ticket.getId())
                .price(ticket.getPrice())
                .passengerInformation(ticket.getPassengerInformation())
                .expedition(ticket.getExpedition())
                .user(ticket.getUser())
                .isEnable(ticket.getIsEnable())
                .build();

    }

    public Ticket convert(TicketRequest ticketRequest) {
        return Ticket.builder()
                .passengerInformation(ticketRequest.getPassengerInformation())
                .expedition(ticketRequest.getExpedition())
                .user(ticketRequest.getUser())
                .build();
    }

    public List<TicketResponse> convert(List<Ticket> tickets) {
        List<TicketResponse> ticketResponses = new ArrayList<>();
        tickets.stream().forEach(ticket -> ticketResponses.add(convert(ticket)));
        return ticketResponses;
    }
}
