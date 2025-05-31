package com.example.FirstProject.serviceImpl;

import com.example.FirstProject.model.Player;
import com.example.FirstProject.repository.PlayerRepository;
import com.example.FirstProject.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> getAllPlayers() {

        List<Player> players = playerRepository.findAll();
        return players;
    }

    @Override
    public Optional<Player> getPlayer(int id) {
        return playerRepository.findById(id);
    }

    @Override
    public List<Player> findBySports(String name) {
        List<Player> players = playerRepository.findBySports(name);
        return players;
    }
}
