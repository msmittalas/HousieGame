package io.mitts.houisegame.service.impl;
import org.springframework.stereotype.Service;

import io.mitts.houisegame.model.GameBoard;
import io.mitts.houisegame.service.GameBoardServices;

@Service
public class GameBoardServicesImpl  implements GameBoardServices {

	@Override
	public GameBoard createDefaultBaord() {
		
		return new GameBoard();
		
		
	}

}
