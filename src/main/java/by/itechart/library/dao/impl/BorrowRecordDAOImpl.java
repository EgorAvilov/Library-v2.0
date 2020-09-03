package by.itechart.library.dao.impl;

import by.itechart.library.bean.Book;
import by.itechart.library.bean.BorrowRecord;
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
    private DAOUtilFactory utilFactory = DAOUtilFactory.getINSTANCE();
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
            resourceCloser.close(connection);
        }
        return borrowRecords;
    }

    @Override
    public void addBorrowRecord(BorrowRecord borrowRecord) throws DAOException {

    }

    @Override
    public List<BorrowRecord> getAllByReaderId(int readerId) throws DAOException {
        return null;
    }

    @Override
    public void updateBorrowRecord(BorrowRecord borrowRecord) throws DAOException {

    }
}
