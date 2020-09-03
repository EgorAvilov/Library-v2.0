package by.itechart.library.bean;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class Book implements Serializable {
    private static final long serialVersionUID = 7197102530298867633L;
    private int id;
    private byte[] cover;
    private String title;
    private String authors;
    private String publisher;
    private Date publishDate;
    private String genres;
    private int pageCount;
    private int ISBN;//уникальное
    private String description;
    private int totalAmount;
    private boolean status;//пока пусть будет так сделать enum

    private boolean deletedStatus;

    private int availableAmount;
}
