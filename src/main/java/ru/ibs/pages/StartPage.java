package ru.ibs.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class StartPage extends BasePage {
    @FindBy(xpath = "//div[contains(@class, 'services-new__item-title')]")
    private List<WebElement> servicesMenu;

    @Step("Выбор пункта {menuElementTitle} из главного меню")
    public YandexMarketPage chooseElementFromServicesMenu(String menuElementTitle) {
        for (WebElement element : servicesMenu) {
            if (element.getText().contains(menuElementTitle)) {
                element.click();
                switchTab();
                return pageManager.getYaMarketPage();
            }
        }
        Assert.fail("Не найден пункт " + menuElementTitle);
        return pageManager.getYaMarketPage();
    }

    // переключает на другую вкладку
    public void switchTab() {
        ArrayList<String> tabs2 = new ArrayList<String>(driverManager.getDriver().getWindowHandles());
        driverManager.getDriver().switchTo().window(tabs2.get(1));
    }
}
