package tests.etka;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EtkaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;
public class US002_TC02 extends TestBaseRapor {
    EtkaPage etkaPage = new EtkaPage();
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void test1() {
        extentTest = extentReports.createTest("Vendor olarak giriş", "Vendor email ve password ile giriş testi");
        //Belirtilen Url ye gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Allover anasayfaya gidildi.");
        //"Singin" butonuna tıklanır
        etkaPage.signIn.click();
        extentTest.info("Sign in'e tıklandı.");
        //"Username or email adress" bölümüne vendor email girilir
        //"Password" bölümüne verdor password girilir
        //"Sing in" butonuna tıklanır
        actions.click(etkaPage.signInEmail)
                .sendKeys(ConfigReader.getProperty("alloverValidEmail"), Keys.TAB)
                .sendKeys(ConfigReader.getProperty("alloverValidPassword"))
                .sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER).perform();
        ReusableMethods.waitFor(2);
        extentTest.info("Email ve password bölümlerine giriş yapıldı, sign in tıklandı.");
        //"My Account" yazısının açılan sayfa sonunda görüldüğü doğrulanır.
        ReusableMethods.waitFor(2);
        Assert.assertTrue(etkaPage.myAccount.isDisplayed());
        extentTest.info("My Account yazısının görünür olduğu test edildi.");
        ReusableMethods.waitFor(3);
        etkaPage.jse.executeScript("arguments[0].click();",etkaPage.myAccount);
        extentTest.info("My Account'a tıklandı.");
        //alloverPage.myAccount.submit();
        //"Orders" bölümünün görünürlüğü doğrulanmalı
        Assert.assertTrue(etkaPage.orders.isDisplayed());
        extentTest.info("Orders bölümünün görünür olduğu test edildi.");
        //"Downloads" bölümünün görünürlüğü doğrulanmalı
        Assert.assertTrue(etkaPage.downloads.isDisplayed());
        extentTest.info("Downloads bölümünün görünür olduğu test edildi.");
        //"Addresses" bölümünün görünürlüğü doğrulanmalı
        Assert.assertTrue(etkaPage.adresses.isDisplayed());
        extentTest.info("Adresses bölümünün görünür olduğu test edildi.");
        //"Account details" bölümünün görünürlüğü doğrulanmalı
        Assert.assertTrue(etkaPage.accountDetails.isDisplayed());
        extentTest.info("Account details bölümünün görünür olduğu test edildi.");
        //"Wishlist" bölümünün görünürlüğü doğrulanmalı
        Assert.assertTrue(etkaPage.wishList.isDisplayed());
        extentTest.info("Wishlist bölümünün görünür olduğu test edildi.");
        //"Logout" bölümünün görünürlüğü doğrulanmalı
        Assert.assertTrue(etkaPage.logout.isDisplayed());
        extentTest.pass("Logout bölümünün görünür olduğu test edildi.");
        //Driver Kapatılır.
        Driver.closeDriver();
    }
}