package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AdminConversationsPage extends AbstractTestPage {

    @FindBy(xpath = "//div[1]/div/ul/div[1]/div[2]")
    private WebElement conversationTab;

    @FindBy (xpath = "//div/div/div/div[2]/div/button/span[1]")
    private WebElement createNewChat; //no id button

    @FindBy (css = "#conversations-chat-item-0")
    private WebElement firstChat;

    @FindBy (xpath = "//div/div/div/div[2]/div/div[1]/div/div[2]/ul/div[1]")
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

    @FindBy (css = "#chat-box-add-button")
    private WebElement plusButton;

    @FindBy (css = "#send-miniapp-action")
    private WebElement sendMiniapp;

    @FindBy (css = "#send-tip-action")
    private WebElement sendTipForm;
    @FindBy (css = "//*[@id=\"menu-send-actions\"]/div[2]/ul/li[1]/div")
    private WebElement paymentFormSent;
    @FindBy (xpath = "//div/div[2]/div/div/div[2]/div/div[5]/div/div[2]/p")
    private WebElement PeymentFormWait;

    @FindBy (css = "#conversations-menu-item")
    private WebElement tabConversation;

    @FindBy (xpath = "//div[2]/div[2]/div/div[1]/div/div[2]/div/div")
    private WebElement createChatTypeList;
    @FindBy (css = "li[data-value=\"2\"]")
    private WebElement selectChatCreating;
    @FindBy (css = "li[data-value=\"9\"]")
    private WebElement selectPackDelCreating;
    @FindBy (css = "#integration-downshift")
    private WebElement tenantInputField;
    @FindBy (css = "//div[3]/div/div[2]/div[3]/div/button[2]/span[1]")
    private WebElement createButton;

    @FindBy (css = "input[style=\"text-indent: 10px;\"]")
    private WebElement textInput;
    @FindBy (css = "div:nth-child(6) > div > div:nth-child(2) > p")
    private WebElement tipFormFinishText;

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

    public String FindTextRequest () {
        //new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(tipFormFinishText));
        return tipFormFinishText.getText();
    }

    public void SendForm (String value) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(unitTenant));
        plusButton.click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(sendMiniapp));
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(sendTipForm));
        //Sleep();
        switch (value) {
            case "Send Miniapp":
                sendMiniapp.click();
               // Sleep();
                break;
            case "Send tip form":
                sendTipForm.click();
                //Sleep();
                break;
        }
    }



    public void CreateChat (String tenant, String chatOrPackDelivery){
        tabConversation.click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(createNewChat));
        createNewChat.click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(createChatTypeList));
        createChatTypeList.click();
        switch (chatOrPackDelivery) {
            case "Package Delivery":
                selectPackDelCreating.click();
                // Sleep();
                break;
            case "Chat":
                selectChatCreating.click();
                //Sleep();
                break;
        }
        Sleep();
        tenantInputField.sendKeys(tenant, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB, Keys.TAB, Keys.ENTER);
//        Sleep();
//        createButton.click();
    }

    public void SendNewMessage (String message) {
        textInput.sendKeys(message, Keys.TAB, Keys.ENTER);
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
