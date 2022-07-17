package ru.ibs.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FilterResultPage extends BasePage {

    @FindBy(xpath = "//div[@class='_3Fff3']/h3/a/span[@data-tid='2e5bde87']")
    List<WebElement> filteredList;

    @FindBy(id = "header-search")
    WebElement searchInput;

    @FindBy(xpath = "//button[@class='_1Dyrh _1NDr9 _3MZAj V9ceN wQgEg _1Himk sQ_gr _2YKh4 _3O-ed G12sD _9Lboa _3ofRm _1XiEJ mini-suggest__button']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class='_3Fff3']/h3/a")
    List<WebElement> elementsTitleList;

    @FindBy(xpath = "//div[@class='_3mStq _2y-pc']")
    WebElement messageViewedElementsNumber;

    String firstElementTitle;


    @Step("Проверяем количество элементов на странице")
    public FilterResultPage countFilteredElementsNumber() throws InterruptedException {
//        for (WebElement listItem : filteredList) {
//            waitUntilElementToBeVisible(listItem);
//            scrollToElement(listItem);
//        }
        for (int i = 0; i<2; i++) {
            Thread.sleep(1000);
            scrollPage();
        }
        Assert.assertTrue("Количество найденных товаров не сотвествует количеству отображенных",
                messageViewedElementsNumber.getText().contains("Вы посмотрели " + filteredList.size()));
        return this;
    }

    @Step("Получаем название первого товара в отфильрованном списке")
    public FilterResultPage getFirstElement() throws InterruptedException {
        Thread.sleep(5000);
        firstElementTitle = filteredList.get(0).getText();
        return this;
    }

    @Step("Вводим в поисковую строку название первого элемента")
    public FilterResultPage searchFirstElement() {
        searchInput.sendKeys(firstElementTitle);
        searchButton.click();
        return this;
    }

    @Step("Проверяем найденный товар")
    public SearchResultPage checkFirstElement() throws InterruptedException {
        Thread.sleep(5000);
        elementsTitleList.get(0).click();
        switchTab();
        return pageManager.getSearchResultPage();
    }
}