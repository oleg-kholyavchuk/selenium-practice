package ru.buttonone.page_task;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.buttonone.utils.Props;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class KinopoiskPage extends BaseWorkPage {
    private WebElement webElement;
    @FindBy(xpath = "//input[@name='kp_query']")
    private WebElement searchField;

    public KinopoiskPage(WebDriver driver) {
        super(driver);
        driver.navigate().to(Props.getProperty("url_kinopoisk"));
    }

    public void clickKinopoiskPage(String xpathSearch) {
        Actions actions = new Actions(driver);
        webElement = driver.findElement(By.xpath(xpathSearch));
        actions.pause(5).moveToElement(webElement).pause(5).click().build().perform();
    }

    public String currentUrlWebDriver() {
        WebDriver window = driver.switchTo().window((new ArrayList<>(driver.getWindowHandles())).get(1));
        return window.getCurrentUrl();
    }

    public String currentUrlWebElement() {
        return driver.getCurrentUrl();
    }

    public SearchingResultWorkPage searchByPhraseAndClickEnter(String phrase) {
        JavascriptExecutor exception = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);
        webElement = driver.findElement(By.xpath("//button[text()='Найти']"));
        exception.executeScript("arguments[0].value = '" + phrase + "'", searchField);
        actions.pause(5).moveToElement(webElement).click(webElement).build().perform();
        return new SearchingResultWorkPage(driver);
    }
}
