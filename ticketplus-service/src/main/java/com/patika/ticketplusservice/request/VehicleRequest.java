package com.patika.ticketplusservice.request;

import com.patika.ticketplusservice.model.enums.VehicleType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequest {

    private VehicleType vehicleType;

    private Integer capacity;
}
