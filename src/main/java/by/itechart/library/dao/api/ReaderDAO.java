package by.itechart.library.dao.api;

import by.itechart.library.bean.Reader;
import by.itechart.library.dao.exception.DAOException;

import java.util.List;
import java.util.zip.DataFormatException;

public interface ReaderDAO {

    public void addReader(Reader reader) throws DAOException;

    public Reader getReader(int id) throws DAOException;

    public void updateReader(Reader reader)throws DAOException;

    public List<Reader> getAllReaders() throws DAOException;

    public int changeDeletedStatus(int readerId) throws DAOException;
}
