package dev.znci.towerdefense.game.world;

import dev.znci.towerdefense.game.GameSettings;
import dev.znci.towerdefense.team.Team;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
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

}
