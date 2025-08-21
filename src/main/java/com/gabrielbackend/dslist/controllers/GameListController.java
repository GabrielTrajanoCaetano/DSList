package com.gabrielbackend.dslist.controllers;

import com.gabrielbackend.dslist.dto.GameListDto;
import com.gabrielbackend.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    public GameListService gameListService;

    @GetMapping
    public List<GameListDto> findAllList(){

        return gameListService.findAllList();
    }
}
