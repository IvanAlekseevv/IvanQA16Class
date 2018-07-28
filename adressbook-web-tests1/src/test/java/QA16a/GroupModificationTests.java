package QA16a;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {


    @Test
    public void testGroupModification() {
        goToGroupsPage();
        selectGroup();
        initGroupModification();
        fillGroupsForm(new GroupData()
        .setName("qwe")
        .setHeader("asd")
        .setFooter("zxc"));
        submitGroupModification();
        returnToTheGroupsPage();

    }

}
