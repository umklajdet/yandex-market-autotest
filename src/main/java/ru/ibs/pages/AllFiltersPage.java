package ru.ibs.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.Keys.SPACE;
import static org.openqa.selenium.Keys.TAB;

public class AllFiltersPage extends BasePage {
    @FindBy(xpath = "//div[@class='_307sS _2k6P8']//div[@data-prefix='от']/input")
    WebElement minPriceField;

    @FindBy(xpath = "//div[@class='_307sS _2k6P8']//input[@type='checkbox' and @class='_24XUl']")
    List<WebElement> brandList;

    @FindBy(xpath = "//a[starts-with(text(), 'Показать') and contains(text(), 'предложен')]")
    WebElement applyFilterButton;


    @Step("Ввод цены от {minPrice} рублей")
    public AllFiltersPage inputMinPrice(String minPrice) {
        minPriceField.click();
        minPriceField.sendKeys(minPrice);
        minPriceField.sendKeys(TAB);
        return this;
    }

    @Step("Выбор производителя {brandTitle}")
    public AllFiltersPage chooseBrand(String brandTitle) {
        for (WebElement brand : brandList) {
            if (brand.getAttribute("value").equals(brandTitle)) {
                scrollToElement(brand);
                brand.sendKeys(SPACE);
//                waitUntilElementToBeVisible(brand);
//                waitUntilElementToBeClickable(brand);
//                brand.click();
                return this;
            }
        }
        Assert.fail("Не найден производитель " + brandTitle);
        return this;
    }

    @Step("Применение фильтра")
    public FilterResultPage applyFilter() {
        applyFilterButton.click();
        return pageManager.getFilterResultPage();
    }
}
