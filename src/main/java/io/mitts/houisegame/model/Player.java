package io.mitts.houisegame.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
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
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Ticket ticket;
	@Column(unique = true)
	String passcode;
	String isHost;

}
