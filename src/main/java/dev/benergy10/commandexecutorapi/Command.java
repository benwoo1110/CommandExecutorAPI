package dev.benergy10.commandexecutorapi;

import dev.benergy10.commandexecutorapi.handlers.Handler;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Command {

    private final CommandProvider provider;
    private final Handler handler;
    private final String commandString;

    public Command(CommandProvider provider, Handler handler, String commandString) {
        this.provider = provider;
        this.handler = handler;
        this.commandString = commandString;
    }

    public void execute(CommandSender target) {
        this.handler.execute(target, this.parseCommandString(target));
    }

    public String parseCommandString(CommandSender target) {
        String parsedCommand = this.commandString.replaceAll("%player%", target.getName());

        if (target instanceof Entity) {
            Entity entity = (Entity) target;
            parsedCommand = parsedCommand.replaceAll("%world%", entity.getWorld().getName());
        }

        if (provider.shouldResolvePapiPlaceholders() && target instanceof Player) {
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
