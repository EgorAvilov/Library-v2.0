package by.itechart.library.service.impl;

import by.itechart.library.bean.Book;
import by.itechart.library.bean.User;
import by.itechart.library.service.api.AdminService;
import by.itechart.library.service.exception.ServiceException;

import java.util.List;

public class AdminServiceImpl implements AdminService {


    @Override
    public void addBook(Book book) throws ServiceException {
    }


    @Override
    public void updateBook(Book book) throws ServiceException {

    }

    @Override
    public List<Book> getAllBooks() throws ServiceException {
        return null;
    }

    @Override
    public int changeBookDeletedStatus(int bookId) throws ServiceException {
        return 0;
    }

    @Override
    public int changeDeletedStatus(int userId) throws ServiceException {
        return 0;
    }

    @Override
    public void addUser(User user) throws ServiceException {

    }

    @Override
    public List<User> getAllReaders() throws ServiceException {
        return null;
    }
}
