package io.mitts.houisegame.service;

import java.util.Collection;

import io.mitts.houisegame.model.Ticket;

public interface TicketService {

	public Ticket generateTicket(Collection<Ticket> excludedTickets);
}
