package com.intentsg.service.ticket.service;

import com.intentsg.service.ticket.model.Ticket;

import java.util.List;

public interface TicketService {
    Ticket getTicketById(int id);
    List<Ticket> getAllTickets();
    List<Ticket> getTicketsByUserId(int userId);
}
