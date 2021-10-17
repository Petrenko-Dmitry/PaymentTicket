package com.example.paymentTicket.converter;

import com.example.paymentTicket.dto.CreateTicketDto;
import com.example.paymentTicket.entity.Ticket;
import com.example.paymentTicket.entity.TicketStatus;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CrateTicketDtoToTicket implements Converter<CreateTicketDto, Ticket> {
    @Override
    public Ticket convert(CreateTicketDto createTicketDto) {
        Ticket ticket = new Ticket();
        ticket.setDateOfDeparture(createTicketDto.getDateOfDeparture());
        ticket.setNumberOfRoute(createTicketDto.getNumberOfRoute());
        ticket.setClientId(createTicketDto.getClientId());
        ticket.setStatus(TicketStatus.PROCESSED);

        return ticket;
    }
}
