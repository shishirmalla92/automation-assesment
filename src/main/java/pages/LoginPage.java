package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.TestUtils;

public class LoginPage {


    private WebDriver driver;
    private By loginHeader = By.className("login-header");
    private By userName = By.id("EmailOrUsername");
    private By passWord = By.id("passwordInput");
    private By loginButton = By.className("btn-red");
    private By tryForFreeButton = By.linkText("Try for Free");
    private By errorMessage = By.id("statuslbl");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String usernameValue) {
        WebElement usernameElement = driver.findElement(userName);
        usernameElement.clear();
        usernameElement.sendKeys(usernameValue);
    }

    public void enterPassword(String passwordValue) {
        WebElement passwordElement = driver.findElement(passWord);
        passwordElement.clear();
        passwordElement.sendKeys(passwordValue);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void clickTryforFree() {
        WebElement tryForFreeBtnElement = driver.findElement(tryForFreeButton);
        TestUtils.scrollToElement(tryForFreeBtnElement, driver);
        tryForFreeBtnElement.click();
    }

    public String getErrorMessageText() {
        return driver.findElement(errorMessage).getText();
    }
}
