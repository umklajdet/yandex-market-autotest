package ru.ibs.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FiltersHeadsetPage extends BasePage {
    @FindBy(xpath = "//div[@class='_307sS _2k6P8']//div[@data-prefix='от']/input")
    WebElement minPriceField;

    @FindBy(xpath = "//div[@class='_307sS _2k6P8']//input[@type='checkbox' and @class='_24XUl']")
    List<WebElement> brandList;

    @FindBy(xpath = "//a[contains(text(), 'Показать') and contains(text(), 'предложений')]")
    WebElement applyFilterButton;


    @Step("Ввод цены от {minPrice} рублей")
    public FiltersHeadsetPage inputMinPrice(String minPrice) {
        minPriceField.click();
        minPriceField.sendKeys(minPrice);
        return this;
    }

    @Step("Выбор производителя {brandTitle}")
    public FiltersHeadsetPage chooseBrand(String brandTitle) {
        for (WebElement brand : brandList) {
            if (brand.getAttribute("value").equals(brandTitle)) {
                waitUntilElementToBeClickable(brand);
                brand.click();
                return this;
            }
        }
        Assert.fail("Не найден производитель " + brandTitle);
        return this;
    }

    @Step("Применение фильтра")
    public FiltersHeadsetPage applyFilter() throws InterruptedException {
        applyFilterButton.click();
        Thread.sleep(5000);
        return this;
    }
}
