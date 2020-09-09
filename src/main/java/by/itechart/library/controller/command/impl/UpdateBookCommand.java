package by.itechart.library.controller.command.impl;

import by.itechart.library.bean.Book;
import by.itechart.library.controller.command.Command;
import by.itechart.library.controller.command.exception.CommandException;
import by.itechart.library.controller.util.ControllerUtilFactory;
import by.itechart.library.controller.util.ParameterName;
import by.itechart.library.controller.util.api.HttpRequestResponseKeeper;
import by.itechart.library.controller.util.api.PathCreator;
import by.itechart.library.service.ServiceFactory;
import by.itechart.library.service.api.AdminService;
import by.itechart.library.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class UpdateBookCommand implements Command {
    private ControllerUtilFactory utilFactory = ControllerUtilFactory.getInstance();
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private AdminService adminService = serviceFactory.getAdminServiceImpl();

    @Override
    public String execute() throws CommandException {

        PathCreator pathCreator = utilFactory.getPathCreator();
        HttpRequestResponseKeeper keeper = utilFactory.getHttpRequestResponseKeeper();

        HttpServletRequest request = keeper.getRequest();
        HttpServletResponse response = keeper.getResponse();

        String path = pathCreator.getError();
        int id = Integer.parseInt(request.getParameter(ParameterName.BOOK_ID));
        byte[] cover = request.getParameter(ParameterName.COVER).getBytes();
        String title = request.getParameter(ParameterName.TITLE);
        String authors = request.getParameter(ParameterName.AUTHORS);
        String publisher = request.getParameter(ParameterName.PUBLISHER);
        Date publishDate = Date.valueOf(request.getParameter(ParameterName.PUBLISH_DATE));
        String genres = request.getParameter(ParameterName.GENRES);
        int pageCount = Integer.parseInt(request.getParameter(ParameterName.PAGE_COUNT));
        int ISBN = Integer.parseInt(request.getParameter(ParameterName.ISBN));
        String description = request.getParameter(ParameterName.DESCRIPTION);
        int totalAmount = Integer.parseInt(request.getParameter(ParameterName.TOTAL_AMOUNT));

        Book book = new Book();
        book.setId(id);
        book.setCover(cover);
        book.setTitle(title);
        book.setAuthors(authors);
        book.setPublisher(publisher);
        book.setPublishDate(publishDate);
        book.setGenres(genres);
        book.setPageCount(pageCount);
        book.setISBN(ISBN);
        book.setDescription(description);
        book.setTotalAmount(totalAmount);
        try {
            adminService.addBook(book);
            // path=pathCreator.ge
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return path;
    }
}
