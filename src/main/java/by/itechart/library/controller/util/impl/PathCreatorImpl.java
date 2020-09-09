package by.itechart.library.controller.util.impl;

import by.itechart.library.controller.util.api.PathCreator;


public class PathCreatorImpl implements PathCreator {

    private final static String FORWARD_TO_MAIN = "/controller?command=forward-to-main";
    private final static String GET_ALL_TRAININGS = "/controller?command=get-all-books";
    private final static String GET_ALL_BORROW_RECORDS = "/controller?command=get-all-borrow-records";
    private final static String GET_ALL_USERS = "/controller?command=get-all-users";
    @Override
    public String getError() {
        return null;
    }

    @Override
    public String getForwardMainPage(String contextPath) {
        return contextPath + FORWARD_TO_MAIN;
    }

    @Override
    public String getBooksPage() {
        return GET_ALL_TRAININGS;
    }

    @Override
    public String getBorrowRecordsPage() {
        return GET_ALL_BORROW_RECORDS;
    }

    @Override
    public String getUsersPage() {
        return GET_ALL_USERS;
    }
}
