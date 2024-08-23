package com.patika.ticketplusservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.patika.ticketplusservice.model.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

@ToString
@Builder
@Entity
@Getter
@Setter
@Table(name = "passengerInformation")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "passengerInformation"})
public class PassengerInformation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "identify_id")
    private String IdentificationId;
}
