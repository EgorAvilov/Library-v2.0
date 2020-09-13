package by.itechart.library.dao.util.impl;

import by.itechart.library.dao.util.api.StatementInitializer;
import by.itechart.library.entity.Book;
import by.itechart.library.entity.BorrowRecord;
import by.itechart.library.entity.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatementInitializerImpl implements StatementInitializer {
    @Override
    public void addBookId(PreparedStatement statement, int id) throws SQLException {
        statement.setInt(1, id);
    }

    @Override
    public void addBook(PreparedStatement statement, Book book) throws SQLException {
        try {
            statement.setBytes(1, book.getCover());
            statement.setNString(2, book.getTitle());
            statement.setNString(3, book.getAuthors());
            statement.setNString(4, book.getPublisher());
            statement.setDate(5, book.getPublishDate());
            statement.setNString(6, book.getGenres());
            statement.setInt(7, book.getPageCount());
            statement.setInt(8, book.getISBN());
            statement.setNString(9, book.getDescription());
            statement.setInt(10, book.getTotalAmount());
            statement.setInt(11, book.getAvailableAmount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateBook(PreparedStatement statement, Book book) throws SQLException {
        try {
            statement.setBytes(1, book.getCover());
            statement.setNString(2, book.getTitle());
            statement.setNString(3, book.getAuthors());
            statement.setNString(4, book.getPublisher());
            statement.setDate(5, book.getPublishDate());
            statement.setNString(6, book.getGenres());
            statement.setInt(7, book.getPageCount());
            statement.setInt(8, book.getISBN());
            statement.setNString(9, book.getDescription());
            statement.setInt(10, book.getTotalAmount());
            statement.setInt(11, book.getAvailableAmount());
            statement.setInt(12, book.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void changeDeletedStatus(PreparedStatement statement, boolean deletedStatus, int booksId) throws SQLException {
        statement.setBoolean(1, deletedStatus);
        statement.setInt(2, booksId);

    }

    @Override
    public void addBorrowRecord(PreparedStatement statement, BorrowRecord borrowRecord) throws SQLException {
        statement.setInt(1, borrowRecord.getUserId());
        statement.setDate(2, borrowRecord.getBorrowDate());
        statement.setDate(3, borrowRecord.getDueDate());
        statement.setInt(4, borrowRecord.getBookId());
    }

    @Override
    public void addUserId(PreparedStatement statement, int id) throws SQLException {
        statement.setInt(1, id);
    }

    @Override
    public void updateBorrowRecord(PreparedStatement statement, BorrowRecord borrowRecord) throws SQLException {
        statement.setDate(1, borrowRecord.getReturnDate());
        statement.setInt(2, borrowRecord.getStatusId());
        statement.setNString(3, borrowRecord.getComment());
        statement.setInt(4, borrowRecord.getId());
    }

    @Override
    public void addUser(PreparedStatement statement, User user) throws SQLException {
        statement.setNString(1, user.getFirstName());
        statement.setNString(2, user.getEmail());
        statement.setDate(3, user.getDateOfRegistration());
        statement.setNString(4, user.getPhoneNumber());
        statement.setNString(5, user.getGender());
        statement.setNString(6, user.getUsername());
        statement.setNString(7, user.getPassword());

    }

    @Override
    public void updateUser(PreparedStatement statement, User user) throws SQLException {
        statement.setNString(1, user.getFirstName());
        statement.setNString(2, user.getEmail());
        statement.setNString(3, user.getPhoneNumber());
        statement.setNString(4, user.getLastName());
        statement.setNString(5, user.getGender());
        statement.setNString(6, user.getPassword());
        statement.setInt(7, user.getId());
    }

    @Override
    public void addCredentials(PreparedStatement statement, String username, String password) throws SQLException {
        statement.setNString(1, username);
        statement.setNString(2, password);
    }
}
