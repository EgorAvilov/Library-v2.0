package by.itechart.library.dao.util.impl;

import by.itechart.library.entity.Book;
import by.itechart.library.entity.BorrowRecord;
import by.itechart.library.entity.User;
import by.itechart.library.dao.util.api.ResultCreator;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultCreatorImpl implements ResultCreator {
    @Override
    public Book getNextBook(ResultSet resultSet) throws SQLException {
       return new Book();//здесь дописать реализацию через список колонок
    }

    @Override
    public BorrowRecord getNextBorrowRecord(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public User getNextUser(ResultSet resultSet) throws SQLException {
        return null;
    }
}
