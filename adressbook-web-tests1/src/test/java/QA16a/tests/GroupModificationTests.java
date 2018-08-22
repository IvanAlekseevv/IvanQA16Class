package QA16a.tests;

import QA16a.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {


    @Test
    public void testGroupModification() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();
        if(!app.getGroupHelper().isGroupPresent()){
            app.getGroupHelper().createGroup();
        }
        List<GroupData> groupListBefore
                = app.getGroupHelper().getGroupList();

        //int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        GroupData group =new GroupData()
                .setId(groupListBefore.get(0).getId())
                .setName("qwe")
                .setHeader("asd")
                .setFooter("zxc");
        app.getGroupHelper().fillGroupsForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToTheGroupsPage();
       // int after= app.getGroupHelper().getGroupCount();
        List<GroupData> groupListAfter
                = app.getGroupHelper().getGroupList();

        groupListBefore.remove(0);
        groupListBefore.add(group);

       Assert.assertEquals(groupListAfter.size(),groupListBefore.size());

       Assert.assertEquals(new HashSet<Object>(groupListBefore),
               new HashSet<Object>(groupListAfter));


    }

}
