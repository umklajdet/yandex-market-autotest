package ru.ibs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeadsetPage extends BasePage {

    @FindBy(xpath = "//button/span/span[text()='Все фильтры']")
    WebElement allFiltersButton;

    public FiltersHeadsetPage getAllFilters() {
        allFiltersButton.click();
        return pageManager.getFiltersHeadsetPage();
    }
}
