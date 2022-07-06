package ru.ibs.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YandexMarketPage extends BasePage {

//    @FindBy(xpath = "//div[@class = '_35SYu _1vnug']/a/span")
    @FindBy(xpath = "//span[@class='_3z8Gf']")
    private List<WebElement> marketMenu;

    @FindBy(xpath = "//div/button[@data-tid='6ce03884']")
    private WebElement closeBannerButton;

//    public YandexMarketPage closeBanner(){
//        closeBannerButton.click();
//        return this;
//    }

    public ElectronicsPage chooseElementFromMarketMenu(String menuElementTitle) {
        for (WebElement element : marketMenu) {
            if (element.getText().contains(menuElementTitle)) {
                element.click();
                return pageManager.getElectronicsPage();
            }
        }
        Assert.fail("Не найден пункт " + menuElementTitle);
        return pageManager.getElectronicsPage();
    }
}
