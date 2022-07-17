package ru.ibs.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.*;

public class FilterResultPage extends BasePage {

//    @FindBy(xpath = "//div[@data-tid='5c8f99e1']/article")
//    List<WebElement> filteredTvList;

    @FindBy(xpath = "//div[@class='_3Fff3']/h3/a/span[@data-tid='2e5bde87']")
    List<WebElement> filteredList;

    @FindBy(id = "header-search")
    WebElement searchInput;

    @FindBy(xpath = "//button[@class='_1Dyrh _1NDr9 _3MZAj V9ceN wQgEg _1Himk sQ_gr _2YKh4 _3O-ed G12sD _9Lboa _3ofRm _1XiEJ mini-suggest__button']")
    WebElement searchButton;

    String firstElementTitle;


    @Step("Проверяем количество элементов на странице")
    public FilterResultPage countFilteredElementsNumber() {
        for (WebElement listIssue : filteredList) {
            waitUntilElementToBeVisible(listIssue);
            scrollToElement(listIssue);
        }
        System.out.println("Количество офильтрованных товаров - " + filteredList.size());
        return this;
    }

    @Step("Получаем название первого товара в отфильрованном списке")
    public FilterResultPage getFirstElement() {
        firstElementTitle = filteredList.get(0).getText();
        return this;
    }

    @Step("Вводим в поисковую строку название первого элемента")
    public FilterResultPage searchFirstElement() {
        searchInput.sendKeys(firstElementTitle);
        searchInput.click();
        return this;
    }

    @Step("Проверяем найденный товар")
    public void checkFirstElement() {
        assertEquals("Название найденного элемента не соответствует искомому",
                firstElementTitle,
                filteredList.get(0).getText());
    }
}
