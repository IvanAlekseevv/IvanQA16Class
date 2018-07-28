package QA16a;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation(){
        goToGroupsPage();
        initGroupCreation();
        fillGroupsForm(new GroupData()
                .setName("testGroupName2")
        .setHeader("testGroupHeader2")
        .setFooter("testGroupFooter2"));
        submitGroupCreation();
        returnToTheGroupsPage();
    }


}

