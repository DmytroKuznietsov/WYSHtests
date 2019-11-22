package Tests.Admin.Incoming;

import Tests.Admin.adminTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class incomingCHAT extends adminTest {

    String textMessage = "";

    @Override
    protected void precondition(){
        super.precondition();
        pages.getTestPageClnt().chatRequest("Hey. Could you give a list of Internet providers from our house?");
        pages.getTestPageAdm().selectFirstRequest();
    }

//    @Before
//    public void before(){
//    }

    @Test
    public void chatCreating() {
        super.precondition();
        String actualMessage = pages.getTestPageAdm().getFirstMessage();
        Assert.assertEquals("Hey. Could you give a list of Internet providers from our house?", actualMessage);
    }




    @Test
    public void chatDeclineRequest () {
        super.precondition();
        pages.getTestPageAdm().selectFirstRequest();
        String wrongTime = pages.getTestPageAdm().GetTimeOfFirstMessage();
        pages.getTestPageAdm().selectFirstRequest();
        pages.getTestPageAdm().declineRequest();
        String actualTime = pages.getTestPageAdm().GetTimeOfFirstMessage();
        Assert.assertNotEquals(wrongTime,actualTime);


    }

    @After
    public void tearDown()  {
        pages.CloseAll();
    }
}
