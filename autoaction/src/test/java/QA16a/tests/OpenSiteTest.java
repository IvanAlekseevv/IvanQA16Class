package QA16a.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OpenSiteTest extends TestBase {
    @Test
    public void testSiteOpened(){
        Assert.assertTrue(app.getSessionHelper()
                .isElementPresent(By.xpath("//img")));

    }
}
