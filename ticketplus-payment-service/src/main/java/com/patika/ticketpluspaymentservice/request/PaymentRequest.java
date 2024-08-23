package com.patika.ticketpluspaymentservice.request;

import lombok.*;
import com.patika.ticketpluspaymentservice.model.enums.PaymentType;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {

    private Integer userId;

    private String cardNumber;

    private PaymentType paymentType;

    private Integer productId;
}
