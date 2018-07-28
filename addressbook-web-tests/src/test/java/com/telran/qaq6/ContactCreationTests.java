package com.telran.qaq6;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
    @Test
            public void testContactCreation(){
        initContactCreation();
        fillContactForm("", "", "");
        createContact();


    }


}
