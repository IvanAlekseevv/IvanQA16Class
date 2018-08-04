package QA16a.tests;

import QA16a.model.ContactData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().goToHomePage();
        if (!app.areEltsPresent(By.name("selected[]"))) {
            app.createContact();

            int before = app.getContactHelper().getContactCount();
            app.getContactHelper().initContactCreation();
            app.getContactHelper().fillContactForm(new ContactData()
                    .setFirstname("Oleg")
                    .setLastname("Olegovich")
                    .setNickname("Oleg55")
                    .setAddress("Jabotinsky,16")
                    .setCompany("IBM"));
            app.getContactHelper().CreateContact();
            int after = app.getContactHelper().getContactCount();
            Assert.assertEquals(after, before);


        }

    }
}
