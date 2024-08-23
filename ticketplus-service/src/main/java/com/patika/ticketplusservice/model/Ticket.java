package com.patika.ticketplusservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@Builder
@Getter
@Setter
@Table(name = "ticket")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "ticket"})
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "expedition_id", nullable = false)
    private Expedition expedition;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passenger_information_id", referencedColumnName = "id")
    private PassengerInformation passengerInformation;

    @Column(name = "is_Enable")
    private Boolean isEnable;

    @ManyToOne
    @JoinColumn(name = "confirmation_id")
    private Confirmation confirmation;
}
