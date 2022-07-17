package ru.ibs.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.managers.DriverManager;
import ru.ibs.managers.PageManager;

import java.util.ArrayList;

public class BasePage {
    protected DriverManager driverManager = DriverManager.getInstance();
    protected Wait<WebDriver> wait = new WebDriverWait(driverManager.getDriver(), 5, 1000);
    protected PageManager pageManager = PageManager.getPageManager();
    protected JavascriptExecutor jse = (JavascriptExecutor) driverManager.getDriver();


    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    protected WebElement waitUntilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitUntilElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement scrollToElement(WebElement element) {
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    // переключает на другую вкладку
    public void switchTab() {
        ArrayList<String> tabs = new ArrayList<String>(driverManager.getDriver().getWindowHandles());
        driverManager.getDriver().switchTo().window(tabs.get(tabs.size()-1));
    }
}
