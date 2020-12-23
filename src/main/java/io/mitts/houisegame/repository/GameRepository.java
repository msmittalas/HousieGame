package io.mitts.houisegame.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.mitts.houisegame.model.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {

}
