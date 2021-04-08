package com.intentsg.service.ticket.model;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tickets")
@Component
@Scope("prototype")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id" )
    int ticketId;
    @Column(name = "hall_number")
    int hallNumber; // зал в якому буде проводитись вистава
    @Column(name = "place_number")
    int placeNumber; // номер місця
    @Column(name = "date")
    Date date;
    @Column(name = "user_id")
    int userId;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
