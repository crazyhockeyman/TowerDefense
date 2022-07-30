package dev.znci.towerdefense.game;

import cf.grcq.priveapi.minigame.game.profile.GameProfile;
import dev.znci.towerdefense.TowerDefense;
import dev.znci.towerdefense.game.world.GameWorld;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GameHandler {

    @Getter
    private final List<Game> activeGames;
    @Getter
    private final Map<Player, Game> playersInGame;

    public GameHandler() {
        this.activeGames = new ArrayList<>();
        this.playersInGame = new HashMap<>();
    }

    public Game newGame() {
        List<GameWorld> gameWorlds = (List<GameWorld>) GameWorld.getGameWorlds().values();

        int random = ThreadLocalRandom.current().nextInt(gameWorlds.size());
        GameWorld gameWorld = gameWorlds.get(random);

        return newGame(gameWorld);
    }

    public Game newGame(String mapName) {
        return newGame(GameWorld.parse(mapName));
    }

    public Game newGame(GameWorld gameWorld) {
        Game game = new Game(gameWorld);
        activeGames.add(game);

        return game;
    }

    public void endGame(@NotNull Game game) {
        Objects.requireNonNull(game);

        game.setState(GameState.END);
        Bukkit.getScheduler().runTaskLater(TowerDefense.getInstance(), () -> {
            for (GameProfile profile : game.getPlayers()) {
                if (profile.isOnline()) {
                    Player player = Bukkit.getPlayer(profile.getUuid());

                    playersInGame.remove(player);
                    // TODO: Get spawn location from config and teleport player. If set-up is false, teleport to world spawn.
                }
            }
        }, (20L * 15L));

        activeGames.remove(game);
    }

    @Nullable
    public Game getGame(String id) {
        for (Game game : activeGames) {
            if (game.getId().equalsIgnoreCase(id)) return game;
        }

        return null;
    }

}
