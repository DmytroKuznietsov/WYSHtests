package Tools;

import Pages.AdmiIncommengPage;
import Pages.AdminConversationsPage;
import Pages.ClientLoginPage;

public class PageContainer {
    private static final String PATH_TO_CHROMEDRIVER = "C:\\chromedriver_win32\\chromedriver.exe";

    private AdmiIncommengPage testPageAdm;
    private ClientLoginPage testPageClnt;
    private AdminConversationsPage testPageAdmConv;

    public PageContainer(){
        System.setProperty("webdriver.chrome.driver", PATH_TO_CHROMEDRIVER);
    }

    public AdmiIncommengPage getTestPageAdm(){
        if(testPageAdm == null)
            return testPageAdm = new AdmiIncommengPage();
        else
            return  testPageAdm;
    }

    public ClientLoginPage getTestPageClnt(){
        if(testPageClnt == null)
            return testPageClnt = new ClientLoginPage();
        else
            return  testPageClnt;
    }

    public AdminConversationsPage getTestPageAdmConv(){
        if(testPageAdmConv == null)
            return testPageAdmConv = new AdminConversationsPage(getTestPageAdm());
        else
            return  testPageAdmConv;
    }

    public void CloseAll (){
        if(testPageAdm != null) {
            testPageAdm.Close();
            testPageAdm= null;
        }
        if(testPageClnt != null) {
            testPageClnt.Close();
            testPageClnt = null;
        }
//        if(testPageAdmConv != null) {
//            testPageAdmConv.Close();
//            testPageAdmConv = null;
//        }
    }
}
