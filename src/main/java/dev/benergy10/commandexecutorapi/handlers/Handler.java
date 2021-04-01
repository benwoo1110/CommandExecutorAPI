package dev.benergy10.commandexecutorapi.handlers;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public interface Handler {
    void execute(@NotNull CommandSender target, @NotNull String commandString);
    @NotNull String getIdentifier();
}
