package io.mitts.houisegame.service.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	List<PlayerDTO> players;
	String target;
	String hostname;
	Set<Ticket> tickets;
	String emailId;
 	Date createdAt;
 	Map<String,String> flags;
 	Integer nextNumber;
 	String gameStatus;
	ArrayList<Integer> dashboardNumbers=new ArrayList<Integer>();
	PlayerDTO hostPlayer;
}