package com.patika.ticketplusservice.response;

import com.patika.ticketplusservice.model.enums.Gender;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PassengerResponse {

    private Integer id;

    private String firstName;

    private String lastName;

    private Gender gender;

    private String IdentificationId;
}
