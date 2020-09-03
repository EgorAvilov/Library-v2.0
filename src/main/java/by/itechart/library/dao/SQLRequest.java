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


    public static final String GET_BORROW_RECORDS_BY_READER_ID = "SELECT * FROM borrow_records WHERE reader_id = ?"; //написать сам запрос


    public static final String GET_READER_BY_ID = "SELECT * FROM readers WHERE id=?";

}
