package dev.benergy10.commandexecutorapi.handlers;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class OpHandler implements Handler {
    @Override
    public void execute(@NotNull CommandSender target, @NotNull String commandString) {
        target.setOp(true);
        Bukkit.dispatchCommand(target, commandString);
        target.setOp(false);
    }

    @Override
    public @NotNull String getIdentifier() {
        return "op";
    }
}
