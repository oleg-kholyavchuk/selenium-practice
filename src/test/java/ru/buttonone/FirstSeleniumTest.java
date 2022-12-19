package ru.buttonone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

@Disabled
public class FirstSeleniumTest {

    @Test
    public void shouldHaveCorrectOpenGoogle(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
//        driver.navigate().to("http://vk.com");
//        driver.navigate().back();
//        driver.navigate().forward();
//        driver.navigate().refresh();

//        WebElement searchField = driver.findElement(By.className("gLFyf"));
//        System.out.println("searchField = " + searchField);
//        searchField.click();

        List<WebElement> menuList = driver.findElements(By.className("pHi0h"));
        for(WebElement we: menuList){
            System.out.println(we.getText());
        }



        WebElement element = driver.findElement(By.tagName("input"));
        System.out.println(element.getText());

        element.sendKeys("java");
        element.sendKeys(Keys.RETURN);

        WebElement linkToOracle = driver.findElement(By.xpath("//h3[text()='Java - Википедия']"));
        linkToOracle.click();

        WebElement articleTitleFromWiki = driver.findElement(By.xpath("//span[text()='Java']"));

        Assertions.assertEquals("Java", articleTitleFromWiki.getText());


        driver.quit();
    }
}
