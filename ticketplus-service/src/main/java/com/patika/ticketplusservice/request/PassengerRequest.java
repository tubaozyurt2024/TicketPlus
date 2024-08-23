package com.patika.ticketplusservice.request;

import com.patika.ticketplusservice.model.enums.Gender;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PassengerRequest {

    private String firstName;

    private String lastName;

    private Gender gender;

    private String IdentificationId;

}