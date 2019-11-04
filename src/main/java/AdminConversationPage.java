import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminConversationPage extends AbstractTestPage {
    //LOGIN PAGE + CONVERSATION
    public void AdminMethod(){
    }

    private String loginAdm = "input[placeholder^=Email]";
    private String passAdmin = "input[placeholder^=Pass]";
    private String signIn = "//div[3]/div[2]/button/span[1]";
    private String changeCompany = "//*[@id=\"root\"]/div/div/header/div/div/div[2]/button";
    private String aliceCapital = "li[tabindex=\"0\"]";
    private String firstConversation = "//div[1]/div/div[2]/ul/div[1]";
    private String chatMessage = "//div[2]/div[1]/p/span"; // выбрать первое сообщение в Chat
    private String valetMessage = "//div/div[2]/div[1]/p"; // выбрать первое сообщение Valet
    private String reservationFormMessage = "//div[2]/div[1]/p";


    public void adminLogin(String login, String password){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.jss24 > button > span.jss51")));
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
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(firstConversation)));
        driver.findElement(By.xpath(firstConversation)).click();
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
}
