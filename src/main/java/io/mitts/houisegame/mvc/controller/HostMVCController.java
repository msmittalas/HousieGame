package io.mitts.houisegame.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.mitts.houisegame.dto.GameDTO;
import io.mitts.houisegame.model.Game;
import io.mitts.houisegame.service.GameServices;

@Controller
@RequestMapping("/host")
public class HostMVCController {

	@Autowired
	GameServices gameService;
	
	@GetMapping("/showhostgame")
	public String hostgame()
	{
		return "hostgame";
	}
	
	@PostMapping(value="/rejoin",
			consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE} )
	public String joinGame( GameDTO dto,HttpSession session)
	{
		String  redirectUrl="redirect:/game/showgameboard";
		if(dto!=null && dto.getGameId()!=null)
		{
			GameDTO game=gameService.getGame(dto);
			if(game!=null && game.getGameId().equals(dto.getGameId()) && game.getPasscode().equals(dto.getPasscode()))
			{
				session.setAttribute("gameId", dto.getGameId());
				session.setAttribute("isHost", "true");
				redirectUrl="redirect:/game/showgameboard";
			}
		}
		else 
		{
			redirectUrl="redirect:/game/showhostgame";
		}
		return redirectUrl;
	}
	
	
	
	
}
