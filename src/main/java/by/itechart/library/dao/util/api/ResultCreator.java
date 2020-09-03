package by.itechart.library.dao.util.api;

import by.itechart.library.bean.Book;
import by.itechart.library.bean.BorrowRecord;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultCreator {
    public Book getNextBook(ResultSet resultSet) throws SQLException;
    public BorrowRecord getNextBorrowRecord(ResultSet resultSet) throws SQLException;

}
