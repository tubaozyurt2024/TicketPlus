package com.patika.ticketplusservice.converter;

import com.patika.ticketplusservice.model.Location;
import com.patika.ticketplusservice.request.LocationRequest;
import com.patika.ticketplusservice.response.LocationResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LocationConverter {

    public LocationResponse convert(Location location) {
        return LocationResponse.builder()
                .id(location.getId())
                .city(location.getCity())
                .address(location.getAddress())
                .build();
    }

    public Location convert(LocationRequest locationRequest) {
        return Location.builder()
                .address(locationRequest.getAddress())
                .city(locationRequest.getCity())
                .build();
    }

    public List<LocationResponse> convert(List<Location> locations) {
        List<LocationResponse> locationResponses = new ArrayList<>();
        locations.stream().forEach(location -> locationResponses.add(convert(location)));
        return locationResponses;
    }
}
