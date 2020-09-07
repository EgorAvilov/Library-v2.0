package by.itechart.library.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SQLRequest {
    /**
     * запросы для таблицы Book
     */
    public static final String GET_BOOK_BY_ID = "SELECT * FROM books WHERE id = ?"; //написать сам запрос
    public static final String GET_ALL_BOOKS = "SELECT * FROM books";
    public static final String CREATE_BOOK = "INSERT INTO books (cover, title, authors, publisher, publish_date, genres, page_count, isbn, description, total_amount, available_amount ) values(?,?,?,?,?,?,?,?,?,?,?)";//дописать
    public static final String UPDATE_BOOK = "UPDATE books SET cover=?, title=?, authors=?, publisher=?, publish_date=?,genres=?, page_count=?, isbn=?, description=?, total_amount=? available_amount=? WHERE id=?";//ДОПИСАТЬ
    public static final String CHANGE_BOOK_DELETED_STATUS = "UPDATE books SET deleted_status=? WHERE id=?";
    /**
     * запросы для таблицы Borrow Record
     */
    public static final String GET_BORROW_RECORDS_BY_READER_ID = "SELECT * FROM borrow_records WHERE reader_id = ?"; //написать сам запрос
    public static final String GET_ALL_BORROW_RECORDS = "SELECT * FROM borrow_records";
    public static final String CREATE_BORROW_RECORD = "INSERT INTO borrow_record (reader_id, borrow_date, due_date,  book_id ) values(?,?,?,?)";//дописать
    public static final String UPDATE_BORROW_RECORD = "UPDATE borrow_records SET return_date=?, status_id=?, comment=? WHERE id=?";//ДОПИСАТЬ

    /**
     * запросы для таблицы Users
     */
    public static final String GET_USER_BY_ID = "SELECT * FROM users WHERE id=?";
    public static final String CREATE_USER = "INSERT INTO users (first_name, email, date_of_registration, phone_number, last_name,gender_id, username, password ) values(?,?,?,?,?,?,?,?)";//дописать
    public static final String UPDATE_USER = "UPDATE users SET first_name=?, email=?, phone_number=?, last_name=?, gender_id=?, password=? WHERE id=?";//ДОПИСАТЬ
    public static final String GET_ALL_USERS = "SELECT * FROM users";
    public static final String CHANGE_USER_DELETED_STATUS = "UPDATE users SET deleted_status=? WHERE id=?";
    public static final String GET_USER_BY_CREDENTIALS = "SELECT * FROM users WHERE username=? AND password=?";

}
