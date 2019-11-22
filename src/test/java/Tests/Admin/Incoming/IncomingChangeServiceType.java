package Tests.Admin.Incoming;

import Tests.Admin.adminTest;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;


    @RunWith(Parameterized.class)
    public class IncomingChangeServiceType extends adminTest {

        String nameRequest = "Kuznietsov Dmytro";
        String detailsRequest = "Details test test test";
        String participaints = "3";
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

        @Override
        protected void precondition () {
            super.precondition();

            switch (requests) {
                case "Chat":
                    pages.getTestPageClnt().chatRequest("СhatTo" + requests + " Type convert");
                    break;
                case "Valet":
                    pages.getTestPageClnt().valetRequest("ValetTo" +requests + " Type convert");
                    break;
                case "Entrant authorization":
                    LocalDate randomDate = newDate();
                    pages.getTestPageClnt().entrantRequest(nameRequest, randomDate , detailsRequest);
                    break;
                case "Pool":
                    LocalDate poolDate = newDate();
                    pages.getTestPageClnt().poloRequest(poolDate , participaints);
                    break;
                case "Party Room":
                    LocalDate partyRoom = newDate();
                    pages.getTestPageClnt().partyRoomRequest(partyRoom , participaints);
                    break;
                case "Tennis Court":
                    LocalDate tennisCourt = newDate();
                    pages.getTestPageClnt().tennisRequest(tennisCourt , participaints);
                    break;
                case "Spa":
                    LocalDate spaDate = newDate();
                    pages.getTestPageClnt().spaRequest(spaDate , participaints);
                    break;}
                pages.getTestPageAdm().selectFirstRequest();
            //    pages.getTestPageAdm().changeRequestType(requests);
            }


        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                    {"Chat"}, {"Maintenance"}, { "Party Rooms"}, {"Entrant authorization" }, { "Tennis Court"}, { "Package Delivery"}, {"Spa" }
            });
        }
        protected String requests;
        public IncomingChangeServiceType(String services) {
            this.requests = services;
        }
        @Test
        public void ValetToChangeType() {
            super.precondition();
            pages.getTestPageClnt().valetRequest("ValetTo"+requests+" convert");
            pages.getTestPageAdm().selectFirstRequest();
            pages.getTestPageAdm().changeRequestType(requests);
            String actualResult = pages.getTestPageAdm().GetTypeFirstMessage();
            Assert.assertEquals(requests, actualResult);
        }

        @Test
        public void ChatChangeTypeRequest() {
            super.precondition();
            pages.getTestPageClnt().chatRequest("СhatTo"+requests+" Type convert");
            pages.getTestPageAdm().selectFirstRequest();
            pages.getTestPageAdm().changeRequestType(requests);
            String actualResult = pages.getTestPageAdm().GetTypeFirstMessage();
            Assert.assertEquals(requests, actualResult);

        }

        @Test
        public void EntrantChangeTypeRequest() {
            super.precondition();
            LocalDate randomDate = newDate();
            pages.getTestPageClnt().entrantRequest(nameRequest, randomDate, detailsRequest);
            pages.getTestPageAdm().selectFirstRequest();
            pages.getTestPageAdm().changeRequestType(requests);
            String actualResult = pages.getTestPageAdm().GetTypeFirstMessage();
            Assert.assertEquals(requests, actualResult);
        }

        @Test
        public void ServicesChangeTypeRequest() {
            super.precondition();
            LocalDate partyRoom = newDate();
            pages.getTestPageClnt().partyRoomRequest(partyRoom, participaints);
            pages.getTestPageAdm().selectFirstRequest();
            pages.getTestPageAdm().changeRequestType(requests);
            String actualResult = pages.getTestPageAdm().GetTypeFirstMessage();
            Assert.assertEquals(requests, actualResult);
        }

        @Test
        public void SendTipForm () {
            precondition();
            pages.getTestPageAdm().AcceptRequest();
            pages.getTestPageAdmConv().SendForm(sendTipForm);
            pages.getTestPageClnt().setTips(tipsMoney);
            pages.getTestPageClnt().PayMethod(catdNumber,cardName,catdValidDate, cvcCard);
            String actualRequest = pages.getTestPageAdmConv().FindTextRequest();

            Assert.assertEquals(actualRequest,"The tip was paid succesfully");

        }



    @After
    public void tearDown() {
        pages.CloseAll();
    }
    }
