package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IntegrationPage {

    private WebDriver driver;
    private By pageHeaderTitle = By.className("page-header-title");

    public IntegrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String checkNewTabTitle() {
        return driver.findElement(pageHeaderTitle).getText();
    }
}
