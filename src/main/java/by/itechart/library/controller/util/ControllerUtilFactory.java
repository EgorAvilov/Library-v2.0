package by.itechart.library.controller.util;

import by.itechart.library.controller.util.api.PathCreator;
import by.itechart.library.controller.util.impl.PathCreatorImpl;
import lombok.Getter;

public class ControllerUtilFactory {
    @Getter
    private final static ControllerUtilFactory INSTANCE = new ControllerUtilFactory();

    @Getter
    private PathCreator pathCreator = new PathCreatorImpl();



}
