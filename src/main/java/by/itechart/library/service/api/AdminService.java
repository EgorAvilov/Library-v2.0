package by.itechart.library.service.api;

import by.itechart.library.bean.Book;
import by.itechart.library.bean.User;
import by.itechart.library.service.exception.ServiceException;

import java.util.List;

public interface AdminService {
    public void addBook(Book book) throws ServiceException;

    public void updateBook(Book book) throws ServiceException;

    public List<Book> getAllBooks() throws ServiceException;

    public int changeBookDeletedStatus(int bookId) throws ServiceException;





    public int changeDeletedStatus(int userId) throws ServiceException;

    public void addUser(User user) throws ServiceException;

    public List<User> getAllReaders() throws ServiceException;


}
