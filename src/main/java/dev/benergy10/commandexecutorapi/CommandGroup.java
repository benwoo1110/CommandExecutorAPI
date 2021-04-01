package dev.benergy10.commandexecutorapi;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CommandGroup implements Collection<Command> {

    private final List<Command> commands;

    public CommandGroup() {
        this.commands = new ArrayList<>();
    }

    public void executeAll(CommandSender target) {
        this.commands.forEach(command -> command.execute(target));
    }

    @Override
    public int size() {
        return this.commands.size();
    }

    @Override
    public boolean isEmpty() {
        return this.commands.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.commands.contains(o);
    }

    @NotNull
    @Override
    public Iterator<Command> iterator() {
        return this.commands.iterator();
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return this.commands.toArray();
    }

    @NotNull
    @Override
    public <T> T[] toArray(@NotNull T[] a) {
        return this.commands.toArray(a);
    }

    public boolean add(Command command) {
        return this.commands.add(command);
    }

    @Override
    public boolean remove(Object o) {
        return this.commands.remove(o);
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        return this.commands.containsAll(c);
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends Command> c) {
        return this.commands.addAll(c);
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        return this.commands.removeAll(c);
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        return this.commands.retainAll(c);
    }

    @Override
    public void clear() {
        this.commands.clear();
    }
}
