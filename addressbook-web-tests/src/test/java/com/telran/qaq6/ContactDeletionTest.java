package com.telran.qaq6;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {
    @Test

    public void contactDeletionTest(){
        int before=wd.findElement(By.name("selected[]")).size();
        selectContact();
        deleteContact();
        confirmAlert();
        int after = wd.findElement(By.name("selected[]")).size();
    }
}
