package io.mitts.houisegame.utils;

import io.mitts.houisegame.dto.GameDTO;
import io.mitts.houisegame.model.Game;

public class GameDTOtoEntityMapper {

	
	public static GameDTO converToDTO(Game game)
	{
		GameDTO gameDTO=new GameDTO();
		
		if(game!=null)
		{	
			if(game.getCreatedAt()!=null)
			gameDTO.setCreatedAt(game.getCreatedAt());
			
			if(game.getDashboardNumbers()!=null)
			gameDTO.setDashboardNumbers(game.getDashboardNumbers());
			
			if(game.getEmailId()!=null)
			gameDTO.setEmailId(game.getEmailId());
			
			if(game.getFlags()!=null)	
			gameDTO.setFlags(game.getFlags());
			
			if(game.getGameId()!=null)
			gameDTO.setGameId(game.getGameId());
			
			if(game.getGameStatus()!=null)
			gameDTO.setGameStatus(game.getGameStatus());
			
			if(game.getHostname()!=null)
			gameDTO.setHostname(game.getHostname());
			
			if(game.getNextNumber()!=null)
			gameDTO.setNextNumber(game.getNextNumber());
			
			if(game.getPasscode()!=null)
			gameDTO.setPasscode(game.getPasscode());
			
			if(game.getPlayers()!=null)
			gameDTO.setPlayers(PlayerDTOtoEntityMapper.convertToDTOs(game.getPlayers()));
			
			if(game.getTarget()!=null)
			gameDTO.setTarget(game.getTarget());
		}	
		
		return gameDTO;
	}
	public static Game converToGame(GameDTO gameDTO)
	{
		Game game=new Game();
		if(gameDTO!=null)
		{
			if(gameDTO.getCreatedAt()!=null)
			game.setCreatedAt(gameDTO.getCreatedAt());
			
			if(gameDTO.getDashboardNumbers()!=null)
			game.setDashboardNumbers(gameDTO.getDashboardNumbers());	
			
			if(gameDTO.getEmailId()!=null)
			game.setDashboardNumbers(gameDTO.getDashboardNumbers());
	
			if(gameDTO.getFlags()!=null)
			game.setFlags(gameDTO.getFlags());
			
			if(gameDTO.getGameId()!=null)
			game.setGameId(gameDTO.getGameId());
			
			if(gameDTO.getGameStatus()!=null)
			game.setGameStatus(gameDTO.getGameStatus());
			
			if(gameDTO.getHostname()!=null)
			game.setHostname(gameDTO.getHostname());
			
			if(gameDTO.getNextNumber()!=null)
			game.setNextNumber(gameDTO.getNextNumber());
			
			if(gameDTO.getPasscode()!=null)
			game.setPasscode(gameDTO.getPasscode());
			
				
			if(gameDTO.getTarget()!=null)
			game.setTarget(gameDTO.getTarget());
		}
		
		return game;
	}
	
}
