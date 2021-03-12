import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import utils.Log;

public class BaseTest {

    protected HomePage homePage;
    private WebDriver driver;
    private String baseURL = "https://www.cin7.com/";

    @BeforeTest
    public void initializeTest() {
        //setting the value of chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        DOMConfigurator.configure("log4j.xml");
        Log.info("Opened cin7 website and maximized window");
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        Log.info("Accepted cookies");
    }

    @AfterTest
    public void stopTest() {
        Log.info("Driver closed now.");
        driver.quit();
    }
}
