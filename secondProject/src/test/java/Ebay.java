
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Ebay {
    private WebDriver driver;


    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testEbay() {


        openSite();

        driver.findElement(By.id("gh-la")).click();
        fillRegisterField();

        fillFirstNameField();

        fillLastNameField();

        fillEmailField();

        fillPasswordField();

        driver.findElement(By.xpath("//div[@id='showPASSWORD']/ul/li/span")).click();
        driver.findElement(By.xpath("//div[@id='showPASSWORD']/ul/li/span")).click();
        driver.findElement(By.id("reginter")).click();
        driver.findElement(By.id("gh-la")).click();
    }

    public void fillRegisterField() {
        driver.findElement(By.linkText("register")).click();
    }

    public void openSite() {
        driver.get("https://www.ebay.com/");
    }

    public void fillPasswordField() {
        driver.findElement(By.id("PASSWORD")).clear();
        driver.findElement(By.id("PASSWORD")).sendKeys("ivan1978");
    }

    public void fillEmailField() {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("kropivnisk@gmail.com");
    }

    public void fillLastNameField() {
        driver.findElement(By.id("lastname")).clear();
        driver.findElement(By.id("lastname")).sendKeys("Alekseev");
    }

    public void fillFirstNameField() {
        driver.findElement(By.id("firstname")).click();
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys("Ivan");
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


