package ru.ibs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//h1[@class='_1BWd_ _2OAAC undefined']")
    WebElement foundTitle;

    String expectedTitle = pageManager.getFilterResultPage().firstElementTitle;


    public void checkFoundTitle() {
        assertEquals("Название не соответствует ожидаемому",
                expectedTitle,
                foundTitle.getText());
    }
}
