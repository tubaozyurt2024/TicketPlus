package com.patika.ticketplusservice.client;

import com.patika.ticketplusservice.client.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private Integer userId;

    private Integer productId;

    private PaymentType paymentType;

    private String cardNumber;
}
