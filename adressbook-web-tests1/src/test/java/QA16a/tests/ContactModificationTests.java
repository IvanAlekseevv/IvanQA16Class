package QA16a.tests;

import QA16a.model.ContactData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void testModificationContact() {

        app.getContactHelper().goToHomePage();

        if (!app.areEltsPresent(By.name("selected[]"))) {
            app.createContact();
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().editContactCreation();
        app.getContactHelper().fillContactForm(new ContactData()
                .setFirstname("Olga")
                .setLastname("Ivanovna")
                .setNickname("Olya55")
                .setAddress("Gagarin,345")
                .setCompany("GBL"));
        app.getContactHelper().submitContactModification();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);


    }


    @Test
    public void testModificationContact1() {
        app.getContactHelper().goToHomePage();
        if (!app.areEltsPresent(By.name("selected[]"))) {
            app.createContact();

            app.getContactHelper().editContactCreation();
            app.getContactHelper().deleteContact();

        }
    }
}
