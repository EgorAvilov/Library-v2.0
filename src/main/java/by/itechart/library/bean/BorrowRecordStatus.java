package by.itechart.library.bean;

public enum BorrowRecordStatus {
    RETURNED(1),
    RETURNED_AND_DAMAGED(2),
    LOST(3);

    private int borrowRecordStatusId;

    BorrowRecordStatus(int borrowRecordStatusId){
        this.borrowRecordStatusId = borrowRecordStatusId;
    }

    public int getBorrowRecordStatusIds(){
        return borrowRecordStatusId;
    }
}
