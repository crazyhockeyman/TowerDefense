package dev.znci.towerdefense.commands.parameters;

import cf.grcq.priveapi.command.parameter.ParameterType;
import cf.grcq.priveapi.utils.Util;
import dev.znci.towerdefense.TowerDefense;
import dev.znci.towerdefense.game.Game;
import dev.znci.towerdefense.game.GameHandler;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GameParameterType implements ParameterType<Game> {

    @Override
    public Game transform(CommandSender sender, String source) {
        Game game = TowerDefense.getInstance().getGameHandler().getGame(source);

        if (source.equalsIgnoreCase("@s") && sender instanceof Player) {
            Player p = (Player) sender;
            game = TowerDefense.getInstance().getGameHandler().getPlayersInGame().get(p);
        }

        if (game != null) {
            return game;
        }

        sender.sendMessage(Util.format("&cError: Game with ID of '&e" + source + "&c' was not found."));
        return null;
    }

    @Override
    public List<String> tabComplete(Player player, String source) {
        List<String> completion = new ArrayList<>();

        for (Game game : TowerDefense.getInstance().getGameHandler().getActiveGames()) {
            completion.add(game.getId());
        }

        return completion;
    }
}
