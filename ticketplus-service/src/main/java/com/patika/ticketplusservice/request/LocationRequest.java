package com.patika.ticketplusservice.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationRequest {

    private String city;

    private String address;
}
