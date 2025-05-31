package com.example.FirstProject.service;

import com.example.FirstProject.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {

    List<Player> getAllPlayers();

    Optional<Player> getPlayer(int id);

    List<Player> findBySports(String name);
}
