package QA16a.tests;

import QA16a.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws InterruptedException {
        app.getContactHelper().isOnContactPage();
        List<ContactData> before = app.getContactHelper().getContactsList();

        app.getContactHelper().initContactCreation();

        File photo = new File("src/test/resources/2014-03-22 10.57.26.jpg");


        app.getContactHelper().fillContactForm(new ContactData()
                .setFirstname("1Oleg")
                .setLastname("1Olegovich")
                .setNickname("1Oleg55")
                .setAddress("1Jabotinsky,16")
                .setCompany("1IBM")
                .setPhoto(photo)
                .setGroup("qwe"));
        app.getContactHelper().CreateContact();

        Thread.sleep(2000);

        List<ContactData> after = app.getContactHelper().getContactsList();

        Assert.assertEquals(after.size(), before.size() + 1);


    }

}

