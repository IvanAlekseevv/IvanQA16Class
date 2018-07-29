package QA16a;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

        @Test
                public void testContactCreation(){

            initContactCreation();
            fillContactForm(new ContactData()
                    .setFirstname("Oleg")
                    .setLastname("Olegovich")
                    .setNickname("Oleg55")
                    .setAddress("Jabotinsky,16")
                    .setCompany("IBM"));


            CreateContact();







        }

}
