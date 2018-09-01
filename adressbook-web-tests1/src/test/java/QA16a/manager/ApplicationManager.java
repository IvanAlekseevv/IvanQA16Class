package QA16a.manager;

import QA16a.model.ContactData;
import QA16a.model.GroupData;
import QA16a.tests.MyListener;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;



public class ApplicationManager {
    SessionHelper sessionHelper;
    GroupHelper groupHelper;
    ContactHelper contactHelper;
    private EventFiringWebDriver wd;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void start() {
        if (browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
        }else if (browser.equals(BrowserType.FIREFOX)){
            wd  = new EventFiringWebDriver (new FirefoxDriver());
        }else if (browser.equals(BrowserType.EDGE)){
            wd  = new EventFiringWebDriver (new EdgeDriver());
        }
        wd.register(new MyListener());

        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.openSite("http://localhost/addressbook/addressbook");
        sessionHelper.login("admin", "secret");
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public void stop() {
        wd.quit();
    }


    public boolean areEltsPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }


    public void createGroup() throws InterruptedException {
        groupHelper.goToGroupsPage();
        groupHelper.initGroupCreation();
        groupHelper.fillGroupsForm(new GroupData()
                .setName("test2")
                .setHeader("test2")
                .setFooter("test2"));
        groupHelper.submitGroupCreation();
        groupHelper.returnToTheGroupsPage();
    }



    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }


    public void createContact() {
        getContactHelper().initContactCreation();
        getContactHelper().fillContactForm(new ContactData()
                .setFirstname("Oleg")
                .setLastname("Olegovich")
                .setNickname("Oleg55")
                .setAddress("Jabotinsky,16")
                .setCompany("IBM"));
        getContactHelper().CreateContact();
    }

    public boolean isContactPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }



    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}






