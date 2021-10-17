package com.example.paymentTicket.controller;

import com.example.paymentTicket.dto.CreateTicketDto;
import com.example.paymentTicket.dto.TicketDto;
import com.example.paymentTicket.entity.TicketStatus;
import com.example.paymentTicket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RequestMapping(value = "/ticket")
@RestController
@Validated
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/save")
    public Long save(@RequestBody @Valid CreateTicketDto createTicketDto) {
        return ticketService.save(createTicketDto);
    }

    @GetMapping("/checkStatus")
    public String checkStatus(@RequestParam Long id) {
        return ticketService.checkStatus(id);
    }

    @GetMapping("/generateRandomStatus")
    public String generateRandomStatus() {
        return TicketStatus.generateRandomStatus().toString();
    }

    @GetMapping("/findByClientIdDate")
    public List<TicketDto> findByClientIdAndDate(@RequestParam String clientId) {
        return ticketService.findByClientIdAndDate(clientId, LocalDateTime.now());
    }
}
