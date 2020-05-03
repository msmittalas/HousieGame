package io.mitts.houisegame.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
	
	@Id
	@GeneratedValue
	Integer ticketId;
	
	@OneToOne
	@JoinColumn(name="playerId")
	Player player;
	@ManyToOne
	@JoinColumn(name="gameId")
	Game game;
	
	String []row1;
	String []row2;
	String []row3;
	
	
	@Override
	public int hashCode() {
		return 1;
	}



 

	

}

