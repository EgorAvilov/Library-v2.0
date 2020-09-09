package by.itechart.library.controller.command.impl;

import by.itechart.library.bean.User;
import by.itechart.library.controller.command.Command;
import by.itechart.library.controller.command.exception.CommandException;
import by.itechart.library.controller.util.ControllerUtilFactory;
import by.itechart.library.controller.util.ParameterName;
import by.itechart.library.controller.util.api.AttributesInitializer;
import by.itechart.library.controller.util.api.HttpRequestResponseKeeper;
import by.itechart.library.controller.util.api.PathCreator;
import by.itechart.library.service.ServiceFactory;
import by.itechart.library.service.api.UserService;
import by.itechart.library.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetProfileCommand implements Command {
    private ControllerUtilFactory utilFactory = ControllerUtilFactory.getInstance();
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private UserService userService = serviceFactory.getUserServiceImpl();


    @Override
    public String execute() throws CommandException {
        PathCreator pathCreator = utilFactory.getPathCreator();
        AttributesInitializer attributesInitializer = utilFactory.getAttributesInitializer();
        HttpRequestResponseKeeper keeper = utilFactory.getHttpRequestResponseKeeper();


        String path = pathCreator.getError();

        HttpServletRequest request = keeper.getRequest();
        HttpServletResponse response = keeper.getResponse();

        HttpSession session = request.getSession();
        int userId = (Integer) session.getAttribute(ParameterName.USER_ID);

        User user;
        try {
            user = userService.getProfile(userId);
            attributesInitializer.setRequestAttributesUser(request, user);
            // path = pathCreator.getUserPage();

        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return path;


    }
}
