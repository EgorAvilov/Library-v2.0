package by.itechart.library.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
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
