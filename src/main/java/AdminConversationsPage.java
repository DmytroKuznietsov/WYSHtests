import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminConversationsPage extends AbstractTestPage {

    @FindBy(xpath = "//div[1]/div/ul/div[1]/div[2]")
    private WebElement conversationTab;

    @FindBy (xpath = "//div/ul/div[1]/div[2]")
    private WebElement createNewChat;

    @FindBy (xpath = "//div[1]/div/div[2]/ul/div[1]/span[1]/div/h3")
    private WebElement firstChat;

    @FindBy (xpath = "//div[2]/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]")
    private WebElement firstMessage;

    @FindBy (xpath = "//div[3]/div/div[1]/div/div[2]/p[2]")
    private WebElement emailTenant;

    @FindBy (xpath = "//div[3]/div/div[1]/div/div[3]/p[2]")
    private WebElement phoneTenant;

    @FindBy (xpath ="//div[3]/div/div[1]/div/div[4]/p[2]")
    private WebElement unitTenant;

    @FindBy (xpath = "//div[3]/div/div[1]/div/p[1]")
    private WebElement nameTenant;

    public AdminConversationsPage(AbstractTestPage testPage) {
        super(testPage);
    }

    public void OpenConversation () {
        conversationTab.click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(createNewChat));
    }

    public void FirstChatOpening () {
    createNewChat.click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(emailTenant));
    String firstMassege = firstMessage.getText();
    String nameOfTenant = nameTenant.getText();
    String emailOfTenant = emailTenant.getText();
    String phoneOfTenant = phoneTenant.getText();
    String unitNumber = unitTenant.getText();
    }



}
