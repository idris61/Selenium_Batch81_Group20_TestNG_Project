package tests.idris;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IdrisPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class US009_TC02 extends TestBaseRapor {
    @Test
    public void test() throws InterruptedException, IOException {
        extentTest=extentReports.createTest("US009_TC02", "Shipping opsiyonu - Hacim ve ne kadar surede" +
                                                                                  " teslimat yapilacagi belirlenmeli");

        IdrisPage page = new IdrisPage();
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        // Belirtilen URL` ye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.pass("Belirtilen URL` ye gidildi");

        // "Sing in" butonuna tıklanır
        page.signIn.click();
        extentTest.pass("Sing in butonuna tiklandi");

        // "Username or email adress" bölümüne vendor email girilir
        page.username.sendKeys("grup20.testng@gmail.com");
        extentTest.pass("Username or email adress bölümüne vendor email girildi");

        // "Password" bölümüne verdor password girilir
        actions.sendKeys(Keys.TAB).sendKeys("Vendor20.,").perform();
        extentTest.pass("Password bölümüne verdor password girildi");

        // "Sing in" butonuna tıklanır
        page.signIn2.click();
        Driver.getDriver().navigate().refresh();
        extentTest.pass("Sing in butonuna tiklandi");

        // Açılan sayfanın alt kısmında bulunan "My Account" butonuna tıklanır
        jse.executeScript("arguments[0].click();", page.myAccount);
        extentTest.pass("My Account butonuna tiklandi");

        // "Store Manager" butonuna tıklanır
        page.storeManager.click();
        extentTest.pass("Store Manager butonuna tiklandi");

        // "Products" altında bulunan "Add New" butonuna tıklanır
        page.products.click();
        page.productsAddNew.click();
        extentTest.pass("Add New butonuna tiklandi");

        // "Shipping" butonuna tıklanır
        jse.executeScript("arguments[0].click();", page.shipping);
        extentTest.pass("Shipping butonuna tiklandi");

        //"Processing Time" bölümünden teslimat süresi seçilir
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        Select select=new Select(page.ddProcessingTime);
        List<WebElement> ddmList = select.getOptions();
        for (int i = 0; i < ddmList.size(); i++) {
            select.selectByIndex(i);
            Thread.sleep(3000);
        }
        extentTest.pass("Dropdown menüdeki tüm seçeneklere tek tek tiklandi");

        //"Hacim" belirlenir
        List<WebElement> shippingList = page.shippingTamami;
        for (WebElement w: shippingList) {
            System.out.println(w.getText());
            Assert.assertTrue(w.getText().contains("Hacim"));
            extentTest.pass("Hacim menusunun oldugu dogrulandi");
        }

        ReusableMethods.getScreenshot("US009_TC02");
    }
}
