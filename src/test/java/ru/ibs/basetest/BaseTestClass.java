package ru.ibs.basetest;

import org.junit.AfterClass;
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

    @AfterClass
    public static void afterAll() {
        driverManager.quitDriver();
    }

}
