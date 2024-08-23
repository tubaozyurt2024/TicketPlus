package com.patika.ticketpluspaymentservice.converter;

import com.patika.ticketpluspaymentservice.model.Payment;
import org.springframework.context.annotation.Configuration;
import com.patika.ticketpluspaymentservice.response.PaymentResponse;
import com.patika.ticketpluspaymentservice.request.PaymentRequest;

@Configuration
public class PaymentConverter {

    public PaymentResponse convert(Payment payment) {
        return PaymentResponse.builder()
                .id(payment.getId())
                .paymentType(payment.getPaymentType())
                .productId(payment.getProductId())
                .userId(payment.getUserId())
                .build();
    }

    public Payment convert(PaymentRequest request) {
        return Payment.builder()
                .cardNumber(request.getCardNumber())
                .paymentType(request.getPaymentType())
                .userId(request.getUserId())
                .productId(request.getProductId())
                .build();
    }
}
