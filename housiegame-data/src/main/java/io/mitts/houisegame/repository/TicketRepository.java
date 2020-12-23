package io.mitts.houisegame.repository;

import org.springframework.data.repository.CrudRepository;

import io.mitts.houisegame.model.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

}
