package by.itechart.library.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class BorrowRecord implements Serializable {
    private static final long serialVersionUID = -7741242839891790101L;
    private int id;
    private int readerId;
    private Date borrowDate;
    private Date dueDate;
    private Date returnDate;
    private BorrowRecordStatus borrowRecordStatus;
    private String comment;
    private int bookId;


}
