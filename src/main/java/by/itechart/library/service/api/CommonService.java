package by.itechart.library.service.api;

import by.itechart.library.entity.Book;
import by.itechart.library.entity.User;
import by.itechart.library.service.exception.ServiceException;

import java.util.List;

public interface CommonService {

    public List<Book> getAllBooks() throws ServiceException;

    public User getProfile(int userId) throws ServiceException;

    public User signIn(String username, String password) throws ServiceException;

    public void updateProfile(User user) throws ServiceException;

}
