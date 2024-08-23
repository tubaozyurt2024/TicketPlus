package com.patika.ticketpluspaymentservice.response;

import lombok.*;
import com.patika.ticketpluspaymentservice.model.enums.PaymentType;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {

    private Integer id;

    private Integer userId;

    private PaymentType paymentType;

    private Integer productId;
}
