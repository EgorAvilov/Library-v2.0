package by.itechart.library.service.api;

import by.itechart.library.bean.Book;
import by.itechart.library.bean.BorrowRecord;
import by.itechart.library.bean.User;
import by.itechart.library.service.exception.ServiceException;

import java.util.List;

public interface UserService {
    public Book getBookById(int id) throws ServiceException;

    public List<Book> getAllBooks() throws ServiceException;


    public User signIn(String username, String password) throws ServiceException;

    public void signUp(User user) throws ServiceException;

    public void addBorrowRecord(BorrowRecord borrowRecord) throws ServiceException;


    public void updateBorrowRecord(BorrowRecord borrowRecord) throws ServiceException;

    public List<BorrowRecord> getAllBorrowRecords(int userId) throws ServiceException;


    public User getProfile(int readerId) throws ServiceException;

    public void updateProfile(User user) throws ServiceException;






}
