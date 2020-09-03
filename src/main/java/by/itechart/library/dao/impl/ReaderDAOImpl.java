package by.itechart.library.dao.impl;

import by.itechart.library.bean.Reader;
import by.itechart.library.dao.api.ReaderDAO;
import by.itechart.library.dao.exception.DAOException;

import java.util.List;

public class ReaderDAOImpl implements ReaderDAO {
    @Override
    public void addReader(Reader reader) throws DAOException {

    }

    @Override
    public Reader getReader(int id) throws DAOException {
        return null;
    }

    @Override
    public void updateReader(Reader reader) throws DAOException {

    }

    @Override
    public List<Reader> getAllReaders() throws DAOException {
        return null;
    }

    @Override
    public int changeDeletedStatus(int readerId) throws DAOException {
        return 0;
    }
}
