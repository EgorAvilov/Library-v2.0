package by.itechart.library.dao;

import by.itechart.library.dao.api.BookDAO;
import by.itechart.library.dao.api.BorrowRecordDAO;
import by.itechart.library.dao.api.UserDAO;
import by.itechart.library.dao.impl.BookDAOImpl;
import by.itechart.library.dao.impl.BorrowRecordDAOImpl;
import by.itechart.library.dao.impl.UserDAOImpl;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DAOFactory {

    @Getter
    private static final DAOFactory Instance = new DAOFactory();
    @Getter
    private BookDAO bookDAO = new BookDAOImpl();
    @Getter
    private UserDAO userDAO = new UserDAOImpl();
    @Getter
    private BorrowRecordDAO borrowRecordDAO = new BorrowRecordDAOImpl();





}
