package by.itechart.library.dao.impl;

import by.itechart.library.entity.BorrowRecord;
import by.itechart.library.dao.SQLRequest;
import by.itechart.library.dao.api.BorrowRecordDAO;
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

public class BorrowRecordDAOImpl implements BorrowRecordDAO {
    private DAOUtilFactory utilFactory = DAOUtilFactory.getInstance();
    private ResultCreator resultCreator = utilFactory.getResultCreator();
    private ResourceCloser resourceCloser = utilFactory.getResourceCloser();
    private StatementInitializer statementInitializer = utilFactory.getStatementInitializer();

    @Override
    public List<BorrowRecord> getAll() throws DAOException {
        String request = SQLRequest.GET_ALL_BORROW_RECORDS;
        List<BorrowRecord> borrowRecords = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBCPDataSource.getConnection();
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                BorrowRecord borrowRecord = resultCreator.getNextBorrowRecord(resultSet);
                borrowRecords.add(borrowRecord);
            }
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            resourceCloser.close(resultSet);
            resourceCloser.close(statement);
        }
        return borrowRecords;
    }

    @Override
    public void addBorrowRecord(BorrowRecord borrowRecord) throws DAOException {
        String request = SQLRequest.CREATE_BORROW_RECORD;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBCPDataSource.getConnection();
            statement = connection.prepareStatement(request);
            statementInitializer.addBorrowRecord(statement, borrowRecord);
            statement.executeQuery();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            resourceCloser.close(statement);
        }
    }

    @Override
    public List<BorrowRecord> getAllByUserId(int readerId) throws DAOException {
        String request = SQLRequest.GET_BORROW_RECORDS_BY_USER_ID;
        List<BorrowRecord> borrowRecords = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBCPDataSource.getConnection();
            statement = connection.prepareStatement(request);
            statementInitializer.addUserId(statement, readerId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                BorrowRecord borrowRecord = resultCreator.getNextBorrowRecord(resultSet);
                borrowRecords.add(borrowRecord);
            }
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            resourceCloser.close(resultSet);
            resourceCloser.close(statement);
        }
        return borrowRecords;
    }

    @Override
    public void updateBorrowRecord(BorrowRecord borrowRecord) throws DAOException {
        String request = SQLRequest.UPDATE_BORROW_RECORD;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBCPDataSource.getConnection();
            statement = connection.prepareStatement(request);
            statementInitializer.updateBorrowRecord(statement, borrowRecord);
            statement.executeQuery();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            resourceCloser.close(statement);
        }
    }
}
