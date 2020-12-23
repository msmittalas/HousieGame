package io.mitts.houisegame.service.utils;

import java.util.ArrayList;
import java.util.List;

import io.mitts.houisegame.model.Player;
import io.mitts.houisegame.service.dto.PlayerDTO;

public class PlayerDTOtoEntityMapper {
	
	public static List<PlayerDTO> convertToDTOs(List<Player> players)
	{
		List<PlayerDTO> playerDTOs=new ArrayList<PlayerDTO>();
		
		if(players!=null && !players.isEmpty())
		{
			for(Player player:players)
			{
				playerDTOs.add(convertToDTO(player));
			}
		}
		return playerDTOs;
	}
	
	public static PlayerDTO convertToDTO(Player player)
	{
		PlayerDTO playerDTO=new PlayerDTO();
		if(player!=null)
		{	
			if(player.getEmailId()!=null)
			playerDTO.setEmailId(player.getEmailId());
			
			if(player.getGame()!=null)
			playerDTO.setGameId(player.getGame().getGameId());
			
			if(player.getPlayerId()!=null)
			playerDTO.setPlayerId(player.getPlayerId());
			
			if(player.getPlayerName()!=null)
			playerDTO.setPlayerName(player.getPlayerName());
			
			if(player.getTicket()!=null)
			playerDTO.setTicket(player.getTicket());
			
			if(player.getIsHost()!=null)
			playerDTO.setIsHost(player.getIsHost());
			
			if(player.getPasscode()!=null)
			playerDTO.setPasscode(player.getPasscode());	
			
		}
		
		return playerDTO;
	}

}
