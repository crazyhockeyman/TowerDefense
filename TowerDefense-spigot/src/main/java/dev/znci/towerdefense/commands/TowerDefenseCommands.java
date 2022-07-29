package dev.znci.towerdefense.commands;

import cf.grcq.priveapi.command.Command;
import cf.grcq.priveapi.command.parameter.Param;
import cf.grcq.priveapi.utils.Util;
import dev.znci.towerdefense.TowerDefense;
import dev.znci.towerdefense.game.world.GameWorld;
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TowerDefenseCommands {

    @Command(names = {"towerdefense", "td", "tdefense", "towerdefence", "tdefence"}, sendUsage = true)
    public static void towerDefense(CommandSender sender) {}

    @Command(names = "towerdefense reload", permission = "towerdefense.reload")
    public static void reload(CommandSender sender) {
        sender.sendMessage(Util.format(TowerDefense.PREFIX + "Reloading plugin... please wait."));
        // TODO: Reload plugin.
        sender.sendMessage(Util.format(TowerDefense.PREFIX + "Plugin has been reloaded.\n" + TowerDefense.PREFIX + "NOTE: It is recommended to restart your server."));
    }

    @Command(names = "towerdefense map", permission = "towerdefense.map")
    public static void map(CommandSender sender) {
        // TODO: Send usage message.
    }

    @Command(names = "towerdefense map create", permission = "towerdefense.map.create")
    public static void createMap(Player player, @Param(name = "name") String name, @Param(name = "map name", defaultValue = "none") String mapName) {
        World world = Bukkit.getWorld(name);
        if (world != null) {
            player.sendMessage(Util.format("&cError: Map already exists."));
            return;
        }

        player.sendMessage(Util.format("&aCreating a world for you..."));
        world = new WorldCreator(name)
                .type(WorldType.FLAT)
                .generateStructures(false)
                .createWorld();

        GameWorld gameWorld = new GameWorld((mapName.equalsIgnoreCase("none") ? name : mapName), world);
        GameWorld.getGameWorlds().put(world, gameWorld);

        player.sendMessage(Util.format("&aYour world has been set up!"));
        player.teleport(world.getSpawnLocation());
    }

    @Command(names = {"towerdefense map delete", "towerdefense map remove"}, permission = "towerdefense.map.delete")
    public static void deleteMap(CommandSender sender, @Param(name = "map") GameWorld world) {
        sender.sendMessage(Util.format(TowerDefense.PREFIX + "Successfully deleted map '" + world.getName() + "'."));
        GameWorld.getGameWorlds().remove(world.getWorld());
    }

    @Command(names = {"towerdefense map teleport", "towerdefense map tp"}, permission = "towerdefense.map.teleport")
    public static void mapTeleport(Player player, @Param(name = "map") GameWorld world) {
        Location location = world.getLobbyPosition();
        if (location == null) location = world.getWorld().getSpawnLocation();

        player.teleport(location);
        player.sendMessage(Util.format("&aTeleporting to map '" + world.getName() + "'."));
    }

}
