package io.mitts.houisegame.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.mitts.houisegame.model.Game;
import io.mitts.houisegame.model.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer> {

	public List<Player> findByGame(Game game);
	public Player findByEmailIdAndGame(String emailId,Game game);
	
	
}

