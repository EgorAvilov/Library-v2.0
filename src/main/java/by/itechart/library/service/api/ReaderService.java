package by.itechart.library.service.api;

import by.itechart.library.bean.Book;
import by.itechart.library.bean.BorrowRecord;
import by.itechart.library.bean.Reader;
import by.itechart.library.service.exception.ServiceException;

import java.util.List;

public interface ReaderService {
    public Book viewBookById(int id) throws ServiceException;
    public List<Book> viewAllBooks() throws ServiceException;


    public Reader signIn(String username, String password) throws  ServiceException;

   public void signUp(Reader reader) throws ServiceException;

   public void addBorrowRecord(BorrowRecord borrowRecord) throws ServiceException;

   public Reader viewProfile(int readerId) throws ServiceException;

}
