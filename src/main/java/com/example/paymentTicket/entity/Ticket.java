package com.example.paymentTicket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientId;
    private Long numberOfRoute;
    private LocalDateTime dateOfDeparture;
    @Enumerated(EnumType.STRING)
    private TicketStatus status;
}
