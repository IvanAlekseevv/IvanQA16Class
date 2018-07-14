


        import java.util.concurrent.TimeUnit;

        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.annotations.*;
        import org.openqa.selenium.*;

        public class Trello {
    private WebDriver driver;


    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testTrello(){
        openSite();



        driver.findElement(By.xpath("//*[@href='/signup']")).click();

        fillNameField();

        fillEmailField();

        FillPasswordField();

        clickOnSignUpButton();

    }

            public void clickOnSignUpButton() {
                driver.findElement(By.id("signup")).click();
            }

            public void FillPasswordField() {
                driver.findElement(By.id("password")).click();
                driver.findElement(By.id("password")).clear();
                driver.findElement(By.id("password")).sendKeys("ivan1978");
            }

            public void fillEmailField() {
                driver.findElement(By.id("email")).click();
                driver.findElement(By.id("email")).clear();
                driver.findElement(By.id("email")).sendKeys("kropivnisk@gmail.com");
            }

            public void fillNameField() {
                driver.findElement(By.id("name")).click();
                driver.findElement(By.id("name")).clear();
                driver.findElement(By.id("name")).sendKeys("Ivan");
            }

            public void openSite() {
                driver.get("https://trello.com/");
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
