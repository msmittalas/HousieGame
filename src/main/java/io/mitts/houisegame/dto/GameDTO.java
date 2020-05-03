package io.mitts.houisegame.dto;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;


import io.mitts.houisegame.model.GameBoard;
import io.mitts.houisegame.model.Player;
import io.mitts.houisegame.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameDTO {
	
	
	
	Integer gameId;
	String passcode;
	List<Player> players;
	String target;
	GameBoard board;
	Set<Ticket> tickets;
	String emailId;
 	Date createdAt;
 	Map<String,String> flags;

}
