package ru.buttonone.page_task;

import org.openqa.selenium.WebDriver;
import ru.buttonone.utils.Props;


public abstract class BaseWorkPage {
    protected WebDriver driver;

    public BaseWorkPage(WebDriver driver) {
        this.driver = driver;
    }

    static {
        System.setProperty("webdriver.chrome.driver", Props.getProperty("chromedriver"));
    }
}
