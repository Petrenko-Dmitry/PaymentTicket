package com.example.paymentTicket.scheduler;

import com.example.paymentTicket.entity.Ticket;
import com.example.paymentTicket.entity.TicketStatus;
import com.example.paymentTicket.httpRequest.TicketRequest;
import com.example.paymentTicket.service.TicketService;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class TicketScheduler {
    private final TicketService ticketService;
    private final TicketRequest ticketRequest;

    public TicketScheduler(TicketService ticketService, TicketRequest ticketRequest) {
        this.ticketService = ticketService;
        this.ticketRequest = ticketRequest;
    }

    @Scheduled(cron = "* /1 * * * ?")
    public void updateStatus() throws IOException {
        List<Ticket> tickets = ticketService.findTicketByStatus(TicketStatus.PROCESSED);
        for (Ticket ticket : tickets) {
            String status = ticketRequest.getStatus();
            log.info("Try change status for ticket: " + ticket.getId());
            try {
                if (!Strings.isNullOrEmpty(status)) {
                    ticket.setStatus(TicketStatus.valueOf(status));
                    ticketService.save(ticket);
                    log.info("processing ticket:" + ticket.getId() + " set status:" + status);
                }
            } catch (Exception e) {
                log.error("Not processing ticket" + ticket.getId());
            }
        }
    }
}
