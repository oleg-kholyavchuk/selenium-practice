package ru.buttonone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@Disabled
public class HomePractiseTest {


    @Test
    public void shouldHaveCorrectOpenWindowIntroduction(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");

        WebElement clickImage = driver.findElement(By.id("n-introduction"));
        clickImage.click();
        String currentUrl = driver.getCurrentUrl();

        Assertions.assertEquals("https://ru.wikipedia.org/wiki/%D0%A1%D0%BF%D1%80%D0%B0%D0%B2%D0%BA%D0%B0:%D0%92%D0%B2%D0%B5%D0%B4%D0%B5%D0%BD%D0%B8%D0%B5", currentUrl);

        driver.quit();
    }

    @Test
    public void shouldHaveCorrectTagNameKinopoisk(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.kinopoisk.ru/");
        WebElement elementName = driver.findElement(By.name("description"));

        Assertions.assertEquals("meta", elementName.getTagName());

        driver.quit();
    }

    @Test
    public void shouldHaveCorrectSwitchingToHelp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");

        driver.findElement(By.className("vector-search-box-input")).sendKeys("Справка");
        driver.findElement(By.className("vector-search-box-input")).sendKeys(Keys.RETURN);

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://ru.wikipedia.org/w/index.php?fulltext=%D0%9D%D0%B0%D0%B9%D1%82%D0%B8&search=%D0%A1%D0%BF%D1%80%D0%B0%D0%B2%D0%BA%D0%B0&title=%D0%A1%D0%BB%D1%83%D0%B6%D0%B5%D0%B1%D0%BD%D0%B0%D1%8F%3A%D0%9F%D0%BE%D0%B8%D1%81%D0%BA&ns0=1", currentUrl);

        driver.quit();
    }

    @Test
    public void shouldHaveCorrectSwitchingToDonateUsingExactTextMatch(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");
        driver.findElement(By.linkText("Пожертвовать")).click();

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://donate.wikimedia.org/w/index.php?title=Special:LandingPage&country=RU&uselang=ru&utm_medium=sidebar&utm_source=donate&utm_campaign=C13_ru.wikipedia.org", currentUrl);

        driver.quit();

    }

    @Test
    public void shouldHaveCorrectSwitchingToDonateUsingPartialTextMatch(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");
        driver.findElement(By.partialLinkText("ертвовать")).click();

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://donate.wikimedia.org/w/index.php?title=Special:LandingPage&country=RU&uselang=ru&utm_medium=sidebar&utm_source=donate&utm_campaign=C13_ru.wikipedia.org", currentUrl);

        driver.quit();
    }
}
