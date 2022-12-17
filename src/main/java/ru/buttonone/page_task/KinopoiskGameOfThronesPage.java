package ru.buttonone.page_task;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class KinopoiskGameOfThronesPage extends BaseWorkPage {

    @FindBy(xpath = "//span[text()='Игра престолов']")
    private WebElement titleGameOfThrones;

    public KinopoiskGameOfThronesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
