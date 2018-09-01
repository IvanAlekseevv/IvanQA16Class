package QA16a.tests;

import QA16a.model.GroupData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class GroupCreationTests extends TestBase {
    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
        List<Object[]> list = new ArrayList<>();
        //  list.add(new Object[]{new GroupData().setName("fgdfghfg")
        // .setHeader("ghhg")
        //.setFooter("dfdf")});
        // list.add(new Object[]){new GroupData().setName("56575676")
        // .setHeader("34343")
        // .setFooter("8989898")});

        BufferedReader reader =
                new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));

        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new GroupData()
                    .setName(split[0])
                    .setHeader(split[1])
                    .setFooter(split[2])});
            line = reader.readLine();

        }

        return list.iterator();

    }


    @Test(dataProvider = "validGroups")
    public void testGroupCreation(GroupData group) throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();

        //int before = app.getGroupHelper().getGroupCount();
        List<GroupData> groupListBefore = app.getGroupHelper().getGroupList();

        app.getGroupHelper().initGroupCreation();
        //GroupData group = new GroupData()
        //       .setName("testGroupName2")
        //     .setHeader("testGroupHeader2")
        //    .setFooter("testGroupFooter2");
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
