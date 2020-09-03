package by.itechart.library.dao.util.impl;

import by.itechart.library.bean.Book;
import by.itechart.library.dao.util.api.StatementInitializer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatementInitializerImpl implements StatementInitializer {
    @Override
    public void addBookId(PreparedStatement statement, int id) throws SQLException {
        statement.setInt(1, id);
    }

    @Override
    public void addBook(PreparedStatement statement, Book book) {
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
    public void updateBook(PreparedStatement statement, Book book) {
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
}
