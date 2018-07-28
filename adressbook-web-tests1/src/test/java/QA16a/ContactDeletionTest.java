package QA16a;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void contactDeletionTest(){
        int before = wd.findElements(By.name("selected[]")).size();
        selectContact();
            deleteContact();
            confirmAlert();
            int after =wd.findElements(By.name("selected[]")).size();

        Assert.assertEquals(after,before-1);

        }

    public void confirmAlert() {
        wd.switchTo().alert().accept();
    }

    public void deleteContact() {
        wd.findElement(By.xpath("//*[@value='Delete']")).click();
    }

    public void selectContact() {
        wd.findElement(By.name("selected[]")).click();
    }
}

