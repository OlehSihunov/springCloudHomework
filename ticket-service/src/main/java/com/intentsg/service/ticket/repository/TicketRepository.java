package com.intentsg.service.ticket.repository;

import com.intentsg.service.ticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {

}
