package tests.naif;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.NaifPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class US003_TC03 extends TestBaseRapor {
    @Test
    public void testTC03() throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());
        NaifPage naifPage=new NaifPage();
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        extentTest=extentReports.createTest("Sepete ve ordan checkout a gidilmeli");

        //Belirt,len Url'gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Belirtilen URL'ye gidldi");
        //"Sign" butonuna tıklanır
        naifPage.sign.click();
        extentTest.info("Sign butonuna tıklandı");
        //"Username or email adress" bölümüne vendor email girilir
        naifPage.username.sendKeys(ConfigReader.getProperty("alloverValidEmail"));
        extentTest.info("Adress bolumuna vendor email girildi");
        //"Password" bölümüne verdor password girilir
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("alloverValidPassword")).sendKeys(Keys.ENTER).perform();
        extentTest.info("Passwor bolumune vendor password girildi");
        //"Sign" butonuna tıklanır
        naifPage.sign2.click();
        extentTest.info("Sign butonuna tıklandı");
        //"My orders" butonuna tıklanır
        jse.executeScript("arguments[0].click();", naifPage.myOrders);
        extentTest.info("My orders butonuna tıklandı");
        //"Go Shop" butonuna tıklanır
        jse.executeScript("arguments[0].click();", naifPage.goshop);
        extentTest.info("Go shop butonuna tıklandı");
        //5 adet ürün secilir
        jse.executeScript("arguments[0].click();", naifPage.basket);
        Thread.sleep(2000);
        jse.executeScript("arguments[0].click();", naifPage.triko);
        Thread.sleep(2000);
        jse.executeScript("arguments[0].click();", naifPage.canta);
        Thread.sleep(2000);
        jse.executeScript("arguments[0].click();", naifPage.crusher);
        Thread.sleep(2000);
        jse.executeScript("arguments[0].click();", naifPage.tarhana);
        extentTest.pass("5 Ürün secildi ve sepete eklendi");
        //"Cart" butonuna tıklanır
        naifPage.cart.click();
        //"Checkout"butonuna tıklanır
        naifPage.checkout.click();


    }
}


