package com.telran.qaq6;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        openSite();
        login();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    public void login() {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("admin");

        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys("secret");

        wd.findElement(By.xpath("//*[@value='Login']")).click();
    }

    public void openSite() {
        wd.navigate().to("http://localhost/addressbook/addressbook");
    }

    public void returnToTheGroupsPage() {
        wd.findElement(By.linkText("group page")).click();
    }

    public void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillGroupsForm() {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys("testGroupName1");

        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys("testGroupHeader1");

        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys("testGroupFooter1");
    }

    public void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    public void goToGroupsPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    public void groupDeletion() {
        wd.findElement(By.name("delete")).click();
    }

    public void selectGroup() {
        wd.findElement(By.name("selected")).click();
    }


    public void submitGroupModification() {
        wd.findElement(By.name("update")).click();

    }

    public void initGroupModification() {
        wd.findElement(By.name("edit")).click();
    }

    protected void createContact() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillContactForm(String firstname, String lastname, String adress) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(firstname);

        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(lastname);

        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(adress);


    }


    public void selectGroupByIndex(int ind) {
        wd.findElements(By.name("selected[]")).get(ind).click();
    }

    public void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }


    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }


    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size()>0;
    }
}



