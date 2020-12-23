package io.mitts.houisegame.service;

import io.mitts.houisegame.model.Player;
import io.mitts.houisegame.service.dto.PlayerDTO;

public interface PlayerService {

	public PlayerDTO createPlayer(PlayerDTO dto);
	public PlayerDTO updatePlayer(PlayerDTO dto);
	public PlayerDTO getPlayer(PlayerDTO dto);
	
}
