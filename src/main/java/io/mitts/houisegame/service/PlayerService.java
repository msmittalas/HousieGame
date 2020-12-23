package io.mitts.houisegame.service;

import io.mitts.houisegame.dto.PlayerDTO;
import io.mitts.houisegame.model.Player;

public interface PlayerService {

	public PlayerDTO createPlayer(PlayerDTO dto);
	public PlayerDTO updatePlayer(PlayerDTO dto);
	public PlayerDTO getPlayer(PlayerDTO dto);
	
}
