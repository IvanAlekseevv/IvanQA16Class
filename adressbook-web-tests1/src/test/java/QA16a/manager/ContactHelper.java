package QA16a.manager;

import QA16a.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void CreateContact() {
        wd.findElement(By.name("submit")).click();

    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("company"), contactData.getCompany());
        attach(By.name("photo"), contactData.getPhoto());

      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup()); //выпадающие списки это select
    }

    public void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void deleteContact() {
        wd.findElement(By.xpath("//*[@value='Delete']")).click();
    }

    public void selectContact() {
        wd.findElement(By.name("selected[]")).click();
    }

    public void confirmAlert() throws InterruptedException {
        wd.switchTo().alert().accept();
        Thread.sleep(2000);
    }

    private void dismissAlert() {
        wd.switchTo().alert().dismiss();
    }

    public void editContactCreation() {
        wd.findElement(By.xpath("//*[@title='Edit']")).click();
    }

    public void submitContactModification() {
        wd.findElement(By.name("update")).click();
    }

    public void selectContactByindex(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void goToHomePage() {
        wd.findElement(By.linkText("home")).click();
    }

    public void isOnContactPage() {
        if (!isElementPresent(By.id("maintable"))) {
            click(By.linkText("home"));
        }
    }

    public List<ContactData> getContactsList() {
        List<ContactData> contacts = new ArrayList<>();

        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.name("selected[]")).getAttribute("value"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            contacts.add(new ContactData()
                    .setId(id)
                    .setLastname(lastName)
                    .setFirstname(firstName));

        }
        return contacts;
    }
}


