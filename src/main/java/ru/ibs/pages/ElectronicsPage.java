package ru.ibs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElectronicsPage extends BasePage {

    @FindBy(xpath = "//ul[@data-autotest-id]/li/div/a[text()='Телевизоры']")
    private WebElement tvMenuElement;

    @FindBy(xpath = "//a[text()='Наушники  и аудиотехника']")
    private WebElement audioMenuElement;

    public BaseElectronicsTypePage chooseTvMenuElement() {
        tvMenuElement.click();
        return pageManager.getBaseElectronicsTypePage();
    }

    public AudioTechnicsPage chooseHeadsetMenuElement() {
        audioMenuElement.click();
        return pageManager.getAudioTechnicsPage();
    }
}
