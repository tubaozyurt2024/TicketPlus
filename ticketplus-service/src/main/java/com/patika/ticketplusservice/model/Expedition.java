package com.patika.ticketplusservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@ToString
@Entity
@Getter
@Setter
@Table(name = "expedition")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "expedition"})
public class Expedition extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "company")
    private String company;

    private LocalDate departureDate;

    @ManyToOne
    @JoinColumn(name = "from_location_id")
    private Location from;

    @ManyToOne
    @JoinColumn(name = "to_location_id")
    private Location to;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @Column(name = "number_of_tickets_remaining")
    private Integer numberOfTicketsRemaining;
}
