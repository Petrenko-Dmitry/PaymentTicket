package com.example.paymentTicket.entity;

import java.util.Random;

public enum TicketStatus {
    PROCESSED,
    ERROR,
    COMPLETED;

    public static TicketStatus generateRandomStatus() {
        TicketStatus[] statuses = TicketStatus.values();
        int length = statuses.length;
        int randomIndex = 0;
        randomIndex = new Random().nextInt(length);
        return statuses[randomIndex];
    }
}
