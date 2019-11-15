package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdmiIncommengPage extends AbstractTestPage {
    //LOGIN PAGE + CONVERSATION
    public void AdminMethod(){
    }

    private String loginAdm = "input[placeholder^=Email]";
    private String passAdmin = "input[placeholder^=Pass]";
    private String signIn = "//div[3]/div[2]/button/span[1]";
    private String changeCompany = "//*[@id=\"root\"]/div/div/header/div/div/div[2]/button";
    private String aliceCapital = "li[tabindex=\"0\"]";
    private String firstIncoming = "//div[1]/div/div[2]/ul/div[1]";
    private String chatMessage = "//div[2]/div[1]/p/span"; // выбрать первое сообщение в Chat
    private String valetMessage = "//div/div[2]/div[1]/p"; // выбрать первое сообщение Valet
    private String reservationFormMessage = "//div[2]/div[1]/p";
    private String declineRequestButton = "//div[3]/button[2]/span[1]";

    @FindBy(css = "path[d=\"M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z\"]")
    public WebElement MoreOptionButton;

    @FindBy (xpath = "//*[@id=\"menu-send-actions\"]/div[2]/ul/li[2]/div")
    public WebElement ChangeServiceTypeButton;

    @FindBy (xpath = "//div[2]/div[2]/div/div[2]/div/div/div")
    public WebElement OpenServiceList;

    @FindBy (xpath = "//div[2]/div/div[2]/div[3]/button[1]")
    private WebElement ChangeServiseCancel;

    @FindBy (css = "li[data-value=\"2\"]")
    public WebElement changeToChat;
    @FindBy (css = "li[data-value=\"4\"]")
    public WebElement changeToMaintenance;
    @FindBy (css = "li[data-value=\"3\"]")
    public WebElement changeToValet;
    @FindBy (css = "li[data-value=\"7\"]")
    public WebElement changeToPartyRooms;
    @FindBy (css = "li[data-value=\"5\"]")
    public WebElement changeToEntrant;
    @FindBy (css = "li[data-value=\"8\"]")
    public WebElement changeToTennisCourt;
    @FindBy (css = "li[data-value=\"9\"]")
    public WebElement changeToDelivery;
    @FindBy (css = "li[data-value=\"10\"]")
    public WebElement changeToSPA;
    @FindBy (css = "li[data-value=\"11\"]")
    public WebElement changeToPool;

    @FindBy (xpath = "//body/div[2]/div/div[2]/div[3]/button[2]/span[1]")
    public WebElement assignRequestButton;

    @FindBy (css = "ul > div:nth-child(1) > span> div > h3")
    public WebElement FirstMessageTypeIncoming;

    @FindBy (xpath = "//*[@id=\"menu-\"]/div[2]/ul")
    public WebElement AssignList;

    @FindBy (xpath = "//div/div[2]/div/div[3]/button[1]")
    public WebElement acceptRequestButton;



    public void adminLogin(String login, String password){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div[1]/div/div[3]/div[2]/button")));
        WebElement wLogin = driver.findElement(By.cssSelector(loginAdm));
        wLogin.sendKeys(login);
        WebElement wPass = driver.findElement(By.cssSelector(passAdmin));
        wPass.sendKeys(password);
        driver.findElement(By.xpath(signIn)).click();
    }

    public void selectCompany(){
        driver.findElement(By.xpath(changeCompany)).click();
        driver.findElement(By.cssSelector(aliceCapital)).click();
    }

    public void selectFirstRequest (){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(firstIncoming)));
        driver.findElement(By.xpath(firstIncoming)).click();
    }

    public String getFirstMessage(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(chatMessage)));
        return driver.findElement(By.xpath(chatMessage)).getText();
    }

    public String getCarMessage(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(valetMessage)));
        return driver.findElement(By.xpath(valetMessage)).getText();
    }

    public String getReservationMessage(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(reservationFormMessage)));
        return driver.findElement(By.xpath(reservationFormMessage)).getText();
    }

    public void declineRequest(){
        driver.findElement(By.xpath(declineRequestButton)).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(declineRequestButton)));
    }

    public void changeRequestType (String RequestName) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(MoreOptionButton));
        MoreOptionButton.click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(ChangeServiceTypeButton));
        ChangeServiceTypeButton.click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(ChangeServiseCancel));
        Sleep();
        safeAlertDissmiss();
        OpenServiceList.click();
        Sleep();
        switch (RequestName) {
            case "Chat": changeToChat.click();
                break;
            case "Maintenance": changeToMaintenance.click();
                break;
            case "Valet": changeToValet.click();
                break;
            case "Party Rooms": changeToPartyRooms.click();
                break;
            case "Entrant authorization": changeToEntrant.click();
                break;
            case "Tennis Court": changeToTennisCourt.click();
                break;
            case "Package Delivery": changeToDelivery.click();
                break;
            case "Spa": changeToSPA.click();
                break;
            case "Pool": changeToPool.click();
                break;
        }
        Sleep();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(assignRequestButton));
        //Sleep();
        assignRequestButton.click();
        Sleep();
    }

    public String GetTypeFirstMessage () {
        Sleep();
       // new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOf((WebElement) By.xpath("//*[@id=\"form-assign-concierge\"]")));
        return FirstMessageTypeIncoming.getText();
    }

    public void AcceptRequest () {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(acceptRequestButton));
        acceptRequestButton.click();
    }

    private void Sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void safeAlertDissmiss() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            // ничего не делаем, алерта итак нет
        }
    }
}

