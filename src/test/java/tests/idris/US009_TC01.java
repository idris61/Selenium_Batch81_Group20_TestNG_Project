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

public class US009_TC01 extends TestBaseRapor {
    @Test
    public void test() throws InterruptedException, IOException {
        extentTest=extentReports.createTest("US009_TC01", "Shipping opsiyonu - Kilo ve boyut belirlenmeli");

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

        // "Products" altında bulunan "Add New" butonuna tıklanır
        page.products.click();
        page.productsAddNew.click();
        extentTest.info("Add New butonuna tiklandi");

        // "Shipping" butonuna tıklanır
        jse.executeScript("arguments[0].click();", page.shipping);
        extentTest.info("Shipping butonuna tiklandi");

        Assert.assertTrue(page.shippingWeight.isEnabled());
        extentTest.info("Weight bölümü erisilebilir oldugu dogrulandı");

        Assert.assertTrue(page.dimensionsLength.isEnabled());
        extentTest.info("Length bölümü erisilebilir oldugu dogrulandı");

        Assert.assertTrue(page.dimensionsWidth.isEnabled());
        extentTest.info("Width bölümü erisilebilir oldugu dogrulandı");

        Assert.assertTrue(page.dimensionsHeight.isEnabled());
        extentTest.info("Height bölümü erisilebilir oldugu dogrulandı");

        // "Weight (kg)" bölümüne tıklanarak kilo girişi yapılır
        page.shippingWeight.sendKeys("5");
        extentTest.info("Weight (kg) bölümüne tiklanarak kilo girisi yapildi");
        Thread.sleep(3000);

        // "Dimensions (cm)" bölümüne tıklanarak boyutlar girilir
        actions.sendKeys(Keys.TAB).sendKeys("5").sendKeys(Keys.TAB).sendKeys("4").sendKeys(Keys.TAB).sendKeys("3")
                .sendKeys(Keys.END).sendKeys(Keys.TAB).perform();
        extentTest.pass("Dimensions bölümüne tiklanarak boyutlar girildi");
        Thread.sleep(1000);

        ReusableMethods.getScreenshot("US009_TC01");
    }
}
