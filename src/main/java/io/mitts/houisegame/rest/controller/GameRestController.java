package io.mitts.houisegame.rest.controller;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.mitts.houisegame.dto.GameDTO;
import io.mitts.houisegame.model.Game;
import io.mitts.houisegame.service.GameServices;

@Controller
@RequestMapping("/rest/games")
public class GameRestController {

	
	@Autowired
	GameServices gameServices;
	
	@PostMapping
	public @ResponseBody GameDTO createGame(@RequestBody GameDTO  inputGameDTO)
	{
		GameDTO dto=gameServices.createGame(inputGameDTO);
		
		return  dto;
	}
	@GetMapping(path = "/{gameId}")
	public @ResponseBody GameDTO getGame(@PathVariable Integer gameId)
	{
		GameDTO inputGameDTO=GameDTO.builder().gameId(gameId).build();
		return  gameServices.getGame(inputGameDTO);
	}
	
	
}
