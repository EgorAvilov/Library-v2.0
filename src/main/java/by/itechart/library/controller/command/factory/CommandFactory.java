package by.itechart.library.controller.command.factory;

import by.itechart.library.controller.command.Command;
import by.itechart.library.controller.command.impl.*;
import by.itechart.library.controller.util.ControllerUtilFactory;
import by.itechart.library.controller.util.api.HttpRequestResponseKeeper;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Log4j
public class CommandFactory {
    @Getter
    private static final CommandFactory instance = new CommandFactory();
    private final Map<String, Command> operations = new HashMap<>();

    private CommandFactory() {
        operations.put(CommandName.COMMAND_SIGN_IN, new SignInCommand());
        operations.put(CommandName.COMMAND_SIGN_UP, new SignUpCommand());
        operations.put(CommandName.COMMAND_SIGN_OUT, new SignOutCommand());
        operations.put(CommandName.COMMAND_GET_ALL_BOOKS, new GetAllBooksCommand());
        operations.put(CommandName.COMMAND_ADD_BOOK, new AddBookCommand());
        operations.put(CommandName.COMMAND_CHANGE_BOOK_DELETED_STATUS, new ChangeBookDeletedStatusCommand());
        operations.put(CommandName.COMMAND_GET_ALL_BORROW_RECORDS, new GetAllBorrowRecordsCommand());

        operations.put(CommandName.COMMAND_GET_ALL_BORROW_RECORDS_BY_USER_ID, new GetAllBorrowRecordsByUserIdCommand());///!!!!!
      //  operations.put(CommandName.COMMAND_ADD_USER, new AddUserCommand());
        operations.put(CommandName.COMMAND_GET_ALL_USERS, new GetAllUsersCommand());
        operations.put(CommandName.COMMAND_UPDATE_PROFILE, new UpdateProfileCommand());
        operations.put(CommandName.COMMAND_CHANGE_USER_DELETED_STATUS, new ChangeUserDeletedStatusCommand());
        operations.put(CommandName.COMMAND_FORWARD_TO_MAIN, new ForwardToMainCommand());

        operations.put(CommandName.COMMAND_GET_PROFILE, new GetProfileCommand());

    }


    public Command createCommand(String commandName, HttpServletRequest request, HttpServletResponse response){
        ControllerUtilFactory utilFactory = ControllerUtilFactory.getInstance();
        HttpRequestResponseKeeper keeper = utilFactory.getHttpRequestResponseKeeper();
        keeper.setAll(request, response);

        Command command = null;
        try{
            command = operations.get(commandName);
        } catch (IllegalArgumentException e){
            log.error(e);
        }
        return command;
    }

}
