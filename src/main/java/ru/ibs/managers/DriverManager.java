package ru.ibs.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private WebDriver driver;
    private static DriverManager INSTANCE;
    private final PropManager propManager = PropManager.getInstance();

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    private void initDriver() {
        System.setProperty("webdriver.chrome.driver", propManager.getProperty("path.chrome.driver.windows"));
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(propManager.getProperty("implicitly.wait")), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(propManager.getProperty("page.load.timeout")), TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}