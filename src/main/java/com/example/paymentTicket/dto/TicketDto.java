package com.example.paymentTicket.dto;

import com.example.paymentTicket.entity.TicketStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketDto {
    private Long id;
    private String clientId;
    private Long numberOfRoute;
    private LocalDateTime dateOfDeparture;
    private TicketStatus status;
}
