package io.mitts.houisegame;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.mitts.houisegame.model.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, String> {

}
