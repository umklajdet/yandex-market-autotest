package ru.ibs.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FiltersTvPage extends BasePage {
    @FindBy(xpath = "//div[@class='_307sS _2k6P8']//div[@data-prefix='от']/input")
    WebElement minPriceField;

    @FindBy(xpath = "//h4[text()='Производитель']/../..//input[@type='checkbox']")
    List<WebElement> brandList;

    @FindBy(xpath = "//a[contains(text(), 'Показать')]")
    WebElement applyFilterButton;

    @FindBy(xpath = "//div[@data-tid='5c8f99e1']/article")
    List<WebElement> filteredTvList;

    @Step("Ввод цены от {minPrice} рублей")
    public FiltersTvPage inputMinPrice(String minPrice) {
        minPriceField.click();
        minPriceField.sendKeys(minPrice);
        return this;
    }

    @Step("Выбор производителя {brandTitle}")
    public FiltersTvPage chooseBrand(String brandTitle) {
        for (WebElement brand : brandList) {
            if (brand.getAttribute("value").equals(brandTitle)) {
                brand.click();
                return this;
            }
        }
        Assert.fail("Не найден производитель " + brandTitle);
        return this;
    }

    @Step("Применение фильтра")
    public FiltersTvPage applyFilter() throws InterruptedException {
        applyFilterButton.click();
        Thread.sleep(5000);
        return this;
    }

    @Step("Проверяем кооличество элементов на странице")
    public FiltersTvPage checkShownElementsNumber() {

        return this;
    }
}
