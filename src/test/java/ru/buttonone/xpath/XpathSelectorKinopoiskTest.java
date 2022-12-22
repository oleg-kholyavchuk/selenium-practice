package ru.buttonone.xpath;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import ru.buttonone.BaseTest;
import ru.buttonone.page_task.KinopoiskGameOfThronesPage;
import ru.buttonone.page_task.KinopoiskPage;


import static ru.buttonone.constant.AssertionsExpected.*;
import static ru.buttonone.constant.Locators.*;


public class XpathSelectorKinopoiskTest extends BaseTest {

    @SneakyThrows
    @DisplayName("Transition By Click Link Vk Image and correct transition  the on page VK")
    @Test
    public void correctTransitionByClickLinkVkPage() {
        KinopoiskPage kinopoiskPage = new KinopoiskPage(driver);
        Thread.sleep(3000);
        kinopoiskPage.clickKinopoiskPage(IMG_VK_COM_KINOPOISK);
        Thread.sleep(3000);
        Assertions.assertEquals(VK_COM_KINOPOISK, kinopoiskPage.currentUrlWebDriver());
    }

    @DisplayName("Transition By Click Link YouTube Image and correct transition  the on page YouTube")
    @Test
    public void  correctTransitionByClickLinkYouTubePage() {
        KinopoiskPage kinopoiskPage = new KinopoiskPage(driver);
        kinopoiskPage.clickKinopoiskPage(IMG_YOUTUBE_USER_KINOPOISK);
        Assertions.assertEquals(YOUTUBE_COM_USER_KINOPOISK, kinopoiskPage.currentUrlWebDriver());
    }

    @DisplayName("Transition the on page  Game Of Thrones on request  in the Search Box Query")
    @Test
    public void correctTransitionPageGameOfThronesOnRequestInSearchBoxQuery() {
        KinopoiskPage kinopoiskPage = new KinopoiskPage(driver);
        kinopoiskPage.searchByPhraseAndClickEnter("Игра престолов (сериал) 2011 – 2019");
        KinopoiskGameOfThronesPage kinopoiskGameOfThronesPage = new KinopoiskGameOfThronesPage(driver);
        WebElement titleGameOfThrones = kinopoiskGameOfThronesPage.getTitleGameOfThrones();
        Assertions.assertEquals(GAME_OF_THRONES_TEXT, titleGameOfThrones.getText());
    }

    @DisplayName("Transition By Click Link TryPlus and correct transition  the on page TryPlus")
    @Test
    public void correctTransitionByClickLinkTryPlusPage() {
        KinopoiskPage kinopoiskPage = new KinopoiskPage(driver);
        kinopoiskPage.clickKinopoiskPage(KINOPOISK_HEAD_BUTTON);
        Assertions.assertEquals(KINOPOISK_RU_SOURCE_KINOPOISK_HEAD_BUTTON, kinopoiskPage.currentUrlWebElement());
    }

    @DisplayName("Transition By Click Link JobOpenings and correct transition  the on page JobOpenings")
    @Test
    public void correctTransitionByClickLinkJobOpeningsPage() {
        KinopoiskPage kinopoiskPage = new KinopoiskPage(driver);
        kinopoiskPage.clickKinopoiskPage(JOBS_VACANCIES_SERVICES_KINOPOISK);
        Assertions.assertEquals(
                YANDEX_RU_JOBS__KINOPOISK, kinopoiskPage.currentUrlWebDriver());
    }
}
