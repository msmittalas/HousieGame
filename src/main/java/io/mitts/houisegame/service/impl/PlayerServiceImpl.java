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
import io.mitts.houisegame.service.GameServices;
import io.mitts.houisegame.service.PlayerService;
import io.mitts.houisegame.service.TicketService;
import io.mitts.houisegame.utils.PlayerDTOtoEntityMapper;
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
		Game game=gameRepo.findById(dto.getGameId()).get();
		Player player=Player.builder()
		.emailId(dto.getEmailId())
		.game(game)
		.playerName(dto.getPlayerName())
		.passcode(dto.getPasscode())
		.isHost(dto.getIsHost())
		.build();
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
		return null;
	}

	@Override
	public PlayerDTO getPlayer(PlayerDTO dto) {
		Player player=playerRepo.findByEmailIdAndGame(dto.getEmailId(),gameRepo.findById(dto.getGameId()).get());
		return PlayerDTOtoEntityMapper.convertToDTO(player);
	}

}
