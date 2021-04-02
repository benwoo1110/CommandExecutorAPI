package dev.benergy10.commandexecutorapi.handlers;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class OpHandler implements Handler {
    @Override
    public void execute(@NotNull CommandSender target, @NotNull String commandString) {
        try {
            target.setOp(true);
            Bukkit.dispatchCommand(target, commandString);
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            target.setOp(false);
        }
    }

    @Override
    public @NotNull String getIdentifier() {
        return "op";
    }
}
