package by.itechart.library.dao.impl;

import by.itechart.library.entity.User;
import by.itechart.library.dao.SQLRequest;
import by.itechart.library.dao.api.UserDAO;
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

public class UserDAOImpl implements UserDAO {
    private DAOUtilFactory utilFactory = DAOUtilFactory.getInstance();
    private ResultCreator resultCreator = utilFactory.getResultCreator();
    private ResourceCloser resourceCloser = utilFactory.getResourceCloser();
    private StatementInitializer statementInitializer = utilFactory.getStatementInitializer();

    @Override
    public void addUser(User user) throws DAOException {
        String request = SQLRequest.CREATE_USER;
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = DBCPDataSource.getConnection();
            statement = connection.prepareStatement(request);
            statementInitializer.addUser(statement, user);
            statement.executeQuery();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            resourceCloser.close(statement);
        }
    }

    @Override
    public User getUser(int id) throws DAOException {
        String request = SQLRequest.GET_USER_BY_ID;
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBCPDataSource.getConnection();
            statement = connection.prepareStatement(request);
            statementInitializer.addUserId(statement, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = resultCreator.getNextUser(resultSet);
            }
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            resourceCloser.close(resultSet);
            resourceCloser.close(statement);

        }
        return user;
    }

    @Override
    public void updateUser(User user) throws DAOException {
        String request = SQLRequest.UPDATE_USER;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBCPDataSource.getConnection();
            statement = connection.prepareStatement(request);
            statementInitializer.updateUser(statement, user);
            statement.executeQuery();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            resourceCloser.close(statement);

        }


    }

    @Override
    public List<User> getAllUsers() throws DAOException {
        String request = SQLRequest.GET_ALL_USERS;
        List<User> users = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBCPDataSource.getConnection();
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = resultCreator.getNextUser(resultSet);
                users.add(user);
            }
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            resourceCloser.close(resultSet);
            resourceCloser.close(statement);

        }
        return users;
    }

    @Override
    public int changeDeletedStatus(int userId) throws DAOException {
        String request = SQLRequest.CHANGE_USER_DELETED_STATUS;
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = DBCPDataSource.getConnection();
            statement = connection.prepareStatement(request);
            User user = getUser(userId);
            statementInitializer.changeDeletedStatus(statement, !user.isDeletedStatus(), userId);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            resourceCloser.close(statement);
        }
        return result;
    }

    @Override
    public User getUser(String username, String password) throws DAOException {
        String request = SQLRequest.GET_USER_BY_CREDENTIALS;
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBCPDataSource.getConnection();
            statement = connection.prepareStatement(request);
            statementInitializer.addCredentials(statement, username, password);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = resultCreator.getNextUser(resultSet);
            }
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            resourceCloser.close(resultSet);
            resourceCloser.close(statement);

        }
        return user;
    }
}
