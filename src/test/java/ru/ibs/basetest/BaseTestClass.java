package ru.ibs.basetest;

import org.junit.After;
import org.junit.Before;
import ru.ibs.managers.DriverManager;
import ru.ibs.managers.PageManager;
import ru.ibs.managers.PropManager;

public class BaseTestClass {

    public static DriverManager driverManager = DriverManager.getInstance();
    protected PageManager pageManager = PageManager.getPageManager();
    public PropManager propManager = PropManager.getInstance();

    @Before
    public void beforeEach() {
        driverManager.getDriver().get(propManager.getProperty("base.url"));
    }

    @After
    public void after() {
        driverManager.quitDriver();
    }

}
