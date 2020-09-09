package by.itechart.library.entity;

public enum BookStatus {
    UNAVAILABLE(1),
    AVAILABLE(2);

    private int bookStatusId;

    BookStatus(int bookStatusId){
        this.bookStatusId = bookStatusId;
    }

    public int getBookStatusId(){
        return bookStatusId;
    }
}
