import org.testng.Assert;
import org.testng.annotations.Test;
import pages.YouTubePage;
import utils.Log;
import utils.TestUtils;

public class VideoPlayTest extends BaseTest {
    private YouTubePage youtubePage;

    @Test
    public void videoPlayTest() throws InterruptedException {

        youtubePage = new YouTubePage(homePage.clickVideo());
        Log.info("Clicked on Watch Video button");
        homePage.getDriver().switchTo().frame(5);
        Log.info("Switched to video frame");
        youtubePage.clickPlay();
        Log.info("Started to play video");
        Assert.assertFalse(TestUtils.isElementPresent(homePage.getYoutubeLink(), homePage.getDriver()));
        while (TestUtils.getCurrentSecond(youtubePage.getCurrentTime()) < 10) {
            //do nothing and wait for the player to run for 10 secs
        }
        homePage.getDriver().switchTo().defaultContent();
        Log.info("Came out of video frame");
        Assert.assertTrue(TestUtils.isElementPresent(homePage.getYoutubeLink(), homePage.getDriver()));
        youtubePage.clickClose();
        Log.info("Closed the video frame");
    }
}
