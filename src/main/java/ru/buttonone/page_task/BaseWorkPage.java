package ru.buttonone.page_task;

import org.openqa.selenium.WebDriver;


public abstract class BaseWorkPage {
    public WebDriver driver;

    public BaseWorkPage(WebDriver driver) {
        this.driver = driver;
    }

    static {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
    }
}
