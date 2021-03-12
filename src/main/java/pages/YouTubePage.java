package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YouTubePage {
    private WebDriver driver;
    private By playButton = By.className("ytp-play-button");
    private By closeButton = By.className("lity-close");
    private By currentTime = By.className("ytp-time-current");
    public YouTubePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPlay() {
        driver.findElement(playButton).click();
    }

    public void clickClose() {
        driver.findElement(closeButton).click();
    }

    public String getCurrentTime() {
        return driver.findElement(currentTime).getText();
    }

}
