package Tests.Admin.Incoming;

import Tests.Admin.adminTest;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class IncomingVALET extends adminTest {

    String chat = "Chat";
    String maintenance = "Maintenance";
    String partyRooms = "Party Rooms";
    String entrantAuthorization = "Entrant authorization";
    String tennisCourt = "Tennis Court";
    String packageDelivery = "Package Delivery";
    String spa = "Spa";
    String pool = "Pool";

    @Override
    protected void precondition() {
        super.precondition();
    }


    @Test
    public void valetGuestCarCreating() {
        precondition();
        pages.getTestPageClnt().valetRequest("Guest");
        pages.getTestPageAdm().selectFirstRequest();
        Assert.assertEquals("Car: Guest\n" + "Ticket Number: AA6325", pages.getTestPageAdm().getCarMessage());
    }

    @Test
    public void valetMyCarCreating() {
        precondition();
        pages.getTestPageClnt().valetRequest("Volkswagen");
        pages.getTestPageAdm().selectFirstRequest();
        Assert.assertEquals("Car: Volkswagen", pages.getTestPageAdm().getCarMessage());
    }

    @Test
    public void valetDeclineRequest() {
        precondition();
        pages.getTestPageClnt().valetRequest("Incorrect Car");
        pages.getTestPageAdm().selectFirstRequest();
        pages.getTestPageAdm().declineRequest();
        pages.getTestPageAdm().selectFirstRequest();
        Assert.assertNotEquals("Car: Incorrect Car", pages.getTestPageAdm().getCarMessage());
    }






        @After
        public void tearDown() {
            pages.CloseAll();
        }

    }
