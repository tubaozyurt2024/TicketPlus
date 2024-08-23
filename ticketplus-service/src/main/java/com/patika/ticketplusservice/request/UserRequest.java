package com.patika.ticketplusservice.request;

import com.patika.ticketplusservice.model.enums.Role;
import com.patika.ticketplusservice.model.enums.UserType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String email;

    private String password;

    private UserType userType;

    private String phoneNumber;

    private Role role;
}
