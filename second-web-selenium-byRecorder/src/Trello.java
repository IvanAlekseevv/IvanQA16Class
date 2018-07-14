package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Trello {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTrello() throws Exception {
    driver.get("https://trello.com/");
    driver.findElement(By.linkText("Войти")).click();
    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("Ivan");
    driver.findElement(By.id("email")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=email | ]]
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("kropivnisk@gmail.com");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("316015");
    driver.findElement(By.id("signup")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("ivan1978");
    driver.findElement(By.id("signup")).click();
    driver.findElement(By.xpath("//img[contains(@src,'https://a.trellocdn.com/prgb/dist/images/trello-logo-blue.a185d94ba76be2701fb1.svg')]")).click();
    driver.findElement(By.linkText("Войти")).click();
    driver.findElement(By.id("user")).click();
    driver.findElement(By.id("user")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=user | ]]
    driver.findElement(By.id("user")).click();
    driver.findElement(By.id("user")).click();
    driver.findElement(By.id("user")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=user | ]]
    driver.findElement(By.id("user")).click();
    driver.findElement(By.id("user")).clear();
    driver.findElement(By.id("user")).sendKeys("kropivnisk@gmail.com");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("ivan1978");
    driver.findElement(By.id("login")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
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

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
