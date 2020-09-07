package by.itechart.library.dao.impl;

import by.itechart.library.bean.Book;
import by.itechart.library.dao.SQLRequest;
import by.itechart.library.dao.api.BookDAO;
import by.itechart.library.dao.exception.DAOException;
import by.itechart.library.dao.pool.DBCPDataSource;
import by.itechart.library.dao.util.DAOUtilFactory;
import by.itechart.library.dao.util.api.ResourceCloser;
import by.itechart.library.dao.util.api.ResultCreator;
import by.itechart.library.dao.util.api.StatementInitializer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    private DAOUtilFactory utilFactory = DAOUtilFactory.getINSTANCE();
    private ResultCreator resultCreator = utilFactory.getResultCreator();
    private ResourceCloser resourceCloser = utilFactory.getResourceCloser();
    private StatementInitializer statementInitializer = utilFactory.getStatementInitializer();

    /**
     * довести все до ума
     */

    @Override
    public List<Book> getAllBooks() throws DAOException {
        String request = SQLRequest.GET_ALL_BOOKS;
        List<Book> books = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBCPDataSource.getConnection();
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = resultCreator.getNextBook(resultSet);
                books.add(book);
            }
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            resourceCloser.close(resultSet);
            resourceCloser.close(statement);

        }
        return books;
    }

    @Override
    public void addBook(Book book) throws DAOException {
        String request = SQLRequest.CREATE_BOOK;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBCPDataSource.getConnection();
            statement = connection.prepareStatement(request);
            statementInitializer.addBook(statement, book);
            statement.executeQuery();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            resourceCloser.close(statement);
        }
    }

    @Override
    public Book getBook(int id) throws DAOException {
        String request = SQLRequest.GET_BOOK_BY_ID;
        Book book = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBCPDataSource.getConnection();
            statement = connection.prepareStatement(request);
            statementInitializer.addBookId(statement, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                book = resultCreator.getNextBook(resultSet);
            }
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            resourceCloser.close(resultSet);
            resourceCloser.close(statement);

        }
        return book;
    }

    @Override
    public void updateBook(Book book) throws DAOException {
        String request = SQLRequest.UPDATE_BOOK;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBCPDataSource.getConnection();
            statement = connection.prepareStatement(request);
            statementInitializer.updateBook(statement, book);
            statement.executeQuery();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            resourceCloser.close(statement);

        }


    }

    @Override
    public int changeDeletedStatus(int bookId) throws DAOException {
        String request = SQLRequest.CHANGE_BOOK_DELETED_STATUS;
        Connection connection;
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = DBCPDataSource.getConnection();
            statement = connection.prepareStatement(request);
            Book book = getBook(bookId);
            statementInitializer.changeDeletedStatus(statement, !book.isDeletedStatus(), bookId);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            resourceCloser.close(statement);
        }
        return result;
    }
}
