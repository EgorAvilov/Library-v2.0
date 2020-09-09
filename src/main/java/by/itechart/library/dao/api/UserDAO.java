package by.itechart.library.dao.api;

import by.itechart.library.bean.User;
import by.itechart.library.dao.exception.DAOException;

import java.util.List;


public interface UserDAO {

    public void addUser(User user) throws DAOException;

    public User getUser(int id) throws DAOException;

    public void updateUser(User user) throws DAOException;

    public List<User> getAllUsers() throws DAOException;

    public int changeDeletedStatus(int userId) throws DAOException;

    public User getUser(String username, String password) throws DAOException;
}
