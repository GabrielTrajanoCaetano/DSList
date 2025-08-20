package com.gabrielbackend.dslist.repositories;

import com.gabrielbackend.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
