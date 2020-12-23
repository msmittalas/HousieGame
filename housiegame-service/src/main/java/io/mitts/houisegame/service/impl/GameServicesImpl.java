package io.mitts.houisegame.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.mitts.houisegame.model.Game;
import io.mitts.houisegame.model.Player;
import io.mitts.houisegame.repository.GameRepository;
import io.mitts.houisegame.repository.PlayerRepository;
import io.mitts.houisegame.service.GameServices;
import io.mitts.houisegame.service.dto.GameDTO;
import io.mitts.houisegame.service.utils.GameDTOtoEntityMapper;
import io.mitts.houisegame.service.utils.HouiseGameUtils;

import static io.mitts.houisegame.service.HousieServiceConstant.*;


@Service
public class GameServicesImpl implements GameServices {

	@Autowired
	GameRepository gameRepository;
	@Autowired
	HouiseGameUtils utils;
	@Autowired
	PlayerRepository playerRepo;
	@Override
	public GameDTO createGame(GameDTO inputGameDTO) {

		Game game = GameDTOtoEntityMapper.converToGame(inputGameDTO);
		game.setGameStatus(GAME_STATUS_CREATED);
		game = createOrUpdate(game);
		Player hostPlayer=Player.builder().emailId(inputGameDTO.getEmailId())
		.game(game)
		.isHost("true")
		.passcode(""+System.currentTimeMillis())
		.playerName(inputGameDTO.getHostname())
		.build();
		hostPlayer=playerRepo.save(hostPlayer);
		game.setHost(hostPlayer);
		createOrUpdate(game);
		return GameDTOtoEntityMapper.converToDTO(game);
	}

	

	@Override
	public GameDTO getGame(GameDTO dto) {

		Game game = null;
		Optional<Game> dbOutputOpt = gameRepository.findById(dto.getGameId());
		if (dbOutputOpt.isPresent()) {
			game = dbOutputOpt.get();
		}

		return GameDTOtoEntityMapper.converToDTO(game);
	}

	public Game createOrUpdate(Game game) {
		return gameRepository.save(game);
	}

	@Override
	public Integer generateNextNumber(GameDTO dto) {

		Integer newNumber = 0;
		Game game = gameRepository.findById(dto.getGameId()).get();
		if (game != null) {
			ArrayList<Integer> numbers = game.getDashboardNumbers();
			if (numbers == null) {
				numbers = new ArrayList<Integer>();
			}
			if (numbers.size() < 90) {
				newNumber = HouiseGameUtils.getRandomNumberBetween(1, 90, numbers);
				numbers.add(newNumber);
				game.setNextNumber(newNumber);
				game.setDashboardNumbers(numbers);
				createOrUpdate(game);
			}
		}

		return newNumber;
	}



	@Override
	public boolean changeGameStatus(GameDTO dto) {
		Game game = gameRepository.findById(dto.getGameId()).get();
		boolean UpdateFlag=false;
		if (game != null) {
			game.setGameStatus(dto.getGameStatus());
			createOrUpdate(game);
		}
		return UpdateFlag;
	}

}
