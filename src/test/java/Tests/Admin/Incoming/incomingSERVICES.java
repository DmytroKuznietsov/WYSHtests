package Tests.Admin.Incoming;

import Tests.Admin.adminTest;
import org.junit.Assert;
import org.junit.Test;

public class incomingSERVICES extends adminTest {

    @Override
    protected void precondition(){
        super.precondition();
    }

    @Test
    public void Test1() {
        super.precondition();
        String actualMessage = pages.getTestPageAdm().getFirstMessage();
        Assert.assertEquals("Hey. Could you give a list of Internet providers from our house?", actualMessage);
    }
}
