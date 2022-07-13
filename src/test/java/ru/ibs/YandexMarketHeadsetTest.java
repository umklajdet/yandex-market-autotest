package ru.ibs;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.ibs.basetest.BaseTestClass;

public class YandexMarketHeadsetTest extends BaseTestClass {

    @Test
    @DisplayName("Поиск наушников с использованием фильтров в Яндекс.Маркете")
    public void yandexMarketHeadsetTest() {
        pageManager.getStartPage()
                .chooseElementFromServicesMenu("Маркет")
                .chooseElementFromMarketMenu("Электроника")
                .chooseHeadsetMenuElement()
                .chooseAudioTechnicsElement("Наушники и Bluetooth-гарнитуры");
    }
}
