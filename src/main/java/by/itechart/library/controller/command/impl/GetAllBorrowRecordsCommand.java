package by.itechart.library.controller.command.impl;

import by.itechart.library.controller.command.Command;
import by.itechart.library.controller.command.exception.CommandException;
import by.itechart.library.controller.util.ControllerUtilFactory;
import by.itechart.library.controller.util.ParameterName;
import by.itechart.library.controller.util.api.*;
import by.itechart.library.entity.BorrowRecord;
import by.itechart.library.service.ServiceFactory;
import by.itechart.library.service.api.AdminService;
import by.itechart.library.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetAllBorrowRecordsCommand implements Command {

    private ControllerUtilFactory utilFactory = ControllerUtilFactory.getInstance();
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private AdminService adminService = serviceFactory.getAdminServiceImpl();

    @Override
    public String execute() throws CommandException {
        List<BorrowRecord> borrowRecords;
        ControllerValueChecker valueChecker = utilFactory.getControllerValueChecker();
        AttributesInitializer attributesInitializer = utilFactory.getAttributesInitializer();
        PaginationCurrentPage paginationCurrentPage = utilFactory.getPaginationCurrentPage();
        HttpRequestResponseKeeper keeper = utilFactory.getHttpRequestResponseKeeper();
        PathCreator pathCreator = utilFactory.getPathCreator();


        HttpServletRequest request = keeper.getRequest();
        HttpServletResponse response = keeper.getResponse();

        HttpSession session = request.getSession();
        int role = (Integer) session.getAttribute(ParameterName.ROLE);

        String path = pathCreator.getError();

        try {
            if (valueChecker.isAdmin(role)) {
                borrowRecords = adminService.getAllBorrowRecords();
                attributesInitializer.setRequestAttributesBorrowRecords(request, borrowRecords);
                path = pathCreator.getBorrowRecordsPage();
            } else {
                path = pathCreator.getError();
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return path;
    }
}
