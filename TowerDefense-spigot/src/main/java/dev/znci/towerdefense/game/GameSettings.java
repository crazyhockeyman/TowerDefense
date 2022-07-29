package dev.znci.towerdefense.game;

import lombok.Data;

import java.util.List;

@Data
public class GameSettings {

    private int maxPlayers = 12;
    private int minPlayers = 2;

    /* Teams? */
    private boolean teams = false;
    private int minPlayersPerTeam = 1;
    private int maxPlayersPerTeam = 4;

}
