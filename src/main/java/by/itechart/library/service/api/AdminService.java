package by.itechart.library.service.api;

import by.itechart.library.bean.Book;
import by.itechart.library.bean.Reader;
import by.itechart.library.service.exception.ServiceException;

import java.util.List;

public interface AdminService {
    public void addBook(Book book) throws ServiceException;

    public List<Book> viewAllBooks() throws ServiceException;

    public List<Reader> viewAllReaders() throws ServiceException;

    public void updateBook(Book book) throws  ServiceException;

    public int changeBookDeletedStatus(int bookId) throws ServiceException;





}
