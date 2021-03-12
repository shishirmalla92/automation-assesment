import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ChatBotPage;
import utils.Log;

public class ChatBotTest extends BaseTest {
    private ChatBotPage chatBotPage;

    @Test
    public void testChatBot() throws InterruptedException {
        Thread.sleep(2000);
        chatBotPage = new ChatBotPage(homePage.clickChatBot());
        Log.info("Clicked on Chatbot icon");
        Thread.sleep(2000);
        chatBotPage.getDriver().switchTo().frame("intercom-messenger-frame");
        Log.info("Moved the focus onto the Chat bot modal");
        chatBotPage.sendMessage("Hi, this is automated test message.");
        Log.info("Sent a message.");
        Assert.assertEquals(chatBotPage.getSentMessageValue(), "Hi, this is automated test message.");

    }
}
