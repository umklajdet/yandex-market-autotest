package ru.ibs.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AudioTechnicsPage extends BasePage {

    @FindBy(xpath = "//div[@class='_3Nlow _3Ct1C']")
    private List<WebElement> categoryList;

    @Step("Выбираем категорию {categoryTitle}")
    public HeadsetPage chooseAudioTechnicsElement(String categoryTitle) {
        for (WebElement category : categoryList) {
            if (category.getText().contains(categoryTitle)) {
                waitUntilElementToBeClickable(category);
                category.click();
                return pageManager.getHeadsetPage();
            }
        }
        Assert.fail("Не найдена категория " + categoryTitle);
        return pageManager.getHeadsetPage();
    }
}
