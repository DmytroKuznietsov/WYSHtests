package Tests.Admin.Incoming;

import Tests.Admin.adminTest;
import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.annotation.Aspect;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;


public class ConversationFunctions extends adminTest {

    String packageDelivery ="Package Delivery";
    String chat = "Chat";
    String tenantName = "Trent Reznor";
    String expectMailTenant = "trentreznor@net3mail.com";
    String expectPhoneTenant = "+30934854433";
    String expectUnitTenant = "432";
    String expectNameTenant = "Trent Reznor";
    String expectRequestMessage = "A notification about your request has been sent to concierges";
    String messageToTenant = "Hi, did you accidentally lose red gloves?";


    @Override
    protected void precondition() {
        super.precondition();
    }

    @Test
//    @DisplayName("Human-readable test name")
//    @Epic("123123")
//    @AdviceName("4324")
    public void CreateNewChatVsTenant () {
        super.precondition();
        pages.getTestPageAdmConv().CreateChat(tenantName,chat);

        String actualName = pages.getTestPageAdmConv().GetName();
        String actualMail = pages.getTestPageAdmConv().GetMail();
        String actualPhone = pages.getTestPageAdmConv().GetPhone();
        String actualUnit= pages.getTestPageAdmConv().GetUnit();

        Assert.assertEquals(expectMailTenant,actualMail);
        Assert.assertEquals(expectPhoneTenant,actualPhone);
        Assert.assertEquals(expectNameTenant,actualName);
        Assert.assertEquals(expectUnitTenant,actualUnit);

        pages.getTestPageAdmConv().SendNewMessage(messageToTenant);
        String actualTextValue =pages.getTestPageClnt().GetFirstMessageClnt();
        Assert.assertEquals(messageToTenant,actualTextValue);

    }

    @Test
    public void CreateNewPackDelVsTenant () {
        super.precondition();
        pages.getTestPageAdmConv().CreateChat(tenantName,packageDelivery);

        String actualName = pages.getTestPageAdmConv().GetName();
        String actualMail = pages.getTestPageAdmConv().GetMail();
        String actualPhone = pages.getTestPageAdmConv().GetPhone();
        String actualUnit= pages.getTestPageAdmConv().GetUnit();

        Assert.assertEquals(expectMailTenant,actualMail);
        Assert.assertEquals(expectPhoneTenant,actualPhone);
        Assert.assertEquals(expectNameTenant,actualName);
        Assert.assertEquals(expectUnitTenant,actualUnit);

        pages.getTestPageAdmConv().SendNewMessage(messageToTenant);
        String actualTextValue =pages.getTestPageClnt().GetFirstMessageClnt();
        Assert.assertEquals(messageToTenant,actualTextValue);

    }

    @Test
    public void DeclineRequestConversation () {
        super.precondition();

    }


    @After
    public void tearDown()  {
        pages.CloseAll();
    }
}
