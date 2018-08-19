package QA16a.tests;

import QA16a.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTests extends TestBase {

    @Test
    public void deletionFirstGroupTest() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();
        if(!app.getGroupHelper().isGroupPresent()){
            app.getGroupHelper().createGroup();
        }
        List<GroupData> groupListBefore
                = app.getGroupHelper().getGroupList();

        //int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup(); //first group
        app.getGroupHelper().groupDeletion();
        app.getGroupHelper().returnToTheGroupsPage();
        List<GroupData> groupListAfter
                = app.getGroupHelper().getGroupList();
        //int after= app.getGroupHelper().getGroupCount();

        groupListBefore.remove(0);
        Assert.assertEquals(groupListBefore.size(), groupListAfter.size());
        Assert.assertEquals(groupListBefore,groupListAfter);
    }

    @Test
    public void deletionLastGroupTest() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();
        if(!app.getGroupHelper().isGroupPresent()){
            app.getGroupHelper().createGroup();
        }
        List<GroupData> groupListBefore
                = app.getGroupHelper().getGroupList();

        //int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroupByindex(groupListBefore.size()-1); //last group

        app.getGroupHelper().groupDeletion();
        app.getGroupHelper().returnToTheGroupsPage();
        //int after= app.getGroupHelper().getGroupCount();

        List<GroupData> groupListAfter
                = app.getGroupHelper().getGroupList();

        Assert.assertEquals(groupListAfter.size(), groupListBefore.size()-1);
        groupListBefore.remove(groupListBefore.size()-1);
        Assert.assertEquals(groupListAfter, groupListBefore);
    }


}
