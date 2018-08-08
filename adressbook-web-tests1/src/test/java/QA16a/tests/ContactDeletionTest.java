package QA16a.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {
    @Test
    public void deletionFirstContact () {
        app.getContactHelper().isOnContactPage();

        if (!app.isContactPresent(By.name("selected[]"))) {
            app.createContact();
        }

            int before = app.getContactHelper().getContactCount();
            app.getContactHelper().selectContact(); //first contact
            app.getContactHelper().deleteContact();
            app.getContactHelper().confirmAlert();
            int after = app.getContactHelper().getContactCount();

            Assert.assertEquals(after, before - 1);

        }


    @Test
    public void deletionLastContact() {
        app.getContactHelper().isOnContactPage();

        if (!app.isContactPresent(By.name("selected[]"))) {
            app.createContact();
        }

            int before = app.getContactHelper().getContactCount();
            app.getContactHelper().selectContactByindex(before - 1); //last contact
            app.getContactHelper().deleteContact();
            app.getContactHelper().confirmAlert();
            int after = app.getContactHelper().getContactCount();

            Assert.assertEquals(after, before - 1);
        }
    }


