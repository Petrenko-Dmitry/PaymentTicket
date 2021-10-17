package com.example.paymentTicket.repository;

import com.example.paymentTicket.entity.Ticket;
import com.example.paymentTicket.entity.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findTicketByStatus(TicketStatus status);
    List<Ticket> findByClientIdAndDateOfDepartureAfter(String clientId, LocalDateTime dateTime);
}
