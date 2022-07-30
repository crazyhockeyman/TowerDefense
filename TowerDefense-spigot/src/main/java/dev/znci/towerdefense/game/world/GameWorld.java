package dev.znci.towerdefense.game.world;

import dev.znci.towerdefense.game.GameSettings;
import dev.znci.towerdefense.team.Team;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Data
public class GameWorld {

    @Getter
    private static Map<World, GameWorld> gameWorlds = new HashMap<>();

    @Nullable
    public static GameWorld parse(World world){
        return gameWorlds.get(world);
    }

    @Nullable
    public static GameWorld parse(String mapName) {
        for (GameWorld gameWorld : gameWorlds.values()) {
            if (gameWorld.getName().equalsIgnoreCase(mapName) || gameWorld.getWorld().getName().equalsIgnoreCase(mapName)) {
                return gameWorld;
            }
        }

        return null;
    }

    private final String name;
    private World world;
    private GameSettings settings;
    private List<Team> worldTeams;

    private Location lobbyPosition;
    private Map<Team, Location> teamLocations;

    public GameWorld(String name, World world) {
        this.world = world;
        this.name = name;
        this.settings = new GameSettings();
        this.teamLocations = new HashMap<>();
    }

    public World copy() {
        int number = 1;
        String worldName = world.getName() + "_playing" + number;

        while (Bukkit.getWorld(worldName) != null) {
            number++;
            worldName = world.getName() + "_playing" + number;
        }

        WorldCreator worldCreator = new WorldCreator(worldName).copy(world);
        return worldCreator.createWorld();
    }

}
