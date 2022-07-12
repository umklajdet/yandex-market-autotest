package ru.ibs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.managers.DriverManager;
import ru.ibs.managers.PageManager;

public class BasePage {
    protected DriverManager driverManager = DriverManager.getInstance();
    protected Wait<WebDriver> wait = new WebDriverWait(driverManager.getDriver(), 5, 1000);
    protected PageManager pageManager = PageManager.getPageManager();

    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    protected WebElement waitUntilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitUtilElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
