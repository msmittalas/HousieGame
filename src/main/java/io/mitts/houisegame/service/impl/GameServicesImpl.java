package io.mitts.houisegame.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mitts.houisegame.HousieConstant;
import io.mitts.houisegame.dto.GameDTO;
import io.mitts.houisegame.model.Game;
import io.mitts.houisegame.model.GameBoard;
import io.mitts.houisegame.repository.GameRepository;
import io.mitts.houisegame.service.GameBoardServices;
import io.mitts.houisegame.service.GameServices;
import io.mitts.houisegame.utils.HouiseGameUtils;
@Service
public class GameServicesImpl implements GameServices {

	@Autowired
	GameRepository gameRepository;
	@Autowired
	GameBoardServices gameBoardServices;
	@Autowired
	HouiseGameUtils utils;
	
	@Override
	public  GameDTO createGame(GameDTO inputGameDTO) {
	
		GameBoard board=gameBoardServices.createDefaultBaord();
		Game game=Game.builder()
				.board(board)
				.emailId(inputGameDTO.getEmailId())
				.passcode(utils.generatePasscode())
				.target(inputGameDTO.getTarget())
				.gameStatus(HousieConstant.GAME_STATUS_CREATED)
				.build();
		game=gameRepository.save(game);
		return mapEntityToDTO(game);
	}


	private GameDTO mapEntityToDTO(Game game) {
		return GameDTO.builder().gameId(game.getGameId()).passcode(game.getPasscode()).build();
	}


	@Override
	public Game getGame(GameDTO dto) {
		
		return gameRepository.findById(dto.getGameId()).get();
	}

	
	
}
