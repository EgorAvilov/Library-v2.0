package by.itechart.library.service.api;

import by.itechart.library.entity.Book;
import by.itechart.library.entity.BorrowRecord;
import by.itechart.library.entity.User;
import by.itechart.library.service.exception.ServiceException;

import java.util.List;

public interface UserService {
    public Book getBookById(int id) throws ServiceException;//подумать нужен ли

    public List<Book> getAllBooks() throws ServiceException;

    public void signUp(User user) throws ServiceException;

    public void addBorrowRecord(BorrowRecord borrowRecord) throws ServiceException;

    public void updateBorrowRecord(BorrowRecord borrowRecord) throws ServiceException;

    public List<BorrowRecord> getAllBorrowRecords(int userId) throws ServiceException;









}
