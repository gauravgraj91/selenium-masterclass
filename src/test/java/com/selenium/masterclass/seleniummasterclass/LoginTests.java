package com.selenium.masterclass.seleniummasterclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class LoginTests extends TestBase{

    @Test(description = "This is for Testing")
    public void launchTestOne() throws Exception{
        driver.get("http://www.amazon.in");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://www.amazon.in/amazonprime?_encoding=UTF8&ref=nav_logo_prime_join");
        /*WebElement goToTryPrime = driver.findElement(By.name("Try Prime"));
        goToTryPrime.click();*/
        Thread.sleep(4000);
    }

    @Test(description = "Selecting an option from dropdown", dependsOnMethods = "launchTestOne")
    public void dropDownElementMore() throws Exception{
        WebElement dropdownMoreBtn = driver.findElement(By.className("nav-logo-link"));
        dropdownMoreBtn.click();
        log.debug("The first test case passed successfully.");
        Thread.sleep(3000);
    }
}
