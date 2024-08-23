package com.patika.ticketplusservice.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationResponse {

    private Integer id;

    private String city;

    private String address;
}
