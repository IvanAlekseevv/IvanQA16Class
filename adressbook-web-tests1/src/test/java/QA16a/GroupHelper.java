package QA16a;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase{

    public GroupHelper(WebDriver wd)  {
        super(wd);
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void goToGroupsPage() {
        click(By.linkText("groups"));
    }

    public void returnToTheGroupsPage() {
        click(By.linkText("group page"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupsForm(GroupData groupData) {

        type(groupData, By.name("group_name"));

        type(groupData, By.name("group_header"));

        type(groupData, By.name("group_footer"));

    }

    public void type(GroupData group, By locator) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(group.getName());
    }

    public void groupDeletion() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void selectGroupByindex(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void submitGroupModification() {
        click(By.name("update"));

    }

    public void initGroupModification() {
        click(By.name("edit"));


    }
    public boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void createGroup(){
        goToGroupsPage();
        initGroupCreation();
        fillGroupsForm(new GroupData()
                .setName("test2")
                .setHeader("test2")
                .setFooter("test"));
        submitGroupCreation();
        returnToTheGroupsPage();
    }
}
