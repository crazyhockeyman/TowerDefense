package dev.znci.towerdefense;

import cf.grcq.priveapi.PriveAPI;
import cf.grcq.priveapi.command.CommandHandler;
import cf.grcq.priveapi.utils.Util;
import dev.znci.towerdefense.commands.parameters.GameWorldParameterType;
import dev.znci.towerdefense.game.world.GameWorld;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class TowerDefense extends JavaPlugin {

    public static String PREFIX = Util.format("&8[&6&lT&e&lD&8] &e");

    @Getter private static TowerDefense instance;

    @Override
    public void onEnable() {
        instance = this;

        this.saveDefaultConfig();

        PriveAPI.init(this);

        String name = getDescription().getName();
        String version = getDescription().getVersion();

        CommandHandler.setUsageMessage(PREFIX + "Usage: /{command} {arguments}");
        CommandHandler.setUsageMessageList("&7- &e/{command} {arguments}");
        CommandHandler.setUsageMessageListLine(PREFIX + "Currently running &6" + name + " v" + version + "&e.");
        CommandHandler.setDoubleUsageMessageLine(false);
        CommandHandler.setNoPermissionMessage(PREFIX + "&cNo permission!");

        CommandHandler.registerParameter(GameWorld.class, new GameWorldParameterType());
        CommandHandler.registerAll(this);
    }

    @Override
    public void onDisable() {
        this.saveDefaultConfig();
    }
}
