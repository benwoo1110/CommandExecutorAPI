package dev.benergy10.commandexecutorapi.handlers;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ConsoleHandler implements Handler {
    @Override
    public void execute(@NotNull CommandSender target, @NotNull String commandString) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), commandString);
    }

    @Override
    public @NotNull String getIdentifier() {
        return "console";
    }
}
