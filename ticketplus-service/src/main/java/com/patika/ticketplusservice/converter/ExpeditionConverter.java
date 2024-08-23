package com.patika.ticketplusservice.converter;

import com.patika.ticketplusservice.model.Expedition;
import com.patika.ticketplusservice.request.ExpeditionRequest;
import com.patika.ticketplusservice.response.ExpeditionResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExpeditionConverter {

    public ExpeditionResponse convert(Expedition expedition) {
        return ExpeditionResponse.builder()
                .id(expedition.getId())
                .company(expedition.getCompany())
                .from(expedition.getFrom())
                .to(expedition.getTo())
                .departureDate(expedition.getDepartureDate())
                .numberOfTicketsRemaining(expedition.getNumberOfTicketsRemaining())
                .vehicle(expedition.getVehicle())
                .build();
    }

    public Expedition convert(ExpeditionRequest expeditionRequest) {
        return Expedition.builder()
                .company(expeditionRequest.getCompany())
                .from(expeditionRequest.getFrom())
                .to(expeditionRequest.getTo())
                .vehicle(expeditionRequest.getVehicle())
                .departureDate(expeditionRequest.getDepartureDate())
                .build();
    }

    public List<ExpeditionResponse> convert(List<Expedition> expeditions) {
        List<ExpeditionResponse> expeditionResponses = new ArrayList<>();
        expeditions.stream().forEach(expedition -> expeditionResponses.add(convert(expedition)));
        return expeditionResponses;
    }
}

