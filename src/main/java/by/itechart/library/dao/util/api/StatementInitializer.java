package by.itechart.library.dao.util.api;

import by.itechart.library.entity.Book;
import by.itechart.library.entity.BorrowRecord;
import by.itechart.library.entity.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementInitializer {
    public void addBookId(PreparedStatement statement, int id) throws SQLException;

    public void addBook(PreparedStatement statement, Book book) throws SQLException;

    public void updateBook(PreparedStatement statement, Book book) throws SQLException;

    public void changeDeletedStatus(PreparedStatement statement, boolean deletedStatus, int booksId) throws SQLException;

    public void addBorrowRecord(PreparedStatement statement, BorrowRecord borrowRecord) throws SQLException;

    public void addUserId(PreparedStatement statement, int id) throws SQLException;

    public void updateBorrowRecord(PreparedStatement statement, BorrowRecord borrowRecord) throws SQLException;

    public void addUser(PreparedStatement statement, User user) throws SQLException;

    public void updateUser(PreparedStatement statement, User user) throws SQLException;

    public void addCredentials(PreparedStatement statement, String username, String password) throws SQLException;
}
