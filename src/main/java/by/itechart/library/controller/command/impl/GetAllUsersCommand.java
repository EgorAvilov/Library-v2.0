package by.itechart.library.controller.command.impl;

import by.itechart.library.bean.User;
import by.itechart.library.controller.command.Command;
import by.itechart.library.controller.command.exception.CommandException;
import by.itechart.library.controller.util.ControllerUtilFactory;
import by.itechart.library.controller.util.api.AttributesInitializer;
import by.itechart.library.controller.util.api.HttpRequestResponseKeeper;
import by.itechart.library.controller.util.api.PaginationCurrentPage;
import by.itechart.library.controller.util.api.PathCreator;
import by.itechart.library.service.ServiceFactory;
import by.itechart.library.service.api.AdminService;
import by.itechart.library.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetAllUsersCommand implements Command {
    private ControllerUtilFactory utilFactory = ControllerUtilFactory.getInstance();
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private AdminService adminService = serviceFactory.getAdminServiceImpl();

    @Override
    public String execute() throws CommandException {
        List<User> users;
        AttributesInitializer attributesInitializer = utilFactory.getAttributesInitializer();
        PaginationCurrentPage paginationCurrentPage = utilFactory.getPaginationCurrentPage();
        HttpRequestResponseKeeper keeper = utilFactory.getHttpRequestResponseKeeper();
        PathCreator pathCreator = utilFactory.getPathCreator();

        HttpServletRequest request = keeper.getRequest();
        HttpServletResponse response = keeper.getResponse();
        HttpSession session = request.getSession();

        String path = pathCreator.getError();

        try {
            users = adminService.getAllUsers();
            attributesInitializer.setRequestAttributesUsers(request, users);
            path = pathCreator.getUsersPage();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return path;
    }
}
