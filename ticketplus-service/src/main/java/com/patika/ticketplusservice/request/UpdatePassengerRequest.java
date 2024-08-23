package com.patika.ticketplusservice.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePassengerRequest {

    private String firstName;

    private String lastName;

    private String IdentificationId;
}
