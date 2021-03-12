package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChatBotPage {
    private WebDriver driver;
    private By messageInputBox = By.tagName("textarea");
    private By sendMessageBtn = By.className("intercom-composer-send-button");
    private By sentMessagePara = By.className("intercom-block-paragraph");

    public ChatBotPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void sendMessage(String message) {
        driver.findElement(messageInputBox).sendKeys(message);
        driver.findElement(sendMessageBtn).click();
    }

    public String getSentMessageValue() {
        return driver.findElement(sentMessagePara).getText();
    }
}
