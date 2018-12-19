package com.selenium.masterclass.seleniummasterclass.listeners;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.masterclass.seleniummasterclass.Base.TestBase;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListeners extends TestBase implements ITestListener {

    public void onFinish(ITestContext arg0) {


    }

    public void onStart(ITestContext arg0) {


    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {


    }

    public void onTestFailure(ITestResult arg0) {
        test.log(LogStatus.FAIL, arg0.getName().toUpperCase() + " Failed with exception : " + arg0.getThrowable());
        //test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
        rep.endTest(test);
        rep.flush();
    }

    public void onTestSkipped(ITestResult arg0) {
        test.log(LogStatus.SKIP, arg0.getName().toUpperCase() + " Skipped the test as the Run mode is NO");
        rep.endTest(test);
        rep.flush();
    }


    public void onTestStart(ITestResult arg0) {
        test = rep.startTest(arg0.getName().toUpperCase());
    }

    public void onTestSuccess(ITestResult arg0) {
        test.log(LogStatus.PASS, arg0.getName().toUpperCase() + " PASS");
        rep.endTest(test);
        rep.flush();
    }

    public void onFinish(ISuite arg0) {

    }

    public void onStart(ISuite arg0) {

    }
}
