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
public class US002_TC03 extends TestBaseRapor {
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
        etkaPage.jse.executeScript("arguments[0].click();", etkaPage.myAccount);
        extentTest.info("My Account'a tıklandı.");
        // Dashboard altında "Store Manager" butonunun görünürlüğü doğrulanmalı
        Assert.assertTrue(etkaPage.storeManagerButton.isDisplayed());
        extentTest.info("Dashboard altında Store Manager bölümünün görünür olduğu test edildi.");
        // Dashboard altında "Orders" butonunun görünürlüğü doğrulanmalı
        Assert.assertTrue(etkaPage.ordersButton.isDisplayed());
        extentTest.info("Dashboard altında Orders bölümünün görünür olduğu test edildi.");
        // Dashboard altında "Downloads" butonunun görünürlüğü doğrulanmalı
        Assert.assertTrue(etkaPage.downloadsButton.isDisplayed());
        extentTest.info("Dashboard altında downloads bölümünün görünür olduğu test edildi.");
        // Dashboard altında "Adresses" butonunun görünürlüğü doğrulanmalı
        Assert.assertTrue(etkaPage.addressesButton.isDisplayed());
        extentTest.info("Dashboard altında Adresses bölümünün görünür olduğu test edildi.");
        // Dashboard altında "Account details" butonunun görünürlüğü doğrulanmalı
        Assert.assertTrue(etkaPage.accountDetailsButton.isDisplayed());
        extentTest.info("Dashboard altında Account Details bölümünün görünür olduğu test edildi.");
        // Dashboard altında "Wishlist" butonunun görünürlüğü doğrulanmalı
        Assert.assertTrue(etkaPage.wishListButton.isDisplayed());
        extentTest.info("Dashboard altında wishlist bölümünün görünür olduğu test edildi.");
        // Dashboard altında "Support Tickets" butonunun görünürlüğü doğrulanmalı
        Assert.assertTrue(etkaPage.supportTicketsButton.isDisplayed());
        extentTest.info("Dashboard altında Support Ticket bölümünün görünür olduğu test edildi.");
        // Dashboard altında "Followings" butonunun görünürlüğü doğrulanmalı
        Assert.assertTrue(etkaPage.followingsButton.isDisplayed());
        extentTest.info("Dashboard altında Following bölümünün görünür olduğu test edildi.");
        // Dashboard altında "Logout" butonunun görünürlüğü doğrulanmalı
        Assert.assertTrue(etkaPage.logOutButton.isDisplayed());
        extentTest.pass("Dashboard altında Logout bölümünün görünür olduğu test edildi.");
        //Dirver kapatılır.
        Driver.closeDriver();
    }
}