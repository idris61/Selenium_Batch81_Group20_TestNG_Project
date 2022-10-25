package tests.naif;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.NaifPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class US003_TC03 {
    @Test
    public void testTC03() throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());
        NaifPage naifPage = new NaifPage();
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        //Belirt,len Url'gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        //"Sign" butonuna tıklanır
        naifPage.sign.click();
        //"Username or email adress" bölümüne vendor email girilir
        naifPage.username.sendKeys(ConfigReader.getProperty("vendorEmail"));
        //"Password" bölümüne verdor password girilir
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("vendorPassword")).sendKeys(Keys.ENTER).perform();
        //"Sign" butonuna tıklanır
        naifPage.sign2.click();
        //"My orders" butonuna tıklanır
        jse.executeScript("arguments[0].click();", naifPage.myOrders);
        //"Go Shop" butonuna tıklanır
        jse.executeScript("arguments[0].click();", naifPage.goshop);
        Thread.sleep(3000);
        //5 adet ürün secilir
        jse.executeScript("arguments[0].click();", naifPage.basket);
        jse.executeScript("arguments[0].click();", naifPage.triko);
        jse.executeScript("arguments[0].click();", naifPage.canta);
        jse.executeScript("arguments[0].click();", naifPage.crusher);
        jse.executeScript("arguments[0].click();", naifPage.tarhana);
        Thread.sleep(2000);
        //"Cart" butonuna tıklanır
        naifPage.cart.click();
        //"Checkout"butonuna tıklanır
        naifPage.checkout.click();


    }
}


