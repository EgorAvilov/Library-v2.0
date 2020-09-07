package by.itechart.library.dao.impl;

import by.itechart.library.bean.Book;
import by.itechart.library.bean.Reader;
import by.itechart.library.dao.SQLRequest;
import by.itechart.library.dao.api.ReaderDAO;
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

public class ReaderDAOImpl implements ReaderDAO {
    private DAOUtilFactory utilFactory = DAOUtilFactory.getINSTANCE();
    private ResultCreator resultCreator = utilFactory.getResultCreator();
    private ResourceCloser resourceCloser = utilFactory.getResourceCloser();
    private StatementInitializer statementInitializer = utilFactory.getStatementInitializer();

    @Override
    public void addReader(Reader reader) throws DAOException {
        String request = SQLRequest.CREATE_READER;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBCPDataSource.getConnection();
            statement = connection.prepareStatement(request);
            statementInitializer.addReader(statement, reader);
            statement.executeQuery();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            resourceCloser.close(statement);
        }
    }

    @Override
    public Reader getReader(int id) throws DAOException {
        String request = SQLRequest.GET_READER_BY_ID;
        Reader reader = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBCPDataSource.getConnection();
            statement = connection.prepareStatement(request);
            statementInitializer.addReaderId(statement, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                reader = resultCreator.getNextReader(resultSet);
            }
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            resourceCloser.close(resultSet);
            resourceCloser.close(statement);

        }
        return reader;
    }

    @Override
    public void updateReader(Reader reader) throws DAOException {
        String request = SQLRequest.UPDATE_READER;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBCPDataSource.getConnection();
            statement = connection.prepareStatement(request);
            statementInitializer.updateReader(statement, reader);
            statement.executeQuery();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            resourceCloser.close(statement);

        }


    }

    @Override
    public List<Reader> getAllReaders() throws DAOException {
        String request = SQLRequest.GET_ALL_READERS;
        List<Reader> readers = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBCPDataSource.getConnection();
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Reader reader = resultCreator.getNextReader(resultSet);
                readers.add(reader);
            }
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            resourceCloser.close(resultSet);
            resourceCloser.close(statement);

        }
        return readers;
    }

    @Override
    public int changeDeletedStatus(int readerId) throws DAOException {
        String request = SQLRequest.CHANGE_READER_DELETED_STATUS;
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = DBCPDataSource.getConnection();
            statement = connection.prepareStatement(request);
            Reader reader = getReader(readerId);
            statementInitializer.changeDeletedStatus(statement, !reader.isDeletedStatus(), readerId);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            resourceCloser.close(statement);
        }
        return result;
    }

    @Override
    public Reader getReader(String username, String password) throws DAOException {
        String request = SQLRequest.GET_READER_BY_CREDENTIALS;
        Reader reader = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBCPDataSource.getConnection();
            statement = connection.prepareStatement(request);
            statementInitializer.addCredentials(statement, username, password);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                reader = resultCreator.getNextReader(resultSet);
            }
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            resourceCloser.close(resultSet);
            resourceCloser.close(statement);

        }
        return reader;
    }
}
