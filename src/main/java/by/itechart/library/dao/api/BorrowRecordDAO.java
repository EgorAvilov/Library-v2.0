package by.itechart.library.dao.api;

import by.itechart.library.entity.BorrowRecord;
import by.itechart.library.dao.exception.DAOException;

import java.util.List;

public interface BorrowRecordDAO {

    public List<BorrowRecord> getAll() throws DAOException;

    public void addBorrowRecord(BorrowRecord borrowRecord) throws DAOException;

    public List<BorrowRecord> getAllByUserId(int readerId) throws DAOException;

    public void updateBorrowRecord(BorrowRecord borrowRecord) throws DAOException;






}
