package com.patika.ticketplusservice.response;

import com.patika.ticketplusservice.model.enums.VehicleType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleResponse {

    private Integer id;

    private VehicleType vehicleType;

    private Integer capacity;
}
