package io.mitts.houisegame.service;

import org.springframework.stereotype.Service;

import io.mitts.houisegame.dto.GameDTO;
import io.mitts.houisegame.model.Game;


public interface GameServices {

	public GameDTO createGame(GameDTO inputGameDTO);
	
	public Game getGame(GameDTO dto);

}
