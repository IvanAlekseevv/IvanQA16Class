package QA16a.tests;

import QA16a.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();

        int before = app.getGroupHelper().getGroupCount();
        List<GroupData>groupListBefore = app.getGroupHelper().getGroupList();

        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupsForm(new GroupData()
                .setName("testGroupName2")
        .setHeader("testGroupHeader2")
        .setFooter("testGroupFooter2"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToTheGroupsPage();
        Thread.sleep(2000);
        int after = app.getGroupHelper().getGroupCount();
        List<GroupData> groupListAfter
                = app.getGroupHelper().getGroupList();

        Assert.assertEquals(groupListAfter.size(), groupListBefore.size()+1);
    }


}

