import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IntegrationPage;
import utils.Log;

import java.util.ArrayList;

public class NewTabTest extends BaseTest {


    private IntegrationPage integrationPage;

    @Test
    public void clickIntegrationsTest() throws InterruptedException {
        integrationPage = new IntegrationPage(homePage.clickIntegrations());
        Log.info("Clicked on see all integrations link.");
        ArrayList<String> newTab = new ArrayList<String>(integrationPage.getDriver().getWindowHandles());
        integrationPage.getDriver().switchTo().window(newTab.get(1));
        Log.info("Switched to the newly opened tab");
        Log.info("Switched to a tab where integration link is opened");
        Assert.assertEquals(integrationPage.checkNewTabTitle(), "INTEGRATIONS");
    }
}
