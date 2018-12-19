package com.selenium.masterclass.seleniummasterclass.Base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.masterclass.seleniummasterclass.Utilities.ExtentManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties config = new Properties();
    public static FileInputStream fis;
    public static Logger log = Logger.getLogger("devpinoyLogger");
    public static ExtentTest test;
    public static WebElement dropdown;
    public ExtentReports rep = ExtentManager.getInstance();

    @BeforeSuite
    public void setUp() {

        if (driver == null) {

            try {
                fis = new FileInputStream(
                        System.getProperty("user.dir") + "\\src\\main\\resources\\Config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                config.load(fis);
                log.debug("Config file Loaded");
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (config.getProperty("browser").equals("firefox")) {

                System.setProperty("webdriver.gecko.driver", "\\src\\main\\resources\\executables\\geckodriver.exe");
                driver = new FirefoxDriver();
                log.debug("Firefox browser launched");

            } else if (config.getProperty("browser").equals("chrome")) {

                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "\\src\\main\\resources\\executables\\chromedriver.exe");
                driver = new ChromeDriver();
                log.debug("Chrome browser launched");
            }
            //driver.get(config.getProperty("testsiteURL");
            driver.manage().window().maximize();
            log.debug("Browser Maximized and Testsite is loaded");
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
                    TimeUnit.SECONDS);
        }
    }

    //Defining actions on Elements.

    public void click(String locator) {
        driver.findElement(By.xpath(locator)).click();
        test.log(LogStatus.INFO, "Clicking on the button" + locator);
    }

    public void type(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
        test.log(LogStatus.INFO, "Typing in : " + locator + " entered value as " + value);
    }

    public void select(String locator, String value) {
        dropdown = driver.findElement(By.xpath(locator));
        test.log(LogStatus.INFO, "Selecting from dropdown : " + locator + " value as " + value);
    }

    //Verifying the presence of an Element.

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        log.debug("Test Suite execution complete.");
    }

}
