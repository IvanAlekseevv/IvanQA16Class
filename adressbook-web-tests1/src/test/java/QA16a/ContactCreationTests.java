package QA16a;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

        @Test
                public void testContactCreation(){

            app.getContactHelper().initContactCreation();
            app.getContactHelper().fillContactForm(new ContactData()
                    .setFirstname("Oleg")
                    .setLastname("Olegovich")
                    .setNickname("Oleg55")
                    .setAddress("Jabotinsky,16")
                    .setCompany("IBM"));


            app.getContactHelper().CreateContact();







        }

}
