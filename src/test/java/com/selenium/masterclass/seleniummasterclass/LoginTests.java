package com.selenium.masterclass.seleniummasterclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class LoginTests extends TestBase{

    @Test(description = "This is for Testing")
    public void launchTestOne(){
        driver.get("http://www.beebom.com");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test(description = "Selecting an option from dropdown", dependsOnMethods = "launchTestOne")
    public void dropDownElementMore() throws Exception{
        WebElement dropdownMoreBtn = driver.findElement(By.className("sf-with-ul"));
        dropdownMoreBtn.click();
        Thread.sleep(3000);
    }
}
