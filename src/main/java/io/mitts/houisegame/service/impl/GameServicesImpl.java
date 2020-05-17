package io.mitts.houisegame.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mitts.houisegame.HousieConstant;
import io.mitts.houisegame.dto.GameDTO;
import io.mitts.houisegame.model.Game;
import io.mitts.houisegame.repository.GameRepository;
import io.mitts.houisegame.service.GameServices;
import io.mitts.houisegame.utils.GameDTOtoEntityMapper;
import io.mitts.houisegame.utils.HouiseGameUtils;

@Service
public class GameServicesImpl implements GameServices {

	@Autowired
	GameRepository gameRepository;
	@Autowired
	HouiseGameUtils utils;

	@Override
	public GameDTO createGame(GameDTO inputGameDTO) {

		Game game = GameDTOtoEntityMapper.converToGame(inputGameDTO);
		game.setPasscode(utils.generatePasscode());
		game.setGameStatus(HousieConstant.GAME_STATUS_CREATED);
		game = createOrUpdate(game);
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

}
