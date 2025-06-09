package dev.benergy10.commandexecutorapi.handlers;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import static com.oracle.graal.compiler.enterprise.c.t;

public class OpHandler implements Handler {
    @Override
    public void execute(@NotNull CommandSender target, @NotNull String commandString) {
        boolean isTargetOp = target.isOp();
        try {
            if (!isTargetOp) {
                target.setOp(true);
            }
            Bukkit.dispatchCommand(target, commandString);
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            if (!isTargetOp) {
                target.setOp(false);
            }
        }
    }

    @Override
    public @NotNull String getIdentifier() {
        return "op";
    }
}
