package io.mitts.houisegame.model;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Player {
	

	@Id
	@GeneratedValue
	Integer playerId;
	String playerName;
	String emailId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gameId")
	Game game;
	@OneToOne(fetch = FetchType.EAGER, mappedBy="player", cascade = CascadeType.ALL)
	Ticket ticket;

}
