package io.mitts.houisegame.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.mitts.houisegame.dto.GameDTO;
import io.mitts.houisegame.model.Game;
import io.mitts.houisegame.service.GameServices;

@Controller
@RequestMapping("/game")
public class GameMVCController {

	
	@Autowired
	GameServices gameService;
	
	@GetMapping("/showhostgame")
	public String hostgame()
	{
		return "hostgame";
	}
	
	@PostMapping(value="/creategame",
			consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE} )
	public String createGame( GameDTO dto,HttpSession session)
	{
		dto=gameService.createGame(dto);
		session.setAttribute("gameId", dto.getGameId());
		session.setAttribute("isHost", "true");
		session.setAttribute("gamepasscode",dto.getPasscode());
		
		return "redirect:/game/showgameboard";
	}
	
	@PostMapping(value="/rejoinhost",
			consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE} )
	public String joinGame( GameDTO dto,HttpSession session)
	{
		String  redirectUrl="redirect:/game/showgameboard";
		if(dto!=null && dto.getGameId()!=null)
		{
			Game game=gameService.getGame(dto);
			if(game!=null && game.getGameId().equals(dto.getGameId()) && game.getPasscode().equals(dto.getPasscode()))
			{
				session.setAttribute("gameId", dto.getGameId());
				session.setAttribute("isHost", "true");
				session.setAttribute("gamepasscode",game.getPasscode());
				
				redirectUrl="redirect:/game/showgameboard";
			}
		}
		else 
		{
			redirectUrl="redirect:/game/showhostgame";
		}
		return redirectUrl;
	}
	
	@GetMapping("/showgameboard")
	public String showGameboard()
	{
		return "gameboard";
	}
	
	@GetMapping("/get")
	public Game getGame(@RequestParam Integer gameId)
	{
		       GameDTO dto=GameDTO.builder().gameId(gameId).build();
		       return gameService.getGame(dto);
	}
	
}
