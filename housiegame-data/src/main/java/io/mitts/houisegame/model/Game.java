package io.mitts.houisegame.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.data.relational.core.mapping.MappedCollection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Game {

	@Id
	@GeneratedValue
	Integer gameId;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="game", cascade = CascadeType.ALL)
	List<Player> players;
	String target;
	@Column(length = 2000)
	ArrayList<Integer> dashboardNumbers=new ArrayList<Integer>();
	String emailId;
 	Date createdAt;
 	String gameStatus;
 	Integer nextNumber=0;
 	@OneToOne
 	@JoinColumn(name="playerId")
 	Player host;
 	@ElementCollection
 	Map<String,String> flags = new HashMap<String, String>();
 	
 	
	
}
