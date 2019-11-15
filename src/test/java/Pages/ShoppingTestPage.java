package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingTestPage extends AbstractTestPage {

    private static final String MAIN_PAGE_URL ="http://automationpractice.com";

    public void openMainPage () {
        driver.navigate().to(MAIN_PAGE_URL);
    }

    public void doSearch(String search) {
        WebElement searchField = driver.findElement(By.id("search_query_top"));
        searchField.sendKeys(search);
        WebElement searchButton = driver.findElement(By.name("submit_search"));
        searchButton.click();
    }

    public void pressList(){
        driver.findElement(By.xpath("//li[@id='list']/a")).click();
    }

    public void addToCard(){
        driver.findElement(By.className("ajax_add_to_cart_button")).click();
        driver.findElement(By.cssSelector("a[title=\"Proceed to checkout\"]")).click();
        driver.findElement(By.id("cart_quantity_up_2_7_0_0")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.textToBePresentInElementValue(By.name("quantity_2_7_0_0"),"2"));
    }


    //total_price_without_tax
//total_tax
    public String getTotalProd() {
        return driver.findElement(By.id("total_product")).getText();
    }

    public String getTotalShipping() {
        return driver.findElement(By.id("total_shipping")).getText();
    }

    public String getPrice() {
        return driver.findElement(By.id("total_price_without_tax")).getText();
    }
    public String getTax() {
        return driver.findElement(By.id("total_tax")).getText();
    }
}
