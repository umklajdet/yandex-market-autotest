package ru.ibs.managers;

import ru.ibs.pages.*;

public class PageManager {
    private static PageManager pageManager;

    private StartPage startPage;
    private YandexMarketPage yandexMarketPage;
    private ElectronicsPage electronicsPage;
    private BaseElectronicsTypePage baseElectronicsTypePage;
    private AllFiltersPage allFiltersPage;
    private AudioTechnicsPage audioTechnicsPage;
    private FilterResultPage filterResultPage;
    private SearchResultPage searchResultPage;


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

    public BaseElectronicsTypePage getBaseElectronicsTypePage() {
        if (baseElectronicsTypePage == null) {
            baseElectronicsTypePage = new BaseElectronicsTypePage();
        }
        return baseElectronicsTypePage;
    }

    public AllFiltersPage getAllFiltersPage() {
        if (allFiltersPage == null) {
            allFiltersPage = new AllFiltersPage();
        }
        return allFiltersPage;
    }

    public AudioTechnicsPage getAudioTechnicsPage() {
        if (audioTechnicsPage == null) {
            audioTechnicsPage = new AudioTechnicsPage();
        }
        return audioTechnicsPage;
    }

    public FilterResultPage getFilterResultPage() {
        if (filterResultPage == null) {
            filterResultPage = new FilterResultPage();
        }
        return filterResultPage;
    }

    public SearchResultPage getSearchResultPage() {
        if (searchResultPage == null) {
            searchResultPage = new SearchResultPage();
        }
        return searchResultPage;
    }
}