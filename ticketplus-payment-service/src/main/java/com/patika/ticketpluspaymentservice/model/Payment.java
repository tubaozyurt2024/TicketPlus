package com.patika.ticketpluspaymentservice.model;

import jakarta.persistence.*;
import lombok.*;
import com.patika.ticketpluspaymentservice.model.enums.PaymentType;

@Entity
@Builder
@ToString
@Table(name = "payment")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "payment_type")
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Column(name = "product_id")
    private Integer productId;
}
