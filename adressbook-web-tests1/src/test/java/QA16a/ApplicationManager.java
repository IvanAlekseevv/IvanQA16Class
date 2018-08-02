package QA16a;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;



public class ApplicationManager {
    SessionHelper sessionHelper;
    GroupHelper groupHelper;
    ContactHelper contactHelper;
     public WebDriver wd;

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sessionHelper=new SessionHelper(wd);
        sessionHelper.openSite("http://localhost/addressbook/addressbook");
        sessionHelper.login("admin", "secret");
        groupHelper=new GroupHelper(wd);
        contactHelper=new ContactHelper(wd);
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public void stop() {
        wd.quit();
    }



    public boolean areEltsPresent(By locator){
        return wd.findElements(locator).size()>0;
   }

    public boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void createGroup(){
        groupHelper.goToGroupsPage();
        groupHelper.initGroupCreation();
        groupHelper.fillGroupsForm(new GroupData()
                .setName("test2")
                .setHeader("test2")
                .setFooter("test2"));
        groupHelper.submitGroupCreation();
        groupHelper.returnToTheGroupsPage();
    }


    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }


    }






