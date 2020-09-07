package by.itechart.library.controller.command.impl;

import by.itechart.library.controller.command.Command;
import by.itechart.library.controller.command.exception.CommandException;
import by.itechart.library.service.ServiceFactory;
import by.itechart.library.service.api.UserService;

import by.itechart.library.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetBookByIdCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String idNumber = request.getParameter("id-book");
        int id = Integer.parseInt(idNumber);

        ServiceFactory serviceFactory = ServiceFactory.getINSTANCE();
        UserService readerServiceImpl = serviceFactory.getUserServiceImpl();

        try {
            readerServiceImpl.viewBookById(id);
        } catch (ServiceException e) {
            throw new CommandException("", e);
        }
        return null;
    }

 /*   @Override
    public String execute() throws CommandException {
        return null;
    }*/
}
