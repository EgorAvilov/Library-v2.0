package by.itechart.library.dao.util.api;

import by.itechart.library.bean.Book;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementInitializer {
    public void addBookId(PreparedStatement statement, int id) throws SQLException;
    public void addBook(PreparedStatement statement,Book book);
public void updateBook(PreparedStatement statement, Book book);

}
