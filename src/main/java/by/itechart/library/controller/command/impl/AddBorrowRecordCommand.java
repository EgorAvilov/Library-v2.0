package by.itechart.library.controller.command.impl;

import by.itechart.library.entity.BorrowRecord;
import by.itechart.library.controller.command.Command;
import by.itechart.library.controller.command.exception.CommandException;
import by.itechart.library.controller.util.ControllerUtilFactory;
import by.itechart.library.controller.util.ParameterName;
import by.itechart.library.controller.util.api.HttpRequestResponseKeeper;
import by.itechart.library.controller.util.api.PathCreator;
import by.itechart.library.service.ServiceFactory;
import by.itechart.library.service.api.UserService;
import by.itechart.library.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;

public class AddBorrowRecordCommand implements Command {
    private ControllerUtilFactory utilFactory = ControllerUtilFactory.getInstance();
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private UserService userService = serviceFactory.getUserServiceImpl();
    @Override
    public String execute() throws CommandException {
        PathCreator pathCreator = utilFactory.getPathCreator();
        HttpRequestResponseKeeper keeper = utilFactory.getHttpRequestResponseKeeper();

        HttpServletRequest request = keeper.getRequest();
        HttpServletResponse response = keeper.getResponse();

        String path = pathCreator.getError();
        HttpSession session = request.getSession();
        int userId= (int) session.getAttribute(ParameterName.USER_ID);
       // int userId= Integer.parseInt(request.getParameter(ParameterName.USER_ID));
        Date borrowDate= Date.valueOf(LocalDate.now ());
        Date dueDate= Date.valueOf(request.getParameter(ParameterName.DUE_DATE));
        int bookId= Integer.parseInt(request.getParameter(ParameterName.BOOK_ID));

        BorrowRecord borrowRecord=new BorrowRecord();
        borrowRecord.setBookId(bookId);
        borrowRecord.setUserId(userId);
        borrowRecord.setDueDate(dueDate);
        borrowRecord.setBorrowDate(borrowDate);
        try {
            userService.addBorrowRecord(borrowRecord);
             path=pathCreator.getBooksPage();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return path;



    }
}
