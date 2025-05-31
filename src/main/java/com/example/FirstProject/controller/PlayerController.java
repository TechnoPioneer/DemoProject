package com.example.FirstProject.controller;

import com.example.FirstProject.exception.PlayerNotFoundException;
import com.example.FirstProject.model.Player;
import com.example.FirstProject.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    List<Player> getAllPlayers(){
        List<Player> players = playerService.getAllPlayers();
        return players;
    }

    @GetMapping("/player")
    public ResponseEntity<?> getPlayer(@RequestParam int id) {
        Player player =  playerService.getPlayer(id).orElseThrow(() -> new PlayerNotFoundException("Player not found ofr Id: " + id));
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @GetMapping("/player/sports")
    List<Player> findPlayersByName(@RequestParam(required = true) String name) {
        return playerService.findBySports(name);
    }

}
