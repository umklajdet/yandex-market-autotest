package ru.ibs.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AudioTechnicsPage extends BasePage {

    @FindBy(xpath = "//div[@class='_2jsCq _1qPMc']")
    private List<WebElement> categoryList;

    @Step("Выбираем категорию {categoryTitle}")
    public BaseElectronicsTypePage chooseAudioTechnicsElement(String categoryTitle) {
        for (WebElement category : categoryList) {
            WebElement listItemChild = category.findElement(By.xpath("//div[@class='_3Nlow _3Ct1C']"));
            if (listItemChild.getText().contains(categoryTitle)) {
                waitUntilElementToBeClickable(category);
                category.click();
                return pageManager.getBaseElectronicsTypePage();
            }
        }
        Assert.fail("Не найдена категория " + categoryTitle);
        return pageManager.getBaseElectronicsTypePage();
    }
}
