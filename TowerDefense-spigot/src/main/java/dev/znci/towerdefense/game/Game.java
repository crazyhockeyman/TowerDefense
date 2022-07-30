package dev.znci.towerdefense.game;

import cf.grcq.priveapi.minigame.game.profile.GameProfile;
import dev.znci.towerdefense.game.world.GameWorld;
import lombok.Data;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Data
public class Game {

    private final String id;
    private final GameWorld gameWorld;
    private final World playingWorld;
    private GameState state;

    private final List<GameProfile> players;

    public Game(GameWorld gameWorld) {
        this.id = generateId();
        this.gameWorld = gameWorld;
        this.playingWorld = gameWorld.copy();
        this.state = GameState.LOBBY;

        this.players = new ArrayList<>();
    }

    private String generateId() {
        StringBuilder str = new StringBuilder("game_");
        for (int i = 0; i < 4; i++) {
            int x = ThreadLocalRandom.current().nextInt(0, 9);
            str.append(x);
        }

        return str.toString();
    }

}
