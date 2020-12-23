package io.mitts.houisegame.service;


import io.mitts.houisegame.model.Game;
import io.mitts.houisegame.service.dto.GameDTO;


public interface GameServices {

	public GameDTO createGame(GameDTO inputGameDTO);
	
	public GameDTO getGame(GameDTO dto);
	
	public Integer generateNextNumber(GameDTO dto);
	
	public boolean changeGameStatus(GameDTO dto);

}
