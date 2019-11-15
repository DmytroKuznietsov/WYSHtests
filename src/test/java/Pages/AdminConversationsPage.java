package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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

    @FindBy (xpath = "//div[2]/div/div/div[2]/div/div/div/div[2]/p")
    private  WebElement systemMessage;

    @FindBy (css = "div > div:nth-child(1) > button path[d=\"M19 13h-6v6h-2v-6H5v-2h6V5h2v6h6v2z\"]")
    private WebElement plusButton;

    @FindBy (css = "ul > li:nth-child(1) > div")
    private WebElement sendMiniapp;

    @FindBy (css = "#menu-send-actions ul > li:nth-child(2) > div")
    private WebElement sendTipForm;
    @FindBy (css = "//*[@id=\"menu-send-actions\"]/div[2]/ul/li[1]/div")
    private WebElement paymentFormSent;


    public AdminConversationsPage(AbstractTestPage testPage) {
        super(testPage);
    }


    public String GetFirstSystemMessage () {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(systemMessage));
        return systemMessage.getText();
    }

    public String GetMail () {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(emailTenant));
        return emailTenant.getText();
    }

    public String GetPhone () {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(phoneTenant));
        return phoneTenant.getText();
    }

    public String GetName () {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(nameTenant));
        return nameTenant.getText();
    }

    public String GetUnit () {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(unitTenant));
        return unitTenant.getText();
    }
    public String FindTextRequest(String cssSelector) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(cssSelector)));
        return driver.findElement(By.cssSelector(cssSelector)).getText();
    }


    public void SendForm (String value) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(unitTenant));
        plusButton.click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(sendMiniapp));
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(sendTipForm));
        Sleep();
        switch (value) {
            case "Send Miniapp":
                sendMiniapp.click();
                Sleep();
                break;
            case "Send tip form":
                sendTipForm.click();
                Sleep();
                break;
        }
    }


//    public void OpenConversation () {
//        conversationTab.click();
//        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(createNewChat));
//    }

//    public void FirstChatOpening () {
//    createNewChat.click();
//        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(emailTenant));
//    String firstMessege = firstMessage.getText;
//    String nameOfTenant = nameTenant.getText();
//    String emailOfTenant = emailTenant.getText();
//    String phoneOfTenant = phoneTenant.getText();
//    String unitNumber = unitTenant.getText();
//    }
//

    private void Sleep() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
