package io.mitts.houisegame.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.mitts.houisegame.dto.GameDTO;
import io.mitts.houisegame.dto.PlayerDTO;
import io.mitts.houisegame.model.Game;
import io.mitts.houisegame.model.Player;
import io.mitts.houisegame.service.GameServices;
import io.mitts.houisegame.service.PlayerService;

@Controller
@RequestMapping("/game")
public class GameMVCController {

	
	@Autowired
	GameServices gameService;
	@Autowired 
	PlayerService playerService;
	
	
	@PostMapping(value="/create",
			consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE} )
	public String createGame( GameDTO dto,HttpSession session)
	{
		dto=gameService.createGame(dto);
		session.setAttribute("gameId", dto.getGameId());
		PlayerDTO playerDTO=PlayerDTO.builder().isHost("true").gameId(dto.getGameId()).playerName(dto.getHostname()).passcode(dto.getPasscode()).build();
		session.setAttribute("isHost"+ dto.getGameId(), "true");
		session.setAttribute("playerDetails", playerDTO);
		return "redirect:/game/showgameboard";
	}
	

	
	@GetMapping("/showgameboard")
	public String showGameboard()
	{
		return "gameboard";
	}
	
	@GetMapping("/get")
	public ResponseEntity<GameDTO> getGame(@RequestParam Integer gameId,HttpSession session)
	{
		       GameDTO dto=GameDTO.builder().gameId(gameId).build();
		       dto=gameService.getGame(dto);
		       ResponseEntity<GameDTO> entity=null;
		       if(dto!=null)
		       { 
		    	   //TODO isHost only will not work , check gameId as well
		    	   if(session.getAttribute("isHost"+gameId)==null)
		    	   {
		    		   dto.setPasscode("");
		    	   }   
		    	   entity=ResponseEntity.ok(dto);
		       }
		       else
		       {
		    	   entity=ResponseEntity.noContent().build();
		       }
		    return entity;
	}
	@PostMapping("/joinplayer")
	public String createPlayer(PlayerDTO dto,HttpSession session)
	{
		dto=playerService.createPlayer(dto);
		dto.setIsHost("false");
		session.setAttribute("gameId", dto.getGameId());
		session.setAttribute("playerDetails", dto);
		
		return "redirect:/game/showgameboard";
	}
	
	@GetMapping("/generateNext")
	public ResponseEntity<Integer> generateNext(@RequestParam Integer gameId)
	{
		 GameDTO dto=GameDTO.builder().gameId(gameId).build();
		 Integer nextNumber=gameService.generateNextNumber(dto);
		 
		 return ResponseEntity.ok(nextNumber);
	}
	@GetMapping("/playerDetails")
	public ResponseEntity<PlayerDTO> getPlayer(HttpSession session)
	{
		return ResponseEntity.ok((PlayerDTO)session.getAttribute("playerDetails"));
	}
}
