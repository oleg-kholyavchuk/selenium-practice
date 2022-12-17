package ru.buttonone.xpath;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import ru.buttonone.BaseTest;
import ru.buttonone.page_task.KinopoiskGameOfThronesPage;
import ru.buttonone.page_task.KinopoiskPage;


public class XpathSelectorKinopoiskTest extends BaseTest {

    @DisplayName("Transition By Click Link Vk Image and correct transition  the on page VK")
    @Test
    public void correctTransitionByClickLinkVkPage() {
        KinopoiskPage kinopoiskPage = new KinopoiskPage(driver, "//img[@alt='https://vk.com/kinopoisk']");
        kinopoiskPage.clickKinopoiskPage();
        Assertions.assertEquals("https://vk.com/kinopoisk", kinopoiskPage.currentUrlWebDriver());
    }

    @DisplayName("Transition By Click Link YouTube Image and correct transition  the on page YouTube")
    @Test
    public void  correctTransitionByClickLinkYouTubePage() throws InterruptedException {
        KinopoiskPage kinopoiskPage = new KinopoiskPage(driver, "//img[@alt='https://www.youtube.com/user/kinopoisk']");
        kinopoiskPage.clickKinopoiskPage();
        Thread.sleep(3000);
        Assertions.assertEquals("https://www.youtube.com/user/kinopoisk", kinopoiskPage.currentUrlWebDriver());
    }

    @DisplayName("Transition the on page  Game Of Thrones on request  in the Search Box Query")
    @Test
    public void correctTransitionPageGameOfThronesOnRequestInSearchBoxQuery() throws InterruptedException {
        KinopoiskPage kinopoiskPage = new KinopoiskPage(driver, "//input[@name='kp_query']");
        Thread.sleep(5000);
        kinopoiskPage.searchByPhraseAndClickEnter("Игра престолов (сериал) 2011 – 2019");
        Thread.sleep(5000);
        KinopoiskGameOfThronesPage kinopoiskGameOfThronesPage = new KinopoiskGameOfThronesPage(driver);
        WebElement titleGameOfThrones = kinopoiskGameOfThronesPage.getTitleGameOfThrones();
        Assertions.assertEquals("Игра престолов", titleGameOfThrones.getText());
    }

    @DisplayName("Transition By Click Link TryPlus and correct transition  the on page TryPlus")
    @Test
    public void correctTransitionByClickLinkTryPlusPage() throws InterruptedException {
        KinopoiskPage kinopoiskPage = new KinopoiskPage(driver, "//a[text()='Попробовать Плюс']");
        kinopoiskPage.clickKinopoiskPage();
        Thread.sleep(3000);
        Assertions.assertEquals("https://hd.kinopoisk.ru/?source=kinopoisk_head_button", kinopoiskPage.currentUrlWebElement());
    }

    @DisplayName("Transition By Click Link JobOpenings and correct transition  the on page JobOpenings")
    @Test
    public void correctTransitionByClickLinkJobOpeningsPage() throws InterruptedException {
        KinopoiskPage kinopoiskPage = new KinopoiskPage(driver, "//a[text()='Вакансии']");
        kinopoiskPage.clickKinopoiskPage();
        Thread.sleep(3000);
        Assertions.assertEquals(
                "https://yandex.ru/jobs/vacancies?services=kinopoisk", kinopoiskPage.currentUrlWebDriver());
    }
}
