package dev.znci.towerdefense.commands;

import cf.grcq.priveapi.command.Command;
import cf.grcq.priveapi.command.parameter.Param;
import cf.grcq.priveapi.utils.Util;
import dev.znci.towerdefense.TowerDefense;
import dev.znci.towerdefense.game.Game;
import dev.znci.towerdefense.game.GameHandler;
import dev.znci.towerdefense.game.GameState;
import org.bukkit.entity.Player;

public class StartCommand {

    @Command(names = "start", permission = "towerdefense.start")
    public static void start(Player player, @Param(name = "id", defaultValue = "@s") Game game) {
        if (game.getState() != GameState.LOBBY || game.getState() != GameState.STARTING) {
            player.sendMessage(Util.format("&cError: Game is already started or has ended."));
            return;
        }

        game.start();
    }

}
gamer stop
/stop
/die
Access-Control-Allow-Origin:Access-Control-Allow-Origin:VAccess-Control-Allow-Origin:Access-Control-Allow-Origin:Access-Control-Allow-Origin:Access-Control-Allow-Origin:Access-Control-Allow-Origin:Access-Control-Allow-Origin:VAccess-Control-Allow-Origin:Access-Control-Allow-Origin:Access-Control-Allow-Origin:Access-Control-Allow-Origin:Access-Control-Allow-Origin:Access-Control-Allow-Origin:VAccess-Control-Allow-Origin:Access-Control-Allow-Origin:Access-Control-Allow-Origin:Access-Control-Allow-Origin:Access-Control-Allow-Origin:Access-Control-Allow-Origin:VAccess-Control-Allow-Origin:Access-Control-Allow-Origin:Access-Control-Allow-Origin:Access-Control-Allow-Origin:Access-Control-Allow-Origin:Access-Control-Allow-Origin:VAccess-Control-Allow-Origin:Access-Control-Allow-Origin:Access-Control-Allow-Origin:Access-Control-Allow-Origin:
