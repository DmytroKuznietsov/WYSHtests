import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ClientLoginPage extends AbstractTestPage {


    private Object randomDateMethod;

    public void ClientMethod(){

    }
    private String loginIn = "input[placeholder^=Email]";
    private String passIn = "input[placeholder^=Pass]";
    private String signIn = "div:nth-child(3) > div.jss169 > button";
    private String requestButton = "div:nth-child(2) > button";
    private String chatRequest = "button[data-index=\"0\"]";
    private String textField = "input[type=text]";
    private String sendButton = "//div[3]/div/button/span[1]";
    private String valetRequest = "button[data-index=\"2\"]";
    private String valetTextCar = "//*[@id=\"integration-downshift\"]";
    private String valetGuest = "//div[2]/div/div/div/input";
    private String guestListSelect = "//*[@id=\"downshift-0-item-0\"]";
    private String sendValetRequest = "//div[2]/div/div/div/div[1]/div/div/button/span[1]";
    private String waitMessage = "//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[1]";  // Ждем пока наше сообщение прогрузиться на клиенте
    private String entrantRequest = "button[data-index=\"4\"]";
    private String waitChatVisibility = "div[style=\"display: flex; align-items: baseline;\"]";
    private String entrantName = "//div[1]/div/div/div/input";
    private String entrantDateFrom = "//div[2]/div/div/div/input";
    private String entrantDateTo = "//div[3]/div/div/div/input";
    private String entrantDetails = "//div[4]/div/div/div/input";
    private String entrantFindButton ="//div[2]/div/div/div/div[1]/div/div/button";
    private String poolRequest = "button[data-index=\"8\"]";
    private String partyRoomRequest = "button[data-index=\"3\"]";
    private String tennisRequest = "button[data-index=\"5\"]";
    private String spaRequest = "button[data-index=\"7\"]";
    private String reservationDateFrom = "//div[1]/div/div/div/input";
    private String reservationDateTo = "//div[2]/div/div/div/input";
    private String participaints = "//div[3]/div/div/div/input";
    private String reservationFindButt = "//div[2]/div/div/div/div[1]/div/div/button/span[1]";
    private String reservationWaitMessage ="//div/div[3]/div/div/div[1]/p/span[1]";




    public void loginClnt(String login, String password) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/div/div/div[3]/div[2]/button")));
        WebElement wLogin = driver.findElement(By.cssSelector(loginIn));
        wLogin.sendKeys(login);
        WebElement wPass = driver.findElement(By.cssSelector(passIn));
        wPass.sendKeys(password);
        driver.findElement(By.cssSelector(signIn)).click();
    }

    public void requestMenu(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/ul/div[1]/div[1]/h3")));
        driver.findElement(By.cssSelector(requestButton)).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-index=\"0\"]")));
    }

    public void chatRequest(){
        driver.findElement(By.cssSelector(chatRequest)).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[style=\"display: flex; align-items: baseline;\"]")));
        WebElement Text = driver.findElement(By.cssSelector(textField));
        Text.sendKeys( "Hey. Could you give a list of Internet providers from our house?");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(sendButton)));
        driver.findElement(By.xpath(sendButton)).click();
    }

    public void valetRequest(String value)  {
        driver.findElement(By.cssSelector(valetRequest)).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[style=\"display: flex; align-items: baseline;\"]")));
        WebElement Text = driver.findElement(By.xpath(valetTextCar));
        Text.sendKeys(value);
        if (value=="Guest") {
            Text.click();
            new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/div[2]/div/div/div/input")));
            driver.findElement(By.xpath(guestListSelect)).click();

           // new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/div[2]/div/div/div/input")));
            //driver.findElement(By.xpath("div[style=\"display: flex; align-items: baseline;\"]")).click();
            driver.findElement(By.xpath(valetGuest)).sendKeys("AA6325");

        }
        driver.findElement(By.xpath(sendValetRequest)).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(waitMessage)));
    }

    public void entrantRequest(String name, LocalDate DateFromTo, String Details) {
    driver.findElement(By.cssSelector(entrantRequest)).click();
    new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(waitChatVisibility)));
    driver.findElement (By.xpath(entrantName)).sendKeys(name);
    String randomDate = DateFromTo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    driver.findElement (By.xpath(entrantDateFrom)).sendKeys(randomDate,Keys.ARROW_RIGHT + "15-00");
    driver.findElement (By.xpath(entrantDateTo)).sendKeys(randomDate,Keys.ARROW_RIGHT + "16-00");
    driver.findElement (By.xpath(entrantDetails)).sendKeys(Details);
    driver.findElement(By.xpath(entrantFindButton)).click();
    new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(waitMessage)));
    }

    public void poloRequest (LocalDate DateFromTo, String Participants){
        driver.findElement(By.cssSelector(poolRequest)).click();
        reservationsFormSet(DateFromTo, Participants);
    }
    public void partyRoomRequest (LocalDate DateFromTo, String Participants){
        driver.findElement(By.cssSelector(partyRoomRequest)).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(waitChatVisibility)));
        reservationsFormSet(DateFromTo, Participants);
    }
    public void spaRequest (LocalDate DateFromTo, String Participants){
        driver.findElement(By.cssSelector(spaRequest)).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(waitChatVisibility)));
        reservationsFormSet(DateFromTo, Participants);
    }
    public void tennisRequest (LocalDate DateFromTo, String Participants){
        driver.findElement(By.cssSelector(tennisRequest)).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(waitChatVisibility)));
        reservationsFormSet(DateFromTo, Participants);
    }


    private void reservationsFormSet(LocalDate DateFromTo, String Participants) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(waitChatVisibility)));
        String randomDate = DateFromTo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        driver.findElement (By.xpath(reservationDateFrom)).sendKeys(randomDate, Keys.ARROW_RIGHT + "15-00");
        driver.findElement (By.xpath(reservationDateTo)).sendKeys(randomDate,Keys.ARROW_RIGHT + "16-00");
        driver.findElement (By.xpath(participaints)).click();
        driver.findElement (By.xpath(participaints)).sendKeys(Keys.BACK_SPACE, Participants);
        driver.findElement(By.xpath(reservationFindButt)).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(reservationWaitMessage)));
    }






    private void Sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
