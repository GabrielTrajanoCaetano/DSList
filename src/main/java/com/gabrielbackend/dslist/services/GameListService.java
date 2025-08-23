package com.gabrielbackend.dslist.services;

import com.gabrielbackend.dslist.dto.GameListDto;
import com.gabrielbackend.dslist.entities.GameList;
import com.gabrielbackend.dslist.projections.GameMinProjection;
import com.gabrielbackend.dslist.repositories.GameListRepository;
import com.gabrielbackend.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    public GameListRepository gameListRepository;

    @Autowired
    public GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAllList(){
        List<GameList> lists = gameListRepository.findAll();
        return lists.stream().map(x-> new GameListDto(x)).toList();

    }

    public void move(Long listId, int sourceIndex, int destinationIndex){

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection game = list.remove(sourceIndex);
        list.add(destinationIndex, game);


    }
}
