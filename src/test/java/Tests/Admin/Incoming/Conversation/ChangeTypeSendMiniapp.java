package Tests.Admin.Incoming.Conversation;

import Tests.Admin.Incoming.IncomingChangeServiceType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;




@RunWith(Parameterized.class)
public class ChangeTypeSendMiniapp extends IncomingChangeServiceType {

    public String sendMiniup = "Send Miniapp";
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
    String sendTipForm = "Send tip form";


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Chat"}, {"Maintenance"}, { "Party Rooms"}, {"Entrant authorization" }, { "Tennis Court"}, { "Package Delivery"}, {"Spa" }
        });
    }

    public ChangeTypeSendMiniapp(String services) {
        super(services);
    }

    @Override
    protected void precondition(){
        super.precondition();
    }

    @Test
    public void CheckMiniappChanges () {
        super.precondition();
        pages.getTestPageAdm().changeRequestType(requests);
        pages.getTestPageAdm().AcceptRequest();
        pages.getTestPageAdmConv().SendForm(sendMiniup);

    }


}
