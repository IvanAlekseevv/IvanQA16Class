package QA16a.tests;

import QA16a.model.GroupData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();

        //int before = app.getGroupHelper().getGroupCount();
        List<GroupData> groupListBefore = app.getGroupHelper().getGroupList();

        app.getGroupHelper().initGroupCreation();
        GroupData group = new GroupData()
                .setName("testGroupName2")
                .setHeader("testGroupHeader2")
                .setFooter("testGroupFooter2");
        app.getGroupHelper().fillGroupsForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToTheGroupsPage();
        Thread.sleep(2000);
        //int after = app.getGroupHelper().getGroupCount();
        List<GroupData> groupListAfter
                = app.getGroupHelper().getGroupList();

        Assert.assertEquals(groupListAfter.size(), groupListBefore.size() + 1);

        groupListBefore.add(group);
        int max = 0;
        for (GroupData g : groupListAfter) {
            if (g.getId() > max) {
            }
            group.setId(max);
        }
        Assert.assertEquals(new HashSet<Object>(groupListBefore),
                new HashSet<Object>(groupListAfter));


    }
}
