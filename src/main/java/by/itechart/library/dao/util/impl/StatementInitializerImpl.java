package by.itechart.library.dao.util.impl;

import by.itechart.library.dao.util.api.StatementInitializer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatementInitializerImpl implements StatementInitializer {
    @Override
    public void initBookId(PreparedStatement statement, int id) throws SQLException {
        statement.setInt(1, id);
    }
}
