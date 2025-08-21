package com.gabrielbackend.dslist.repositories;

import com.gabrielbackend.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
