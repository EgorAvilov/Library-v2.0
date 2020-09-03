package by.itechart.library.controller.command.impl;

import by.itechart.library.controller.command.Command;
import by.itechart.library.controller.command.exception.CommandException;
import by.itechart.library.service.ServiceFactory;
import by.itechart.library.service.api.ReaderService;

import by.itechart.library.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetAllBooksCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        ServiceFactory serviceFactory = ServiceFactory.getINSTANCE();
        ReaderService readerServiceImpl = serviceFactory.getReaderServiceImpl();


        try {
            readerServiceImpl.viewAllBooks();
        } catch (ServiceException e) {
            throw new CommandException("", e);
        }
        return null;//возврат строки
    }
}
