package by.itechart.library.dao.api;

import by.itechart.library.bean.Book;
import by.itechart.library.dao.exception.DAOException;

import java.util.List;

public interface BookDAO {

    public List<Book> getAllBooks() throws DAOException;

    public void addBook(Book book) throws DAOException;

    public Book getBook(int id) throws DAOException;

    public void updateBook(Book book) throws DAOException;

    public int changeDeletedStatus(int bookId) throws DAOException;



}
