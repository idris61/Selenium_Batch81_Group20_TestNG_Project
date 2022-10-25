package tests.idris;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
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

public class US014_TC02 extends TestBaseRapor {
    @Test
    public void test() throws InterruptedException, IOException {
        extentTest=extentReports.createTest("US014_TC02", "Maximum spend / maksimum alma miktarı girilmeli");

        IdrisPage page = new IdrisPage();
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        // Belirtilen URL` ye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Belirtilen URL` ye gidildi");

        // "Sing in" butonuna tıklanır
        page.signIn.click();
        extentTest.info("Sing in butonuna tiklandi");

        // "Username or email adress" bölümüne vendor email girilir
        page.username.sendKeys(ConfigReader.getProperty("alloverValidEmail"));
        extentTest.info("Username or email adress bölümüne vendor email girildi");

        // "Password" bölümüne verdor password girilir
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("alloverValidPassword")).perform();
        extentTest.info("Password bölümüne verdor password girildi");

        // "Sing in" butonuna tıklanır
        page.signIn2.click();
        Driver.getDriver().navigate().refresh();
        extentTest.info("Sing in butonuna tiklandi");

        // Açılan sayfanın alt kısmında bulunan "My Account" butonuna tıklanır
        jse.executeScript("arguments[0].click();", page.myAccount);
        extentTest.info("My Account butonuna tiklandi");

        // "Store Manager" butonuna tıklanır
        page.storeManager.click();
        extentTest.info("Store Manager butonuna tiklandi");

        // "Coupons" altında bulunan "Add New" butonuna tıklanır
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        jse.executeScript("arguments[0].click();", page.coupons);
        page.couponsAddNew.click();
        extentTest.info("Add New butonuna tiklandi");

        // "Maximum spend" bolümüne tıklanarak değer girilir
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();

        Assert.assertTrue(page.maximumSpend.isEnabled());
        extentTest.info("Maximum spend bölümünün erisilebilir oldugu dogrulandı");

        page.maximumSpend.sendKeys("5000");
        extentTest.pass("Maximum spend bolümüne değer girildi");
        Thread.sleep(1000);

        ReusableMethods.getScreenshot("US014_TC02");
    }
}



