package com.patika.ticketpluspaymentservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.patika.ticketpluspaymentservice.request.PaymentRequest;
import com.patika.ticketpluspaymentservice.response.PaymentResponse;
import com.patika.ticketpluspaymentservice.service.PaymentService;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payments")
public class PaymentController {

    Logger logger = Logger.getLogger(PaymentController.class.getName());

    private final PaymentService paymentService;

    @PostMapping()
    public ResponseEntity<PaymentResponse> createPayment(@RequestBody PaymentRequest paymentRequest) throws Exception {
        PaymentResponse paymentResponse = paymentService.create(paymentRequest);
        logger.log(Level.INFO, "[PaymentController] -- payment created: " + paymentResponse);
        return ResponseEntity.ok(paymentResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> getById(@PathVariable Integer id) throws Exception {
        PaymentResponse paymentResponse = paymentService.getPayment(id);
        logger.log(Level.INFO, "[PaymentController] -- payment: " + paymentResponse);
        return ResponseEntity.ok(paymentResponse);
    }
}
