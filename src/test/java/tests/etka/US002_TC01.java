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
public class US002_TC01 extends TestBaseRapor {
    EtkaPage etkaPage=new EtkaPage();
    Actions actions=new Actions(Driver.getDriver());
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
        //"My Account" yazısının açılan sayfa sonunda görüldüğü doğrulanır
        ReusableMethods.waitFor(2);
        Assert.assertTrue(etkaPage.myAccount.isDisplayed());
        extentTest.pass("My Account görünür olduğu test edildi.");
        //Driver kapatılır.
        Driver.closeDriver();
    }
}
