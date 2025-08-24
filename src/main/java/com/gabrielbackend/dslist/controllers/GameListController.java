package com.gabrielbackend.dslist.controllers;

import com.gabrielbackend.dslist.dto.GameListDto;
import com.gabrielbackend.dslist.dto.GameMinDto;
import com.gabrielbackend.dslist.dto.ReplacementDto;
import com.gabrielbackend.dslist.services.GameListService;
import com.gabrielbackend.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    public GameListService gameListService;

    @Autowired
    public GameService gameService;

    @GetMapping
    public List<GameListDto> findAllList(){
        return gameListService.findAllList();
    }

    @GetMapping("/{listId}/games")
    public List<GameMinDto> findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move (@PathVariable Long listId,@RequestBody ReplacementDto body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }


}
