package QA16a.tests;

import QA16a.model.GroupData;
import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation(){

        app.getGroupHelper().goToGroupsPage();

        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupsForm(new GroupData()
                .setName("testGroupName2")
        .setHeader("testGroupHeader2")
        .setFooter("testGroupFooter2"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToTheGroupsPage();
    }


}

