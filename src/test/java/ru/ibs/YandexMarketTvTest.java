package ru.ibs;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.ibs.basetest.BaseTestClass;

public class YandexMarketTvTest extends BaseTestClass {

    @Test
    @DisplayName("Поиск телевизоров с использованием фильтров в Яндекс.Маркете")
    public void yandexMarketTvTest() throws InterruptedException {

        pageManager.getStartPage()
                .chooseElementFromServicesMenu("Маркет")
//                .closeBanner()
                .chooseElementFromMarketMenu("Электроника")
                .chooseTvMenuElement()
                .getAllFilters()
                .inputMinPrice("20000")
                .chooseBrand("Samsung")
                .chooseBrand("LG")
                .applyFilter()
                .checkShownElementsNumber();
    }
}
