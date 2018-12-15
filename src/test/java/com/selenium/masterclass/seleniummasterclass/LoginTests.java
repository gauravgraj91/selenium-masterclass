package com.selenium.masterclass.seleniummasterclass;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class LoginTests {

    WebDriver driver;

    @Test(description = "This is for Testing")
    public void launchTestOne(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.beebom.com");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test(description = "Selecting an option from dropdown", dependsOnMethods = "launchTestOne")
    public void dropDownElementMore() throws Exception{
        WebElement dropdownMoreBtn = driver.findElement(By.className("sf-with-ul"));
        dropdownMoreBtn.click();
        Thread.sleep(3000);
        //WebElement aboutUsBtn = driver.findElement(By.className("menu-item menu-item-type-post_type menu-item-object-page current-menu-item page_item page-item-371 current_page_item td-menu-item td-normal-menu menu-item-17002"));
        //aboutUsBtn.click();
    }

    @AfterClass
    public void closeTheBrowser(){
        driver.quit();
    }

    private void setDriverPathChrome() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }
}
