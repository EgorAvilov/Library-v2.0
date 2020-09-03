package by.itechart.library.dao;

import by.itechart.library.dao.api.BookDAO;
import by.itechart.library.dao.api.BorrowRecordDAO;
import by.itechart.library.dao.api.ReaderDAO;
import by.itechart.library.dao.impl.BookDAOImpl;
import by.itechart.library.dao.impl.BorrowRecordDAOImpl;
import by.itechart.library.dao.impl.ReaderDAOImpl;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DAOFactory {

    @Getter
    private static final DAOFactory INSTANCE = new DAOFactory();
    @Getter
    private BookDAO bookDAO = new BookDAOImpl();
    @Getter
    private ReaderDAO readerDAO = new ReaderDAOImpl();
    @Getter
    private BorrowRecordDAO borrowRecordDAO = new BorrowRecordDAOImpl();





}
