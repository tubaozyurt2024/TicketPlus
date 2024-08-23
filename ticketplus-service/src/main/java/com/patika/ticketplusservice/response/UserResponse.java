package com.patika.ticketplusservice.response;

import com.patika.ticketplusservice.model.enums.Role;
import com.patika.ticketplusservice.model.enums.UserType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Integer id;

    private String email;

    private Role role;

    private UserType userType;

    private String phoneNumber;
}
