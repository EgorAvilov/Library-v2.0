package by.itechart.library.dao.util.api;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementInitializer {
    public void initBookId(PreparedStatement statement, int id) throws SQLException;


}
