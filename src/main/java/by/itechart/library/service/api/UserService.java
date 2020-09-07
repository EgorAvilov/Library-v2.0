package by.itechart.library.service.api;

import by.itechart.library.bean.Book;
import by.itechart.library.bean.BorrowRecord;
import by.itechart.library.bean.User;
import by.itechart.library.service.exception.ServiceException;

import java.util.List;

public interface UserService {
    public Book viewBookById(int id) throws ServiceException;
    public List<Book> viewAllBooks() throws ServiceException;


    public User signIn(String username, String password) throws  ServiceException;

   public void signUp(User reader) throws ServiceException;

   public void addBorrowRecord(BorrowRecord borrowRecord) throws ServiceException;

   public User viewProfile(int readerId) throws ServiceException;

}
