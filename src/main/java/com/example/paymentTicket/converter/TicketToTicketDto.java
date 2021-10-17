package com.example.paymentTicket.converter;

import com.example.paymentTicket.dto.TicketDto;
import com.example.paymentTicket.entity.Ticket;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TicketToTicketDto implements Converter<Ticket, TicketDto> {
    @Override
    public TicketDto convert(Ticket ticket) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setClientId(ticket.getClientId());
        ticketDto.setDateOfDeparture(ticket.getDateOfDeparture());
        ticketDto.setStatus(ticket.getStatus());
        ticketDto.setId(ticket.getId());
        ticketDto.setNumberOfRoute(ticket.getNumberOfRoute());

        return ticketDto;
    }
}
