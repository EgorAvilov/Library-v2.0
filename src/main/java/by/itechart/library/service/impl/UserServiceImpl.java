package by.itechart.library.service.impl;

import by.itechart.library.bean.Book;
import by.itechart.library.bean.BorrowRecord;
import by.itechart.library.bean.User;
import by.itechart.library.dao.DAOFactory;
import by.itechart.library.dao.api.BookDAO;
import by.itechart.library.dao.api.BorrowRecordDAO;
import by.itechart.library.dao.api.UserDAO;
import by.itechart.library.dao.exception.DAOException;
import by.itechart.library.service.api.UserService;
import by.itechart.library.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private DAOFactory daoFactory = DAOFactory.getINSTANCE();

    private BookDAO bookDAO = daoFactory.getBookDAO();
    private BorrowRecordDAO borrowRecordDAO = daoFactory.getBorrowRecordDAO();
    private UserDAO userDAO = daoFactory.getUserDAO();


    @Override
    public Book viewBookById(int id) throws ServiceException {
        Book book = new Book();
        try {
            book = bookDAO.getBook(id);
        } catch (DAOException e) {
            new ServiceException(e);
        }
        return book;
    }

    @Override
    public List<Book> viewAllBooks() throws ServiceException {
        List<Book> books = new ArrayList<>();
        try {
            books = bookDAO.getAllBooks();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return books;
    }

    @Override
    public User signIn(String username, String password) throws ServiceException {
        User user=new User();
        try {
            user=userDAO.getUser(username, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return user;
    }

    @Override
    public void signUp(User reader) throws ServiceException {

        try {
            userDAO.addUser(reader);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public void addBorrowRecord(BorrowRecord borrowRecord) throws ServiceException {
        try {
            borrowRecordDAO.addBorrowRecord(borrowRecord);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User viewProfile(int readerId) throws ServiceException {
        User user = new User();

        try {
            user = userDAO.getUser(readerId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return user;
    }
}
