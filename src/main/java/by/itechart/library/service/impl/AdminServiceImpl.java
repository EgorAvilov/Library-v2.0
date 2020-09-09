package by.itechart.library.service.impl;

import by.itechart.library.entity.Book;
import by.itechart.library.entity.BorrowRecord;
import by.itechart.library.entity.User;
import by.itechart.library.dao.DAOFactory;
import by.itechart.library.dao.api.BookDAO;
import by.itechart.library.dao.api.BorrowRecordDAO;
import by.itechart.library.dao.api.UserDAO;
import by.itechart.library.dao.exception.DAOException;
import by.itechart.library.service.api.AdminService;
import by.itechart.library.service.exception.ServiceException;

import java.util.List;

public class AdminServiceImpl implements AdminService {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private BookDAO bookDAO = daoFactory.getBookDAO();
    private BorrowRecordDAO borrowRecordDAO = daoFactory.getBorrowRecordDAO();
    private UserDAO userDAO = daoFactory.getUserDAO();

    @Override
    public void addBook(Book book) throws ServiceException {
        try {//проветь id
            bookDAO.addBook(book);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateBook(Book book) throws ServiceException {
        try {
            bookDAO.updateBook(book);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Book> getAllBooks() throws ServiceException {
        List<Book> books;
        try {
            books = bookDAO.getAllBooks();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return books;
    }

    @Override
    public int changeBookDeletedStatus(int bookId) throws ServiceException {
        int result;
        try {
            result = bookDAO.changeDeletedStatus(bookId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public List<BorrowRecord> getAllBorrowRecords() throws ServiceException {
        List<BorrowRecord> borrowRecords;
        try {
            borrowRecords = borrowRecordDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return borrowRecords;
    }

    @Override
    public List<BorrowRecord> getAllBorrowRecordsByUserId(int userId) throws ServiceException {
        List<BorrowRecord> borrowRecords;
        try {
            borrowRecords = borrowRecordDAO.getAllByUserId(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return borrowRecords;
    }

    @Override
    public int changeUserDeletedStatus(int userId) throws ServiceException {
        int result;
        try {
            result = userDAO.changeDeletedStatus(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public void addUser(User user) throws ServiceException {
        try {
            userDAO.addUser(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getAllUsers() throws ServiceException {
        List<User> users;
        try {
            users = userDAO.getAllUsers();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return users;
    }
}
