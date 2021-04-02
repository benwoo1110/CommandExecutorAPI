package dev.benergy10.commandexecutorapi;

import dev.benergy10.commandexecutorapi.handlers.ConsoleHandler;
import dev.benergy10.commandexecutorapi.handlers.DefaultHandler;
import dev.benergy10.commandexecutorapi.handlers.Handler;
import dev.benergy10.commandexecutorapi.handlers.OpHandler;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CommandProvider {

    private static final Pattern COLON_SPLIT = Pattern.compile(":");

    private final Map<String, Handler> handlerTypes;
    private Handler defaultHandler;

    public CommandProvider() {
        this.handlerTypes = new HashMap<>();
        this.registerHandler(new DefaultHandler());
        this.registerHandler(new ConsoleHandler());
        this.registerHandler(new OpHandler());
        this.setDefaultHandler("");
    }

    public void registerHandler(Handler handler) {
        this.handlerTypes.put(handler.getIdentifier(), handler);
    }

    public Handler getHandler(String identifier) {
        return this.handlerTypes.get(identifier);
    }

    public void setDefaultHandler(String identifier) {
        this.defaultHandler = this.getHandler(identifier);
    }

    public Command toCommand(String command) {
        String[] commandSplit = COLON_SPLIT.split(command, 2);
        if (commandSplit.length == 1) {
            return new Command(this.defaultHandler, command);
        }
        Handler handler = this.getHandler(commandSplit[1]);
        if (handler == null) {
            return new Command(this.defaultHandler, command);
        }
        return new Command(handler, commandSplit[1]);
    }

    public CommandGroup toCommandGroup(Collection<String> commands) {
        return commands.stream().map(this::toCommand).collect(Collectors.toCollection(CommandGroup::new));
    }
}
