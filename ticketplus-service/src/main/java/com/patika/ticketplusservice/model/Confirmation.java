package com.patika.ticketplusservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@ToString
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "confirmation")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "confirmation"})
public class Confirmation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "confirmation")
    private List<Ticket> ticketList;
}
