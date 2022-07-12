package ru.ibs.managers;

import ru.ibs.pages.*;

public class PageManager {
    private static PageManager pageManager;

    private StartPage startPage;
    private YandexMarketPage yandexMarketPage;
    private ElectronicsPage electronicsPage;
    private TvPage tvPage;
    private FiltersTvPage filtersTvPage;
    private AudioTechnicsPage audioTechnicsPage;
    private HeadsetPage headsetPage;
    private FiltersHeadsetPage filtersHeadsetPage;


    private PageManager() {
    }

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }


    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public YandexMarketPage getYaMarketPage() {
        if (yandexMarketPage == null) {
            yandexMarketPage = new YandexMarketPage();
        }
        return yandexMarketPage;
    }

    public ElectronicsPage getElectronicsPage() {
        if (electronicsPage == null) {
            electronicsPage = new ElectronicsPage();
        }
        return electronicsPage;
    }

    public TvPage getTvPage() {
        if (tvPage == null) {
            tvPage = new TvPage();
        }
        return tvPage;
    }

    public FiltersTvPage getFiltersTvPage() {
        if (filtersTvPage == null) {
            filtersTvPage = new FiltersTvPage();
        }
        return filtersTvPage;
    }

    public AudioTechnicsPage getAudioTechnicsPage() {
        if (audioTechnicsPage == null) {
            audioTechnicsPage = new AudioTechnicsPage();
        }
        return audioTechnicsPage;
    }

    public HeadsetPage getHeadsetPage() {
        if (headsetPage == null) {
            headsetPage = new HeadsetPage();
        }
        return headsetPage;
    }

    public FiltersHeadsetPage getFiltersHeadsetPage() {
        if (filtersHeadsetPage == null) {
            filtersHeadsetPage = new FiltersHeadsetPage();
        }
        return filtersHeadsetPage;
    }
}