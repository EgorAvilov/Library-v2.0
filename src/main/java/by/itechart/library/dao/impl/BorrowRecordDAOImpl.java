package by.itechart.library.dao.impl;

import by.itechart.library.bean.BorrowRecord;
import by.itechart.library.dao.api.BorrowRecordDAO;
import by.itechart.library.dao.exception.DAOException;

import java.util.List;

public class BorrowRecordDAOImpl implements BorrowRecordDAO {
    @Override
    public List<BorrowRecord> getAll() throws DAOException {
        return null;
    }

    @Override
    public void addBorrowRecord(BorrowRecord borrowRecord) throws DAOException {

    }

    @Override
    public List<BorrowRecord> getAllByReaderId(int readerId) throws DAOException {
        return null;
    }

    @Override
    public void updateBorrowRecord(BorrowRecord borrowRecord) throws DAOException {

    }
}
