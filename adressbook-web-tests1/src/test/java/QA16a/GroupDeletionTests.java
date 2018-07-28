package QA16a;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupDeletionTests extends TestBase {

        @Test
    public void testGroupDeletion(){
            goToGroupsPage();
            selectGroup();
            groupDeletion();
            returnToTheGroupsPage();

        }
}
