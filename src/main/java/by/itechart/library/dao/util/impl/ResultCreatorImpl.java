package by.itechart.library.dao.util.impl;

import by.itechart.library.dao.util.ColumnName;
import by.itechart.library.dao.util.api.ResultCreator;
import by.itechart.library.entity.Book;
import by.itechart.library.entity.BorrowRecord;
import by.itechart.library.entity.User;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultCreatorImpl implements ResultCreator {
    @Override
    public Book getNextBook(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt(ColumnName.BOOK_ID);
        byte[] cover = resultSet.getBytes(ColumnName.BOOK_COVER);
        String title = resultSet.getNString(ColumnName.BOOK_TITLE);
        String authors = resultSet.getNString(ColumnName.BOOK_AUTHORS);
        String publisher = resultSet.getNString(ColumnName.BOOK_PUBLISHER);
        Date publishDate = resultSet.getDate(ColumnName.BOOK_PUBLISH_DATE);
        String genres = resultSet.getNString(ColumnName.BOOK_GENRES);
        int pageCount = resultSet.getInt(ColumnName.BOOK_PAGE_COUNT);
        int ISBN = resultSet.getInt(ColumnName.BOOK_ISBN);
        String description = resultSet.getNString(ColumnName.BOOK_DESCRIPTION);
        int totalAmount = resultSet.getInt(ColumnName.BOOK_TOTAL_AMOUNT);
        boolean status = resultSet.getBoolean(ColumnName.BOOK_STATUS);///
        boolean deletedStatus = resultSet.getBoolean(ColumnName.BOOK_DELETED_STATUS);
        int availableAmount = resultSet.getInt(ColumnName.BOOK_AVAILABLE_AMOUNT);

        Book book = new Book();

        book.setId(id);
        book.setCover(cover);
        book.setTitle(title);
        book.setAuthors(authors);
        book.setPublisher(publisher);
        book.setPublishDate(publishDate);
        book.setGenres(genres);
        book.setPageCount(pageCount);
        book.setISBN(ISBN);
        book.setDescription(description);
        book.setTotalAmount(totalAmount);
        book.setStatus(status);///
        book.setDeletedStatus(deletedStatus);
        book.setAvailableAmount(availableAmount);

        return book;
    }

    @Override
    public BorrowRecord getNextBorrowRecord(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt(ColumnName.BORROW_RECORD_BOOK_ID);
        int userId = resultSet.getInt(ColumnName.BORROW_RECORD_USER_ID);
        Date borrowDate = resultSet.getDate(ColumnName.BOOK_PUBLISH_DATE);
        Date dueDate = resultSet.getDate(ColumnName.BOOK_PUBLISH_DATE);
        Date returnDate = resultSet.getDate(ColumnName.BOOK_PUBLISH_DATE);
        int statusId = resultSet.getInt(ColumnName.BORROW_RECORD_STATUS_ID);
        String comment = resultSet.getNString(ColumnName.BORROW_RECORD_COMMENT);
        int bookId = resultSet.getInt(ColumnName.BORROW_RECORD_BOOK_ID);

        BorrowRecord borrowRecord = new BorrowRecord();

        borrowRecord.setId(id);
        borrowRecord.setBorrowDate(borrowDate);
        borrowRecord.setDueDate(dueDate);
        borrowRecord.setReturnDate(returnDate);
        borrowRecord.setStatusId(statusId);
        borrowRecord.setComment(comment);
        borrowRecord.setBookId(bookId);

        return borrowRecord;
    }

    @Override
    public User getNextUser(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt(ColumnName.USER_ID);
        String firstName = resultSet.getNString(ColumnName.USER_FIRST_NAME);
        String lastName = resultSet.getNString(ColumnName.USER_LAST_NAME);
        int genderId = resultSet.getInt(ColumnName.USER_GENDER_ID);
        String email = resultSet.getNString(ColumnName.USER_EMAIL);
        Date dateOfRegistration = resultSet.getDate(ColumnName.USER_DATE_OF_REGISTRATION);
        String phoneNumber = resultSet.getNString(ColumnName.USER_PHONE_NUMBER);
        String username = resultSet.getNString(ColumnName.USER_USERNAME);
        String password = resultSet.getNString(ColumnName.USER_PASSWORD);
        int roleId = resultSet.getInt(ColumnName.USER_ROLE_ID);
        boolean deletedStatus = resultSet.getBoolean(ColumnName.USER_DELETED_STATUS);

        User user = new User();

        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setGenderId(genderId);
        user.setEmail(email);
        user.setDateOfRegistration(dateOfRegistration);
        user.setPhoneNumber(phoneNumber);
        user.setUsername(username);
        user.setPassword(password);
        user.setRoleId(roleId);
        user.setDeletedStatus(deletedStatus);

        return user;
    }
}
