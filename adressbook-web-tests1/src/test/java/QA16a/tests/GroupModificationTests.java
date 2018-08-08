package QA16a.tests;

import QA16a.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {


    @Test
    public void testGroupModification() {
        app.getGroupHelper().goToGroupsPage();
        if(!app.getGroupHelper().isGroupPresent()){
            app.getGroupHelper().createGroup();
        }
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupsForm(new GroupData()
        .setName("qwe")
        .setHeader("asd")
        .setFooter("zxc"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToTheGroupsPage();
        int after= app.getGroupHelper().getGroupCount();

        Assert.assertEquals(after,before);

    }

}
