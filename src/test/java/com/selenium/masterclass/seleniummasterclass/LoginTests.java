package com.selenium.masterclass.seleniummasterclass;

import com.selenium.masterclass.seleniummasterclass.Base.TestBase;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class LoginTests extends TestBase {

    @Test(description = "Launching Website and testing a few elements on the page.")
    public void websiteLaunchTest() throws Exception {
        driver.get("http://www.amazon.in");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Thread.sleep(4000);
        Assert.assertEquals(driver.getTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
        WebElement explorePrimeBtn = driver.findElement(By.xpath("//a[@class='nav-sprite nav-logo-tagline nav-prime-try']"));
        Assert.assertTrue(isElementPresent(By.xpath("//a[@class='nav-sprite nav-logo-tagline nav-prime-try']")));
        explorePrimeBtn.click();
        /*WebElement homeBtn = driver.findElement(By.xpath("//span[@class='nav-sprite nav-logo-base']"));
        homeBtn.click();*/
        click("//span[@class='nav-sprite nav-logo-base']");
        log.debug("Launching browser and routing to Website test passed");
    }

    @Test(description = "Searching an product in the search box.", dependsOnMethods = "websiteLaunchTest")
    public void searchProduct() throws Exception {
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox'] "));
        searchBox.click();
        searchBox.sendKeys("Portronics");
        WebElement searchBtn = driver.findElement(By.xpath("//input[@value='Go']"));
        searchBtn.click();
        log.debug("Search element testcase passed successfully.");
        Thread.sleep(3000);
    }

    @Test(description = "Selecting an element from dropdown", dependsOnMethods = "searchProduct")
    public void selectElementFromDropDown() throws Exception{
        Select sortProducts = new Select(driver.findElement(By.id("sort")));
        sortProducts.selectByVisibleText("Price: Low to High");
        driver.navigate().back();
        Thread.sleep(4000);
        /*sortProducts.selectByIndex(2);
        Thread.sleep(4000);
        sortProducts.selectByVisibleText("Avg. Customer Review");
        sortProducts.selectByValue("date-desc-rank");*/
    }
}