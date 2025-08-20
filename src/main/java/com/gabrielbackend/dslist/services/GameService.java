package com.gabrielbackend.dslist.services;

import com.gabrielbackend.dslist.dto.GameDto;
import com.gabrielbackend.dslist.dto.GameMinDto;
import com.gabrielbackend.dslist.entities.Game;
import com.gabrielbackend.dslist.repositories.GameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

import static java.util.Objects.isNull;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDto findById(Long id) {

        Game result = gameRepository.findById(id).orElseThrow(()-> new NoSuchElementException("null"));
        GameDto gameDto = new GameDto();
        BeanUtils.copyProperties(result, gameDto);

        return gameDto;
    }
    @Transactional(readOnly = true)
    public List<GameMinDto> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDto(x)).toList();
    }


}
