package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.TestUtils;

public class HomePage {
    private WebDriver driver;
    private By loginButton = By.id("cin7Login");
    private By youtubeLink = By.className("video-popup");
    private By integrationLink = By.linkText("See all integrations");
    private By lapsisHeader = By.className("lapis-header");
    private By chatBotLink = By.className("intercom-lightweight-app-launcher-icon-open");
    private By acceptCookiesBtn = By.className("cc-btn");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public By getYoutubeLink() {
        return youtubeLink;
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public WebDriver clickVideo() throws InterruptedException {
        WebElement linkElement = driver.findElement(youtubeLink);
        Thread.sleep(1000);
        TestUtils.waitForElement(linkElement, driver, 15);
        Thread.sleep(1000);
        linkElement.click();
        Thread.sleep(2000);
        return driver;
    }

    public WebDriver clickIntegrations() throws InterruptedException {
        WebElement linkElement = driver.findElement(integrationLink);
        TestUtils.scrollToElement(driver.findElement(lapsisHeader), driver);
        TestUtils.waitForElement(linkElement, driver, 15);
        Thread.sleep(1000);
        linkElement.click();
        Thread.sleep(2000);
        return driver;
    }

    public WebDriver clickChatBot() {
        driver.findElement(chatBotLink).click();
        return driver;
    }

    public void closeChatBot() {
        clickChatBot();
    }

    public void acceptCookies() {
        driver.findElement(acceptCookiesBtn).click();
    }
}
