package io.mitts.houisegame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.mitts.houisegame.dto.GameDTO;
import io.mitts.houisegame.service.GameServices;

@RestController
@RequestMapping("/games")
public class GameController {

	
	@Autowired
	GameServices gameServices;
	
	@PostMapping
	public @ResponseBody GameDTO createGame(@RequestBody GameDTO  inputGameDTO)
	{
		
		return gameServices.createGame(inputGameDTO);
	}
	
}
