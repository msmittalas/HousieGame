package io.mitts.houisegame.service;

import org.springframework.stereotype.Service;

import io.mitts.houisegame.dto.GameDTO;


public interface GameServices {

	public GameDTO createGame(GameDTO inputGameDTO);

}
