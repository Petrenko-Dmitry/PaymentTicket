package com.example.paymentTicket.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class CreateTicketDto {
    @NotNull
    private Long numberOfRoute;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateOfDeparture;
    @NotNull
    @NotBlank
    private String clientId;
}
