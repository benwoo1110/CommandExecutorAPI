package dev.benergy10.commandexecutorapi.handlers;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class DefaultHandler implements Handler {
    @Override
    public void execute(@NotNull CommandSender target, @NotNull String commandString) {
        Bukkit.dispatchCommand(target, commandString);
    }

    @Override
    public @NotNull String getIdentifier() {
        return "";
    }
}
