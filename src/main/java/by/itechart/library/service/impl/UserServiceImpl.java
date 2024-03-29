package by.itechart.library.service.impl;

import by.itechart.library.entity.Book;
import by.itechart.library.entity.BorrowRecord;
import by.itechart.library.entity.User;
import by.itechart.library.dao.DAOFactory;
import by.itechart.library.dao.api.BookDAO;
import by.itechart.library.dao.api.BorrowRecordDAO;
import by.itechart.library.dao.api.UserDAO;
import by.itechart.library.dao.exception.DAOException;
import by.itechart.library.service.api.UserService;
import by.itechart.library.service.exception.ServiceException;

import java.util.List;

public class UserServiceImpl implements UserService {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private BookDAO bookDAO = daoFactory.getBookDAO();
    private BorrowRecordDAO borrowRecordDAO = daoFactory.getBorrowRecordDAO();
    private UserDAO userDAO = daoFactory.getUserDAO();

    @Override
    public Book getBookById(int id) throws ServiceException {
        Book book;
        try {
            book = bookDAO.getBook(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return book;
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
    public void signUp(User user) throws ServiceException {
        try {
            userDAO.addUser(user);
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
    public void updateBorrowRecord(BorrowRecord borrowRecord) throws ServiceException {
        try {
            borrowRecordDAO.updateBorrowRecord(borrowRecord);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<BorrowRecord> getAllBorrowRecords(int userId) throws ServiceException {
        List<BorrowRecord> borrowRecords;
        try {
            borrowRecords = borrowRecordDAO.getAllByUserId(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return borrowRecords;
    }

}
