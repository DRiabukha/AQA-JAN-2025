package org.prog.testng;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

//TODO: create separate test-ng.xml file with this class only
//TODO: move your selenium test to this class
//TODO: Add assertion that goods name is not null
//TODO: Add assertion that goods name has > 0 length

public class AlloUaNGTest {

//    @BeforeClass
//    public void beforeAllo() {
//        System.out.println(">>>>>>>>>>ALLO.START");
//    }
//
//    @AfterClass
//    public void afterAllo() {
//        System.out.println(">>>>>>>>>>ALLO.END");
//    }
//
//    @BeforeMethod
//    public void beforeMethod() {
//        System.out.println("Test!<<<<<<<<<<<<<<<<<<<<");
//    }
//
//    @AfterMethod
//    public void afterMethod() {
//        System.out.println("Test!<<<<<<<<<<<<<<<<<<<<");
//    }

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void alloTest() {
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
                String firstPhoneName = names.get(0).getText();
                Assert.assertNotNull(firstPhoneName, "Phone name should not be null");
                Assert.assertTrue(firstPhoneName.length() > 0, "Phone name should have length > 0");
                System.out.println(firstPhoneName);
            }


            System.out.println("ok");

    }
}
