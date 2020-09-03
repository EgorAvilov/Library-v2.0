package by.itechart.library.service.impl;

import by.itechart.library.bean.Book;
import by.itechart.library.bean.Reader;
import by.itechart.library.service.api.AdminService;
import by.itechart.library.service.exception.ServiceException;

import java.util.List;

public class AdminServiceImpl implements AdminService {


    @Override
    public void addBook(Book book) throws ServiceException {

    }

    @Override
    public List<Book> viewAllBooks() throws ServiceException {
        return null;
    }

    @Override
    public List<Reader> viewAllReaders() throws ServiceException {
        return null;
    }

    @Override
    public void updateBook(Book book) throws ServiceException {

    }

    @Override
    public int changeBookDeletedStatus(int bookId) throws ServiceException {
        return 0;
    }
}
