package io.mitts.houisegame.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameBoard {

	
	@Id
	@GeneratedValue
	Integer gameBoardId;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gameId")
	Game game;
	@ElementCollection
	Set<Integer> numbers = new HashSet<Integer>();
	
}
