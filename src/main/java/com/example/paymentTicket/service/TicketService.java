package com.example.paymentTicket.service;

import com.example.paymentTicket.converter.CrateTicketDtoToTicket;
import com.example.paymentTicket.converter.TicketToTicketDto;
import com.example.paymentTicket.dto.CreateTicketDto;
import com.example.paymentTicket.dto.TicketDto;
import com.example.paymentTicket.entity.Ticket;
import com.example.paymentTicket.entity.TicketStatus;
import com.example.paymentTicket.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final CrateTicketDtoToTicket crateTicketDtoToTicket;
    private final TicketToTicketDto ticketToTicketDto;

    public TicketService(TicketRepository ticketRepository,
                         CrateTicketDtoToTicket crateTicketDtoToTicket,
                         TicketToTicketDto ticketToTicketDto) {
        this.ticketRepository = ticketRepository;
        this.crateTicketDtoToTicket = crateTicketDtoToTicket;
        this.ticketToTicketDto = ticketToTicketDto;
    }

    public Long save(CreateTicketDto createTicketDto) {
        return ticketRepository.save(Objects.requireNonNull(crateTicketDtoToTicket.convert(createTicketDto))).getId();
    }

    public void save(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public String checkStatus(Long id) {
        return Objects.requireNonNull(ticketRepository.findById(id).orElse(null)).getStatus().toString();
    }

    public List<Ticket> findTicketByStatus(TicketStatus status) {
        return ticketRepository.findTicketByStatus(status);
    }

    public List<TicketDto> findByClientIdAndDate(String clientId, LocalDateTime date) {
        List<Ticket> tickets = ticketRepository.findByClientIdAndDateOfDepartureAfter(clientId, date);
        List<TicketDto> ticketsDto = tickets.stream().map(ticketToTicketDto::convert).collect(Collectors.toList());
        ticketsDto.sort(Comparator.comparing(TicketDto::getDateOfDeparture));
        return ticketsDto;
    }
}
