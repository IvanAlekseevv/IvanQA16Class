package QA16a;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

        @Test
                public void testContactCreation(){

            initContactCreation();
            fillContactForm(new ContactData("Oleg", "Olegovich", "Jabotinsky,16"));
            CreateContact();







        }

}
