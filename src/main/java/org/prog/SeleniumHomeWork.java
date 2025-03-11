package org.prog;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

//TODO: go to allo.ua
//TODO: search for ANY PHONE
//TODO: print phone name for 1st phone in search
//TODO: For example: Apple iPhone 16 Pro Max 256GB Desert Titanium (MYWX3)
public class SeleniumHomeWork {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.get("https://allo.ua/");
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10L));
            WebElement searchInput =
                    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-form__input")));
            searchInput.click();
            searchInput.sendKeys("Poco");
            searchInput.sendKeys(Keys.ENTER);


            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'product-card__content')]")));

            List<WebElement> phoneName = driver.findElements(By.xpath("//div[contains(@class,'product-card__content')]"));

            if (!phoneName.isEmpty()) {
                List<WebElement> names = driver.findElements(By.className("product-card__title"));
                System.out.println(names.get(0).getText());
            }


            System.out.println("ok");
        } finally {
            if (driver != null) {
                driver.quit();
            }

        }
    }
}
