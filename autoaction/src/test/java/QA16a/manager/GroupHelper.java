package QA16a.manager;

import QA16a.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void goToGroupsPage() {
        if (!isElementPresent(By.xpath("//h1[contains(text(),'Groups')]"))
                && !isElementPresent(By.name("new"))) {
            click(By.linkText("groups"));
        }

    }

    public void returnToTheGroupsPage() throws InterruptedException {
        click(By.linkText("group page"));
        Thread.sleep(2000);
    }


    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupsForm(GroupData groupData) {

        type(By.name("group_name"), groupData.getName());

        type(By.name("group_header"), groupData.getHeader());

        type(By.name("group_footer"), groupData.getFooter());

    }

    public void type(GroupData group, By locator) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(group.getName());

        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(group.getHeader());

        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(group.getFooter());
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

    public int getGroupCount() {
        return wd.findElements(By.cssSelector("span.group")).size();
    }


    public void createGroup() throws InterruptedException {
        goToGroupsPage();
        initGroupCreation();
        fillGroupsForm(new GroupData()
                .setName("test2")
                .setHeader("test1")
                .setFooter("test"));
        submitGroupCreation();
        returnToTheGroupsPage();
    }

    public boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public List<GroupData> getGroupList() {
    List<GroupData>groups = new ArrayList<>();
        List<WebElement> elements =
                wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(
                    element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData().setName(name);
            groups.add(group);

        }
        System.out.println(groups);
        return groups;
    }
}


