package com.selenium.masterclass.seleniummasterclass;

import com.selenium.masterclass.seleniummasterclass.Base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests extends TestBase {

    @Test(description = "This is for Testing")
    public void websiteLaunchTest() throws Exception {
        driver.get("http://www.amazon.in");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Thread.sleep(4000);
        WebElement explorePrimeBtn = driver.findElement(By.xpath("//a[@class='nav-sprite nav-logo-tagline nav-prime-try']"));
        Assert.assertTrue(isElementPresent(By.xpath("//a[@class='nav-sprite nav-logo-tagline nav-prime-try']")));
        explorePrimeBtn.click();
        /*WebElement homeBtn = driver.findElement(By.xpath("//span[@class='nav-sprite nav-logo-base']"));
        homeBtn.click();*/
        click("//span[@class='nav-sprite nav-logo-base']");
        log.debug("Launching browser and routing to Website test passed");
    }

    @Test(description = "Selecting an option from dropdown", dependsOnMethods = "websiteLaunchTest")
    public void searchElement() throws Exception {
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox'] "));
        searchBox.click();
        searchBox.sendKeys("Portronics");
        WebElement searchBtn = driver.findElement(By.xpath("//input[@value='Go']"));
        searchBtn.click();
        log.debug("Search element testcase passed successfully.");
        Thread.sleep(3000);
    }
}