package ru.buttonone.xpath;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class XpathSelectorKinopoiskTest {

    @Test
    public void correctTransitionByClickLinkVkImage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.kinopoisk.ru/");

        WebElement element = driver.findElement(By.xpath("//img[@alt='https://vk.com/kinopoisk']"));
        element.click();

        WebDriver window = driver.switchTo().window((new ArrayList<String>(driver.getWindowHandles())).get(1));
        String currentUrl = window.getCurrentUrl();
        Assertions.assertEquals("https://vk.com/kinopoisk", currentUrl);
        driver.quit();
    }

    @Test
    public void  correctTransitionByClickLinkYouTube() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.kinopoisk.ru/");

        WebElement element = driver.findElement(By.xpath("//img[@alt='https://www.youtube.com/user/kinopoisk']"));
        element.click();

        Thread.sleep(10000);
        WebDriver window = driver.switchTo().window((new ArrayList<String>(driver.getWindowHandles())).get(1));
        String currentUrl = window.getCurrentUrl();
        Assertions.assertEquals("https://www.youtube.com/user/kinopoisk", currentUrl);
        driver.quit();
    }

    @Test
    public void correctTransitionSearchBoxQueryGameOfThrones() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.kinopoisk.ru/");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@name='kp_query']")).sendKeys("Игра престолов (сериал) 2011 – 2019");
        driver.findElement(By.xpath("//input[@name='kp_query']")).sendKeys(Keys.RETURN);

        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.kinopoisk.ru/series/464963/", currentUrl);
        driver.quit();
    }

    @Test
    public void correctTransitionByClickLinkTryPlus() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.kinopoisk.ru/");

        WebElement element = driver.findElement(By.xpath("//a[text()='Попробовать Плюс']"));
        element.click();

        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://hd.kinopoisk.ru/?source=kinopoisk_head_button", currentUrl);
        driver.quit();
    }

    @Test
    public void correctTransitionByClickLinkJobOpenings() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.kinopoisk.ru/");

        WebElement element = driver.findElement(By.xpath("//a[text()='Вакансии']"));
        element.click();

        Thread.sleep(3000);
        WebDriver window = driver.switchTo().window((new ArrayList<String>(driver.getWindowHandles())).get(1));
        String currentUrl = window.getCurrentUrl();
        Assertions.assertEquals("https://yandex.ru/jobs/vacancies?professions=backend-developer&professions=database-developer&professions=desktop-developer&professions=frontend-developer&professions=full-stack-developer&professions=mob-app-developer&professions=mob-app-developer-android&professions=mob-app-developer-ios&professions=noc-developer&professions=system-developer", currentUrl);
        driver.quit();
    }
}
