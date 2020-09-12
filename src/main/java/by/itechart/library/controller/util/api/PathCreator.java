package by.itechart.library.controller.util.api;

public interface PathCreator {
    public String getError();
    public String getForwardMainPage(String contextPath);
    public String getBooksPage();
    public String getBorrowRecordsPage();
    public String getUsersPage();
    public String getUserPage();
    public String getSignIn();


    public String getBookPage(String contextPath, int id);





}
