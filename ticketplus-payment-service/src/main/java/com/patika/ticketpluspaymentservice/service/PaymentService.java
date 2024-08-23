package com.patika.ticketpluspaymentservice.service;

import com.patika.ticketpluspaymentservice.converter.PaymentConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.patika.ticketpluspaymentservice.model.Payment;
import org.springframework.stereotype.Service;
import com.patika.ticketpluspaymentservice.repository.PaymentRepository;
import com.patika.ticketpluspaymentservice.request.PaymentRequest;
import com.patika.ticketpluspaymentservice.response.PaymentResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {

    private final PaymentRepository paymentRepository;

    private final PaymentConverter converter;

    public PaymentResponse create(PaymentRequest paymentRequest) throws Exception {
        if (paymentRequest.getUserId() != null && paymentRequest.getProductId() != null) {
            Payment toSave = paymentRepository.save(converter.convert(paymentRequest));
            return converter.convert(toSave);
        }
        throw new Exception("PaymentRequest userId and productId cannot be null. ");
    }

    public PaymentResponse getPayment(Integer id) throws Exception {
        Payment payment = paymentRepository.findById(id).orElseThrow();
        return converter.convert(payment);
    }
}
