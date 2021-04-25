package io.mitts.houisegame.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.mitts.houisegame.dto.GameDTO;
import io.mitts.houisegame.dto.PlayerDTO;
import io.mitts.houisegame.service.GameServices;
import io.mitts.houisegame.service.PlayerService;
import static io.mitts.houisegame.HousieConstant.*;

@Controller
@RequestMapping("/game")
public class GameMVCController {
	
	GameServices gameService;
	PlayerService playerService;
	
	public GameMVCController(GameServices gameServices,PlayerService playerService) {
		this.gameService=gameServices;
		this.playerService=playerService;
	}
	
	
	
	@PostMapping(value="/create",
			consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE} )
	public String createGame( GameDTO dto,Model model,HttpSession session)
	{
		dto=gameService.createGame(dto);
		
		model.addAttribute("gameId", dto.getGameId());
		model.addAttribute("isHost"+ dto.getGameId(), "true");
		model.addAttribute("playerDetails", dto.getHostPlayer());
		session.setAttribute("playerDetails", dto.getHostPlayer());
		session.setAttribute("isHost"+ dto.getGameId(), "true");
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
	public String createPlayer(PlayerDTO dto,Model model,HttpSession session)
	{
		GameDTO gameDto=gameService.getGame(GameDTO.builder().gameId(dto.getGameId()).build());
		if(gameDto!=null && gameDto.getGameStatus()!=null && gameDto.getGameStatus().equals(GAME_STATUS_CREATED))
		{
			dto.setIsHost("false");
			dto=playerService.createPlayer(dto);
			model.addAttribute("gameId", dto.getGameId());
			model.addAttribute("playerDetails", dto);
			session.setAttribute("playerDetails", dto);
			
		}
		return "gameboard";
	}
	@PostMapping("/rejoinplayer")
	public String reJoinPlayer(PlayerDTO dto,HttpSession session)
	{
		String redirectURL="/";
		dto=playerService.getPlayer(dto);
		if(dto!=null)
		{	
			GameDTO gameDto=gameService.getGame(GameDTO.builder().gameId(dto.getGameId()).build());
			if(gameDto!=null && gameDto.getGameStatus()!=null && gameDto.getGameStatus().equals(GAME_STATUS_CREATED))
			{	
			session.setAttribute("gameId", dto.getGameId());
			session.setAttribute("playerDetails", dto);
			redirectURL="redirect:/game/showgameboard";
			}
		}
		return redirectURL;
	}
	@GetMapping("/generateNext")
	public ResponseEntity<Integer> generateNext(@RequestParam Integer gameId,HttpSession session)
	{
		ResponseEntity<Integer> responseEntity=ResponseEntity.badRequest().build();
		  if(session.getAttribute("isHost"+gameId)!=null)
	   	   {
		 GameDTO dto=GameDTO.builder().gameId(gameId).build();
		 Integer nextNumber=gameService.generateNextNumber(dto);
		 responseEntity=ResponseEntity.ok(nextNumber);
	   	   }
		 return responseEntity;
	}
	
	@GetMapping("/changeStatus")
	public ResponseEntity<String> changeGameStatus(@RequestParam Integer gameId,@RequestParam String gameStatus,HttpSession session)
	{
		ResponseEntity<String> responseEntity=ResponseEntity.badRequest().build();
		  if(session.getAttribute("isHost"+gameId)!=null)
   	   {
		 GameDTO dto=GameDTO.builder().gameId(gameId).gameStatus(gameStatus).build();
		 if(gameService.changeGameStatus(dto)) 
		 {
			 responseEntity=ResponseEntity.ok().build();
		 }
   	   }
		return responseEntity;
		
	}
	
	
	
	@GetMapping("/playerDetails")
	public ResponseEntity<PlayerDTO> getPlayer(HttpSession session)
	{
		return ResponseEntity.ok((PlayerDTO)session.getAttribute("playerDetails"));
	}
}
