package io.mitts.houisegame.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mitts.houisegame.dto.PlayerDTO;
import io.mitts.houisegame.model.Game;
import io.mitts.houisegame.model.Player;
import io.mitts.houisegame.model.Ticket;
import io.mitts.houisegame.repository.GameRepository;
import io.mitts.houisegame.repository.PlayerRepository;
import io.mitts.houisegame.repository.TicketRepository;
import io.mitts.houisegame.service.PlayerService;
import io.mitts.houisegame.service.TicketService;
@Service
public class PlayerServiceImpl implements PlayerService {

	
	@Autowired
	PlayerRepository playerRepo;
	@Autowired
	TicketRepository ticketRepo;
	@Autowired
	GameRepository gameRepo;
	@Autowired
	TicketService ticketService;
	
	@Override
	public PlayerDTO createPlayer(PlayerDTO dto) {
		//TODO  check for null
		Game game=gameRepo.findById(dto.getGameId()).get();
		Player player=Player.builder().emailId(dto.getEmailId()).game(game).playerName(dto.getPlayerName()).build();
		player=playerRepo.save(player);
		Set<Ticket> tickets=extractTicketsFromPlayerList(playerRepo.findByGame(game));
		Ticket newTicket=ticketService.generateTicket(tickets);
		newTicket=ticketRepo.save(newTicket);
		player.setTicket(newTicket);
		player=playerRepo.save(player);
		return PlayerDTO.builder().gameId(game.getGameId()).emailId(player.getEmailId()).playerId(player.getPlayerId()).playerName(player.getPlayerName()).ticket(newTicket).build();
	}

	private Set<Ticket> extractTicketsFromPlayerList(List<Player> players)
	{
		Set<Ticket> tickets=new HashSet<Ticket>();
		if(players!=null && !players.isEmpty())
		{
			for(Player player:players)
			{
				Ticket ticket=player.getTicket();
				if(ticket!=null)
				{
					tickets.add(ticket);
				}
			}
		}
		return tickets;
	}
	
	@Override
	public PlayerDTO updatePlayer(PlayerDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getPlayer(PlayerDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
