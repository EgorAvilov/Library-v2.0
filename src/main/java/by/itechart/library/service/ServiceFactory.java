package by.itechart.library.service;

import by.itechart.library.service.api.AdminService;
import by.itechart.library.service.api.ReaderService;

import by.itechart.library.service.impl.AdminServiceImpl;
import by.itechart.library.service.impl.ReaderServiceImpl;
import lombok.Getter;


public class ServiceFactory {
    @Getter
    private static final ServiceFactory INSTANCE = new ServiceFactory();

    @Getter
    private ReaderService readerServiceImpl = new ReaderServiceImpl();
    @Getter
    private AdminService adminServiceImpl =  new AdminServiceImpl();


}
