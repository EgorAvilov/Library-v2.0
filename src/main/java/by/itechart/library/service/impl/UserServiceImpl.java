package by.itechart.library.service.impl;

import by.itechart.library.bean.Book;
import by.itechart.library.dao.exception.DAOException;
import by.itechart.library.service.api.UserService;
import by.itechart.library.service.exception.ServiceException;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public Book viewBookById(int id) throws ServiceException {
       /* try {

        } catch (DAOException e){
            throw new ServiceException(e);
        }*/
        return null;
    }

    @Override
    public List<Book> viewAllBooks() throws ServiceException {
        return null;
    }
}
