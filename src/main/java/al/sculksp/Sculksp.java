package al.sculksp;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import al.sculksp.event.ON_Sculk_SHIRK;

public final class Sculksp extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        logsay("SculkSP is Enable");
        this.getServer().getPluginManager().registerEvents(new ON_Sculk_SHIRK(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        logsay("SculkSP is Disable");
    }

    public void logsay(String str) {
        CommandSender sender = Bukkit.getConsoleSender();
        sender.sendMessage(str);
    }
}
