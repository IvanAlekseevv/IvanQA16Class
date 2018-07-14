import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Ebay1 {
    private WebDriver driver;


    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testEbay11() throws Exception {
        OpenSite();
        driver.findElement(By.id("gh-la")).click();
        fillRegisterField();


        fillPasswordField();
        fillFirstNameField();
        fillLastNameField();
        fillEmailField();
    }

    public void OpenSite() {
        driver.get("https://www.ebay.com/");
    }

    public void fillEmailField() {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("kropivnisk+2@gmail.com");
    }

    public void fillLastNameField() {
        driver.findElement(By.id("lastname")).clear();
        driver.findElement(By.id("lastname")).sendKeys("Ivanov");
    }

    public void fillFirstNameField() {
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys("Egor");
    }

    public void fillPasswordField() {
        driver.findElement(By.id("PASSWORD")).clear();
        driver.findElement(By.id("PASSWORD")).sendKeys("ivan1978");
    }

    public void fillRegisterField() {
        driver.findElement(By.linkText("register")).click();
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        Thread.sleep( 3000);
        driver.quit();

        }


    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }


    }


