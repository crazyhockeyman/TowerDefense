package dev.znci.towerdefense.commands.parameters;

import cf.grcq.priveapi.command.parameter.ParameterType;
import cf.grcq.priveapi.utils.Util;
import dev.znci.towerdefense.game.world.GameWorld;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameWorldParameterType implements ParameterType<GameWorld> {

    @Override
    public GameWorld transform(CommandSender sender, String source) {
        for (GameWorld world : GameWorld.getGameWorlds().values()) {
            if (world.getName().equalsIgnoreCase(source) || world.getWorld().getName().equalsIgnoreCase(source)) {
                return world;
            }
        }

        sender.sendMessage(Util.format("&cError: Game world '&e" + source + "&c' was not found."));
        return null;
    }

    @Override
    public List<String> tabComplete(Player player, String source) {
        List<String> completion = new ArrayList<>();
        for (GameWorld gameWorld : GameWorld.getGameWorlds().values()) {
            completion.add(gameWorld.getName());
        }

        return completion;
    }
}
