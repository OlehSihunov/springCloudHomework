package com.intentsg.service.ticket.service;

import com.intentsg.service.ticket.model.Ticket;
import com.intentsg.service.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketServiceImpl implements TicketService{
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Ticket getTicketById(int id) {
        return ticketRepository.findById(id).get();
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public List<Ticket> getTicketsByUserId(int userId) {
        return ticketRepository.findAll().stream().filter(ticket -> ticket.getUserId()==userId).collect(Collectors.toList());
    }
}
