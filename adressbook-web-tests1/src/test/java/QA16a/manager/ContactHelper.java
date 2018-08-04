package QA16a.manager;

import QA16a.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void CreateContact() {
        wd.findElement(By.name("submit")).click();

    }

    public void fillContactForm(ContactData contactData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());

        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());

        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(contactData.getAddress());

        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(contactData.getNickname());

        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(contactData.getCompany());


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

    public void confirmAlert() { wd.switchTo().alert().accept(); }

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
}
