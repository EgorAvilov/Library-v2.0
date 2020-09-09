package by.itechart.library.controller.util;

import by.itechart.library.controller.util.api.AttributesInitializer;
import by.itechart.library.controller.util.api.HttpRequestResponseKeeper;
import by.itechart.library.controller.util.api.PaginationCurrentPage;
import by.itechart.library.controller.util.api.PathCreator;
import by.itechart.library.controller.util.impl.AttributesInitializerImpl;
import by.itechart.library.controller.util.impl.HttpRequestResponseKeeperImpl;
import by.itechart.library.controller.util.impl.PaginationCurrentPageImpl;
import by.itechart.library.controller.util.impl.PathCreatorImpl;
import lombok.Getter;

public class ControllerUtilFactory {
    @Getter
    private final static ControllerUtilFactory Instance = new ControllerUtilFactory();

    @Getter
    private PathCreator pathCreator = new PathCreatorImpl();
    @Getter
    private AttributesInitializer attributesInitializer = new AttributesInitializerImpl();
    @Getter
    private HttpRequestResponseKeeper httpRequestResponseKeeper = new HttpRequestResponseKeeperImpl();
    @Getter
    private PaginationCurrentPage paginationCurrentPage = new PaginationCurrentPageImpl();
}
