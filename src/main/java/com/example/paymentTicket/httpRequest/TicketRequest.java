package com.example.paymentTicket.httpRequest;

import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TicketRequest {
    public String getStatus() throws IOException {
        HttpResponse response = Request.Get("http://localhost:8081/ticket/generateRandomStatus")
                .execute()
                .returnResponse();

        return EntityUtils.toString(response.getEntity(), "UTF-8");
    }
}
