package com.telran.qaq6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupModificationTests extends TestBase  {


    @Test
            public void testGroupModification(){
        goToGroupsPage();
        selectGroup();
        initGroupModification();
        fillGroupsForm();
        submitGroupModification();
        returnToTheGroupsPage();



            wd.findElement(By.linkText("groups")).click();

            wd.findElement(By.name("selected")).click();



        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys("modifyedTestGroupName1");

        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys("modifyedTestGroupHeader1");

        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys("modifyedTestGroupFooter1");


        wd.findElement(By.linkText("group page")).click();


    }

}
