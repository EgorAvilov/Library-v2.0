package by.itechart.library.service.impl;

import by.itechart.library.bean.Book;
import by.itechart.library.bean.BorrowRecord;
import by.itechart.library.bean.Reader;
import by.itechart.library.dao.DAOFactory;
import by.itechart.library.dao.api.BookDAO;
import by.itechart.library.dao.api.BorrowRecordDAO;
import by.itechart.library.dao.api.ReaderDAO;
import by.itechart.library.dao.exception.DAOException;

import by.itechart.library.service.api.ReaderService;
import by.itechart.library.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {

    private DAOFactory daoFactory=DAOFactory.getINSTANCE();

    private BookDAO bookDAO=daoFactory.getBookDAO();
    private BorrowRecordDAO borrowRecordDAO= daoFactory.getBorrowRecordDAO();
    private ReaderDAO readerDAO= daoFactory.getReaderDAO();


    @Override
    public Book viewBookById(int id) throws ServiceException {
      Book book=new Book();
        try {
            book=bookDAO.getBook(id);
        } catch (DAOException e) {
            new ServiceException(e);
        }
        return book;
    }

    @Override
    public List<Book> viewAllBooks() throws ServiceException {
       List<Book> books=new ArrayList<>();
        try {
            books=bookDAO.getAllBook();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return books;
    }

    @Override
    public Reader signIn(String username, String password) throws ServiceException {
        return null;
    }

    @Override
    public void signUp(Reader reader) throws ServiceException {

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
    public Reader viewProfile(int readerId) throws ServiceException {
       Reader reader=new Reader();

        try {
            reader=readerDAO.getReader(readerId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return reader;
    }


}
