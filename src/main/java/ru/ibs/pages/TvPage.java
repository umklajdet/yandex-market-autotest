package ru.ibs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TvPage extends BasePage {
    @FindBy(xpath = "//button/span/span[text()='Все фильтры']")
    WebElement allFiltersButton;

    public FiltersTvPage getAllFilters() {
        allFiltersButton.click();
        return pageManager.getFiltersTvPage();
    }
}
