package by.itechart.library.controller.command.factory;

import by.itechart.library.controller.command.Command;
import by.itechart.library.controller.command.impl.GetAllBooksCommand;
import by.itechart.library.controller.command.impl.GetBookByIdCommand;
import lombok.extern.log4j.Log4j;

import java.util.HashMap;
import java.util.Map;

@Log4j
public class CommandFactory {
    private static final CommandFactory INSTANCE = new CommandFactory();
    private final Map<String, Command> operations = new HashMap<>();

    private CommandFactory() {
        operations.put("get-book-by-id", new GetBookByIdCommand());
        operations.put("get-all-book", new GetAllBooksCommand());
    }


    public static CommandFactory getINSTANCE() {
        return INSTANCE;
    }

    public Command getCommand(String commandName) {
        Command command = null;
        try {
            command = operations.get(commandName);
        } catch (IllegalArgumentException e) {
            log.error(e);
        }
        return command;
    }

}
