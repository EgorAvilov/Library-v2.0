package by.itechart.library.controller;

import by.itechart.library.controller.command.Command;
import by.itechart.library.controller.command.exception.CommandException;
import by.itechart.library.controller.command.factory.CommandFactory;
import by.itechart.library.controller.util.ControllerUtilFactory;
import by.itechart.library.controller.util.ParameterName;
import by.itechart.library.controller.util.api.PathCreator;
import lombok.extern.log4j.Log4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j
public class MainController extends HttpServlet {
    private static final long serialVersionUID = 1766930456155516074L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ControllerUtilFactory utilFactory = ControllerUtilFactory.getInstance();
        PathCreator pathCreator = utilFactory.getPathCreator();

        String action = request.getParameter(ParameterName.COMMAND);
        try {
            String path = getPath(action, request, response);
            response.sendRedirect(path);
        } catch (CommandException e) {
            log.error(e);
            response.sendRedirect(pathCreator.getError());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ControllerUtilFactory utilFactory = ControllerUtilFactory.getInstance();
        PathCreator pathCreator = utilFactory.getPathCreator();

        String action = request.getParameter(ParameterName.COMMAND);
        try {
            String path = getPath(action, request, response);
            RequestDispatcher dispatcher = request.getRequestDispatcher(path);
            dispatcher.forward(request, response);
        } catch (CommandException e) {
            log.error(e);
            response.sendRedirect(pathCreator.getError());
        }
    }

    private String getPath(String action, HttpServletRequest request, HttpServletResponse response) throws CommandException {
        CommandFactory commandFactory = CommandFactory.getInstance();

        Command command = commandFactory.createCommand(action, request, response);
        return command.execute();
    }

}
