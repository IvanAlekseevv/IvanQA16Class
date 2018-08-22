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
        type(By.name("firstname"),contactData.getFirstname());
        type(By.name("lastname"),contactData.getLastname());
        type(By.name("address"),contactData.getAddress());
        type(By.name("nickname"),contactData.getNickname());
        type(By.name("company"),contactData.getCompany());


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
        if(!isElementPresent(By.id("maintable"))){
        click(By.linkText("home"));
        }
    }
}
