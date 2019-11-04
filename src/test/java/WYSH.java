import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class WYSH {

    private static final String PATH_TO_CHROMEDRIVER = "C:\\chromedriver_win32\\chromedriver.exe";

    private AdminConversationPage testPageAdm;
    private ClientLoginPage testPageClnt;

    String nameRequest = "Kuznietsov Dmytro";
    String detailsRequest = "Details test test test";
    String participaints = "3";



    @Before
    public void setting() {
        System.setProperty("webdriver.chrome.driver", PATH_TO_CHROMEDRIVER);
        // win mac linux

        testPageAdm = new AdminConversationPage();
        testPageAdm.driver.manage().window().maximize();
        testPageClnt = new ClientLoginPage();
        testPageClnt.driver.manage().window().maximize();
    }

    // ↓ ↓ ↓ ↓ ↓ ↓ REQUESTS TESTS START. TAB CONVERSATION  ↓ ↓ ↓ ↓ ↓ ↓
    @Test
    public void Test1() {
        testPageAdm.openPage("https://wysh.console-staging.wysh.ai");
        testPageAdm.adminLogin("concierge@wysh.ai", "Password2017");
        testPageClnt.openPage("https://wysh.console-staging.wysh.ai/widget/login");
        testPageClnt.loginClnt("sukserhiy@gmail.com", "Password2017");
        testPageClnt.requestMenu();
        testPageClnt.chatRequest();
        testPageAdm.selectCompany();
        testPageAdm.selectFirstRequest();
        Assert.assertEquals("Hey. Could you give a list of Internet providers from our house?",testPageAdm.getFirstMessage());
    }

    //PRE to test 2  and test 3
    public void Precondition(){
        testPageAdm.openPage("https://wysh.console-staging.wysh.ai");
        testPageAdm.adminLogin("concierge@wysh.ai", "Password2017");
        testPageClnt.openPage("https://wysh.console-staging.wysh.ai/widget/login");
        testPageClnt.loginClnt("sukserhiy@gmail.com", "Password2017");
        testPageClnt.requestMenu();
        testPageAdm.selectCompany();
    }

    //Guest CAR
    @Test
    public void Test2() {
        Precondition();
        testPageClnt.valetRequest("Guest");
        testPageAdm.selectFirstRequest();
        Assert.assertEquals("Car: Guest\n" + "Ticket Number: AA6325",testPageAdm.getCarMessage());
    }

    //My CAR
    @Test
    public void Test3 (){
        Precondition();
        testPageClnt.valetRequest("Volkswagen");
        testPageAdm.selectFirstRequest();
        Assert.assertEquals("Car: Volkswagen",testPageAdm.getCarMessage());
    }


     @Test
    public void Test4 () {
         Precondition();
         LocalDate randomDate = AbstractTestPage.newDate();
         testPageClnt.entrantRequest(nameRequest, randomDate , detailsRequest);
         testPageAdm.selectFirstRequest();
         String firstRequest = testPageAdm.getReservationMessage();

         String suffix = AbstractTestPage.getDayOfMonthSuffix(randomDate);
         String dataConvert = randomDate.format(DateTimeFormatter.ofPattern("MMMM d'"+suffix+"' yyyy"));

         String expectedRequest = "Entrant Name: "+nameRequest+"\n" +
                 "Period From: " + dataConvert + ", 1:00 pm\n" +
                 "Period To: " + dataConvert + ", 2:00 pm\n" +
                 "Details: "+detailsRequest;

         Assert.assertEquals(expectedRequest, firstRequest);
    }

     @Test
    public void Test5(){
        Precondition();
        LocalDate randomDate = AbstractTestPage.newDate();
        testPageClnt.poloRequest(randomDate, participaints);
        testPageAdm.selectFirstRequest();
        String firstRequest = testPageAdm.getReservationMessage();

         String suffix = AbstractTestPage.getDayOfMonthSuffix(randomDate);
         String dataConvert = randomDate.format(DateTimeFormatter.ofPattern("MMMM d'"+suffix+"' yyyy"));

        String expectedResult = "Start Date: "+ dataConvert + ", 1:00 pm\n" +
                "End Date: "+ dataConvert + ", 2:00 pm\n" +
                "Participants: "+participaints;
         Assert.assertEquals(expectedResult, firstRequest);
     }

    @Test
    public void Test6(){
        Precondition();
        LocalDate randomDate = AbstractTestPage.newDate();
        testPageClnt.partyRoomRequest(randomDate, participaints);
        testPageAdm.selectFirstRequest();
        String firstRequest = testPageAdm.getReservationMessage();

        String suffix = AbstractTestPage.getDayOfMonthSuffix(randomDate);
        String dataConvert = randomDate.format(DateTimeFormatter.ofPattern("MMMM d'"+suffix+"' yyyy"));

        String expectedResult = "Start Date: "+ dataConvert + ", 1:00 pm\n" +
                "End Date: "+ dataConvert + ", 2:00 pm\n" +
                "Participants: "+participaints;
        Assert.assertEquals(expectedResult, firstRequest);
    }

    @Test
    public void Test7(){
        Precondition();
        LocalDate randomDate = AbstractTestPage.newDate();
        testPageClnt.spaRequest(randomDate, participaints);
        testPageAdm.selectFirstRequest();
        String firstRequest = testPageAdm.getReservationMessage();

        String suffix = AbstractTestPage.getDayOfMonthSuffix(randomDate);
        String dataConvert = randomDate.format(DateTimeFormatter.ofPattern("MMMM d'"+suffix+"' yyyy"));

        String expectedResult = "Start Date: "+ dataConvert + ", 1:00 pm\n" +
                "End Date: "+ dataConvert + ", 2:00 pm\n" +
                "Participants: "+participaints;
        Assert.assertEquals(expectedResult, firstRequest);
    }

    @Test
    public void Test8(){
        Precondition();
        LocalDate randomDate = AbstractTestPage.newDate();
        testPageClnt.tennisRequest(randomDate, participaints);
        testPageAdm.selectFirstRequest();
        String firstRequest = testPageAdm.getReservationMessage();

        String suffix = AbstractTestPage.getDayOfMonthSuffix(randomDate);
        String dataConvert = randomDate.format(DateTimeFormatter.ofPattern("MMMM d'"+suffix+"' yyyy"));

        String expectedResult = "Start Date: "+ dataConvert + ", 1:00 pm\n" +
                "End Date: "+ dataConvert + ", 2:00 pm\n" +
                "Participants: "+participaints;
        Assert.assertEquals(expectedResult, firstRequest);



    }
    //  ↑ ↑ ↑ ↑ ↑ REQUESTS TESTS ARE FINISH. TAB CONVERSATION  ↑ ↑ ↑ ↑ ↑ ↑



    @After
    public void tearDown()  {
        testPageAdm.driver.manage().deleteAllCookies();
        testPageClnt.driver.manage().deleteAllCookies();
        testPageClnt.driver.quit();
        testPageAdm.driver.quit();
    }
}
