package Tests.Admin.Incoming.Conversation;

import Tests.Admin.Incoming.incomingCHAT;
import org.junit.Assert;
import org.junit.Test;

public class ConversationCHAT extends incomingCHAT {

    String expectMailTenant = "trentreznor@net3mail.com";
    String expectPhoneTenant = "+30934854431";
    String expectUnitTenant = "432";
    String expectNameTenant = "Trent Reznor";
    String expectRequestMessage = "A notification about your request has been sent to concierges";
    String catdNumber = "378282246310005";
    String cardName = "Trent Reznor";
    String catdValidDate = "1220";
    String cvcCard = "186";
    String tipsMoney = "15"; //$$$


    @Override
    protected void precondition(){
        super.precondition();
    }

    @Test
    public void AcceptRequestConvOpen(){
        super.precondition();
        pages.getTestPageAdm().AcceptRequest();
        String actualRequest = pages.getTestPageAdmConv().GetFirstSystemMessage();
        String actualName = pages.getTestPageAdmConv().GetName();
        String actualMail = pages.getTestPageAdmConv().GetMail();
        String actualPhone = pages.getTestPageAdmConv().GetPhone();
        String actualUnit= pages.getTestPageAdmConv().GetUnit();


        Assert.assertEquals(expectRequestMessage,actualRequest);
        Assert.assertEquals(expectMailTenant,actualMail);
        Assert.assertEquals(expectPhoneTenant,actualPhone);
        Assert.assertEquals(expectNameTenant,actualName);
        Assert.assertEquals(expectUnitTenant,actualUnit);
    }

    @Test // удалить
    public void ChatTipForm () {
        super.precondition();
        pages.getTestPageAdm().AcceptRequest();
        pages.getTestPageAdmConv().SendForm("Send tip form");
        pages.getTestPageClnt().setTips(tipsMoney);

        pages.getTestPageClnt().PayMethod(catdNumber,cardName,catdValidDate, cvcCard);
        String actualRequest = pages.getTestPageAdmConv().FindTextRequest();

        Assert.assertEquals(actualRequest,"The tip was paid succesfully");
}






//    @After
//    public void tearDown()  {
//        pages.CloseAll();
//    }

}
