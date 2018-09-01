package QA16a.tests;

import QA16a.manager.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase extends MyListener{


    protected static ApplicationManager app
            = new ApplicationManager(System
            .getProperty("browser", BrowserType.CHROME));

    @BeforeMethod
    public void logTestStart(Method m){
        logger.info("Start test" +m.getName());

    }

    @AfterMethod
    public void logTestStop(Method m){
        logger.info("Stop test" +m.getName());

    }


    @BeforeSuite
    public void setUp() {
        app.start();

    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }



}
