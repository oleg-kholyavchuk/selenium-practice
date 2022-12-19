package ru.buttonone.page_task;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.buttonone.utils.Props;

import java.time.Duration;
import java.util.ArrayList;

@SuppressWarnings("ALL")
public class KinopoiskPage extends BaseWorkPage {
    private final WebElement webElement;
    @FindBy(xpath = "//input[@name='kp_query']")
    private WebElement searchField;

    public KinopoiskPage(WebDriver driver, String xpathSearch) {
        super(driver);
        PageFactory.initElements(driver, this);
        driver.navigate().to(Props.getProperty("url_kinopoisk"));
        webElement = (new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathSearch))));
    }

    public void clickKinopoiskPage() {
        webElement.click();
    }

    public String currentUrlWebDriver() {
        WebDriver window = driver.switchTo().window((new ArrayList<>(driver.getWindowHandles())).get(1));
        return window.getCurrentUrl();
    }

    public String currentUrlWebElement() {
        return driver.getCurrentUrl();
    }

    public SearchingResultWorkPage searchByPhraseAndClickEnter(String phrase) {
        searchField.click();
        searchField.sendKeys(phrase);
        searchField.sendKeys(Keys.RETURN);
        return new SearchingResultWorkPage(driver);
    }
}
