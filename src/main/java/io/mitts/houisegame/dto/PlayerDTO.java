package io.mitts.houisegame.dto;

import io.mitts.houisegame.model.Player;
import io.mitts.houisegame.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PlayerDTO {

	Integer gameId;
	String playerName;
	String emailId;
	Ticket ticket;
	Integer playerId;
	String isHost;
	String passcode;
	
}
