package cf.grcq.priveapi;

import cf.grcq.priveapi.command.CommandHandler;
import cf.grcq.priveapi.language.LanguageHandler;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class PriveAPI {

    @Getter private static JavaPlugin instance;

    public static void init(JavaPlugin plugin) {
        instance = plugin;

        CommandHandler.init();
    }
}
