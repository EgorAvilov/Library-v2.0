package by.itechart.library.service.api;

import by.itechart.library.entity.Book;
import by.itechart.library.entity.BorrowRecord;
import by.itechart.library.entity.User;
import by.itechart.library.service.exception.ServiceException;

import java.util.List;

public interface AdminService {
    public void addBook(Book book) throws ServiceException;

    public void updateBook(Book book) throws ServiceException;


    public int changeBookDeletedStatus(int bookId) throws ServiceException;

    public List<BorrowRecord> getAllBorrowRecords() throws ServiceException;

    public List<BorrowRecord> getAllBorrowRecordsByUserId(int userId) throws ServiceException;

    public int changeUserDeletedStatus(int userId) throws ServiceException;

    public void addUser(User user) throws ServiceException;

    public List<User> getAllUsers() throws ServiceException;


}
