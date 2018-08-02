package QA16a.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getGroupHelper().goToGroupsPage();
        if (!app.isElementPresent(By.name("selected[]"))) {
            app.createGroup();
        }
        int before = app.getGroupCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().groupDeletion();
        app.getGroupHelper().returnToTheGroupsPage();
        int after= app.getGroupCount();

        Assert.assertEquals(after,before-1);
    }

    @Test
    public void testGroupDeletion1() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();
        if (!app.areEltsPresent(By.name("selected[]"))) {
            app.createGroup();
        }
        int before = app.getGroupCount();
        app.getGroupHelper().selectGroupByindex(before-1);
        Thread.sleep(3000);
        app.getGroupHelper().groupDeletion();
        app.getGroupHelper().returnToTheGroupsPage();
        int after= app.getGroupCount();

        Assert.assertEquals(after,before-1);
    }


}
