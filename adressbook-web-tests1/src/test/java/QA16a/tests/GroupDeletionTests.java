package QA16a.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void deletionFirstGroupTest() {
        app.getGroupHelper().goToGroupsPage();
        if (!app.isElementPresent(By.name("selected[]"))) {
            app.createGroup();
        }
        int before = app.getGroupCount();
        app.getGroupHelper().selectGroup(); //first group
        app.getGroupHelper().groupDeletion();
        app.getGroupHelper().returnToTheGroupsPage();
        int after= app.getGroupCount();

        Assert.assertEquals(after,before-1);
    }

    @Test
    public void deletionLastGroupTest() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();
        if (!app.areEltsPresent(By.name("selected[]"))) {
            app.createGroup();
        }
        int before = app.getGroupCount();
        app.getGroupHelper().selectGroupByindex(before-1); //last group
        Thread.sleep(3000);
        app.getGroupHelper().groupDeletion();
        app.getGroupHelper().returnToTheGroupsPage();
        int after= app.getGroupCount();

        Assert.assertEquals(after,before-1);
    }


}
