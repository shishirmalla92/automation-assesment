import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoPage;
import pages.LoginPage;
import utils.Log;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private DemoPage demoPage;

    @Test(priority = 0)
    public void testLogin() {
        homePage.clickLogin();
        WebDriverWait wait = new WebDriverWait(homePage.getDriver(), 30);
        WebElement loginHeader = homePage.getDriver().findElement(By.className("login-header"));
        wait.until(ExpectedConditions.visibilityOf(loginHeader));
        Log.info("Checking title of the navigated page.");
        Assert.assertEquals(homePage.getDriver().getTitle(), "Cin7 - Login");
        LoginPage loginPage = new LoginPage(homePage.getDriver());
        loginPage.enterUsername("Shishir");
        Log.info("Entered username.");
        loginPage.enterPassword("Password@123");
        Log.info("Entered password.");
        loginPage.clickLogin();
        Log.info("Clicked login.");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Username and password combination is invalid.");
        Log.info("Got invalid login error message");
        loginPage.clickTryforFree();
        Log.info("Clicked try for free button.");
        Assert.assertEquals(homePage.getDriver().getTitle(), "Free Demo | Cin7 Inventory Management Software and POS System");
        Log.info("Checked the title of the current page.");
    }

    @Test(priority = 1)
    public void requestDemo() throws InterruptedException {
        WebDriver driver = homePage.getDriver();
        loginPage = new LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement demoHeader = driver.findElement(By.className("form-des"));
        wait.until(ExpectedConditions.visibilityOf(demoHeader));
        Log.info("Waited till the visibility of Request demo text.");
        Assert.assertEquals(driver.getTitle(), "Free Demo | Cin7 Inventory Management Software and POS System");
        Log.info("Checked the title of the current page.");
        demoPage = new DemoPage(driver);
        Integer size = driver.findElements(By.tagName("iframe")).size();
        driver.switchTo().frame(0);
        Log.info("Switched to the Request Demo form.");
        demoPage.enterFirstName("Test First Name");
        Log.info("Entered first name");
        demoPage.enterLastName("Test Last Name");
        Log.info("Entered last name");
        demoPage.enterBusinessEmail("testemail@email.com");
        Log.info("Entered email");
        demoPage.enterCompany("Test Company");
        Log.info("Entered company");
        demoPage.enterPhone("+64 0011223344");
        Log.info("Entered phone");
        demoPage.selectCountry("New Zealand");
        Log.info("Selected country from dropdown");
        demoPage.selectChannels(3);
        Log.info("Selected channel from dropdown.");
        demoPage.selectNumberOfResources(2);
        Log.info("Selected number of resources from dropdown");
        demoPage.clickDemoBtn();
        Log.info("Clicked Request for demo button");
        Assert.assertEquals(driver.getTitle(), "Free Demo | Cin7 Inventory Management Software and POS System");
    }
}