package dev.znci.towerdefense.team;

import dev.znci.towerdefense.game.world.GameWorld;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bukkit.ChatColor;

@Data
@AllArgsConstructor
public class Team {

    private final GameWorld gameWorld;
    private final String name;
    private ChatColor color;

}
