package Tests;
import Tools.PageContainer;

public abstract class BaseTest {
    protected PageContainer pages;

    public BaseTest(){
        pages = new PageContainer();
    }

    protected void precondition() {};
}
