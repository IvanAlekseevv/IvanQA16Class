package QA16a;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

        @Test
                public void testContactCreation(){

            initContactCreation();
            fillContactForm(new ContactData("Oleg", "Olegovich", "Oleg55", "Jabotinsky,16", "IBM"));
            CreateContact();







        }

}
