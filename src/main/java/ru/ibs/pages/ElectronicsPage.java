package ru.ibs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ElectronicsPage extends BasePage{

    @FindBy(xpath = "//ul[@data-autotest-id]/li/div/a[text()='Телевизоры']")
    private WebElement tvMenuElement;

    @FindBy(xpath = "//ul[@data-autotest-id]/li/div/a[text()='Телевизоры']")
    private WebElement headsetMenuElement;

    public TvPage chooseTvMenuElement(){
        tvMenuElement.click();
        return pageManager.getTvPage();
    }

    public HeadsetPage chooseHeadsetMenuElement(){
        headsetMenuElement.click();
        return pageManager.getHeadsetPage();
    }
}
