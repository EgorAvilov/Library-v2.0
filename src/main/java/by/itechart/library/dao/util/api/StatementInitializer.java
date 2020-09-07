package by.itechart.library.dao.util.api;

import by.itechart.library.bean.Book;
import by.itechart.library.bean.BorrowRecord;
import by.itechart.library.bean.Reader;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementInitializer {
    public void addBookId(PreparedStatement statement, int id) throws SQLException;

    public void addBook(PreparedStatement statement, Book book) throws SQLException;

    public void updateBook(PreparedStatement statement, Book book) throws SQLException;

    public void changeDeletedStatus(PreparedStatement statement, boolean deletedStatus, int booksId) throws SQLException;

    public void addBorrowRecord(PreparedStatement statement, BorrowRecord borrowRecord) throws SQLException;

    public void addReaderId(PreparedStatement statement, int id) throws SQLException;


    public void updateBorrowRecord(PreparedStatement statement, BorrowRecord borrowRecord) throws SQLException;

    public void addReader(PreparedStatement statement, Reader reader) throws SQLException;

    public void updateReader(PreparedStatement statement, Reader reader) throws SQLException;

    public void addCredentials(PreparedStatement statement, String username, String password) throws SQLException;
}
