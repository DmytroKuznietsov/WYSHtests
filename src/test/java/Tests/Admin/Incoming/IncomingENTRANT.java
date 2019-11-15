package Tests.Admin.Incoming;

import Tests.Admin.adminTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IncomingENTRANT extends adminTest {

    String nameRequest = "Kuznietsov Dmytro";
    String detailsRequest = "Details test test test";
    String participaints = "3";

    @Override
    protected void precondition(){
        super.precondition();
    }

    @Test
    public void entrantMessageChek() {
    precondition();
    LocalDate randomDate = newDate();
         pages.getTestPageClnt().entrantRequest(nameRequest, randomDate , detailsRequest);
         pages.getTestPageAdm().selectFirstRequest();
    String firstRequest = pages.getTestPageAdm().getReservationMessage();

    String suffix = getDayOfMonthSuffix(randomDate);
    String dataConvert = randomDate.format(DateTimeFormatter.ofPattern("MMMM d'"+suffix+"' yyyy"));

    String expectedRequest = "Entrant Name: "+nameRequest+"\n" +
            "Period From: " + dataConvert + ", 1:00 pm\n" +
            "Period To: " + dataConvert + ", 2:00 pm\n" +
            "Details: "+detailsRequest;
    Assert.assertEquals(expectedRequest, firstRequest);
    }

    @After
    public void tearDown()  {
        pages.CloseAll();
    }

}
