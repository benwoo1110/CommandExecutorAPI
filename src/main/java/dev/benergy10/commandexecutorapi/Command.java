package dev.benergy10.commandexecutorapi;

import dev.benergy10.commandexecutorapi.handlers.Handler;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Command {

    private static boolean hasPapi = false;

    static {
        try {
            Class.forName("me.clip.placeholderapi.PlaceholderAPI");
            hasPapi = true;
        } catch (ClassNotFoundException e) {
            // ignore
        }
    }
    
    private final Handler handler;
    private final String commandString;

    public Command(Handler handler, String commandString) {
        this.handler = handler;
        this.commandString = commandString;
    }

    public void execute(CommandSender target) {
        this.handler.execute(target, this.replacePlaceholders(target));
    }

    public String replacePlaceholders(CommandSender target) {
        String parsedCommand = this.commandString.replaceAll("%player%", target.getName());

        if (target instanceof Entity) {
            Entity entity = (Entity) target;
            parsedCommand = parsedCommand.replaceAll("%world%", entity.getWorld().getName());
        }

        if (hasPapi && target instanceof Player) {
            parsedCommand = PlaceholderAPI.setPlaceholders((Player) target, parsedCommand);
        }

        return parsedCommand;
    }

    public Handler getHandler() {
        return handler;
    }

    public String getCommandString() {
        return commandString;
    }

    @Override
    public String toString() {
        return this.handler.getIdentifier() + ":" + this.commandString;
    }
}
