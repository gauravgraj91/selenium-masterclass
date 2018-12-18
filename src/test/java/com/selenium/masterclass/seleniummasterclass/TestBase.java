package com.selenium.masterclass.seleniummasterclass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.selenium.masterclass.seleniummasterclass.Utilities.ExtentManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

public class TestBase {

    public static WebDriver driver;
    public static Properties config = new Properties();
    public static FileInputStream fis;
    public static Logger log = Logger.getLogger("devpinoyLogger");
    public ExtentReports rep = ExtentManager.getInstance();
    public static ExtentTest test;

    @BeforeSuite
    public void setUp(){

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

    public boolean isElementPresent(By by){
        try {
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException e){
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
