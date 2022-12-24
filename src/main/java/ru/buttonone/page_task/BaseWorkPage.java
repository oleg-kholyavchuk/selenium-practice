package ru.buttonone.page_task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.buttonone.utils.Props;

import java.time.Duration;


public abstract class BaseWorkPage {
    protected WebDriver driver;

    static {
        System.setProperty("webdriver.chrome.driver", Props.getProperty("chromedriver"));
    }

    public BaseWorkPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
