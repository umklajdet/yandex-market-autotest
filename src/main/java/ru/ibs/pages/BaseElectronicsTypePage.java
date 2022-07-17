package ru.ibs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaseElectronicsTypePage extends BasePage {

    @FindBy(xpath = "//button/span/span[text()='Все фильтры']")
    WebElement allFiltersButton;

    public AllFiltersPage getAllFilters() {
        allFiltersButton.click();
        return pageManager.getAllFiltersPage();
    }
}
