package by.itechart.library.service;

import by.itechart.library.service.api.AdminService;
import by.itechart.library.service.api.UserService;
import by.itechart.library.service.impl.AdminServiceImpl;
import by.itechart.library.service.impl.UserServiceImpl;
import lombok.Getter;


public class ServiceFactory {
    @Getter
    private static final ServiceFactory Instance = new ServiceFactory();
    @Getter
    private UserService userServiceImpl = new UserServiceImpl();
    @Getter
    private AdminService adminServiceImpl = new AdminServiceImpl();


}
