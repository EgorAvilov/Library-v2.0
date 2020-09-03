package by.itechart.library.service.api;

import by.itechart.library.bean.Book;
import by.itechart.library.service.exception.ServiceException;

import java.util.List;

public interface UserService {
    public Book viewBookById(int id) throws ServiceException;
    public List<Book> viewAllBooks() throws ServiceException;

}
